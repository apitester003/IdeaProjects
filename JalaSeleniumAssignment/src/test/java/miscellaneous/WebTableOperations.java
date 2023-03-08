package miscellaneous;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WebTableOperations {
	private static String projDir = System.getProperty("user.dir");
	private static WebDriver driver;
	private static Actions action;
	
	@BeforeTest
	public static void initializeTest(){
		System.setProperty("webdriver.gecko.driver", projDir + "/src/main/resources/driver/geckodriver");
		driver = new FirefoxDriver();
		driver.get("http://magnus.jalatechnologies.com/");
		driver.manage().window().maximize();
		action = new Actions(driver);
	}
	
	private static void loginToDashboard(){
		WebElement userNameField = driver.findElement(By.xpath("//input[@id='UserName']"));
		WebElement passwordField = driver.findElement(By.xpath("//input[@id='Password']"));
		WebElement loginButtonField = driver.findElement(By.xpath("//button[@id='btnLogin']"));
		
		action.moveToElement(userNameField)
			.click(userNameField)
			.sendKeys("training@jalaacademy.com");
		
		action.moveToElement(passwordField)
			.click(passwordField)
			.sendKeys("jobprogram");
		
		action.moveToElement(loginButtonField)
			.click();		
	}
	
	private static void accessTheWebTable(){
		driver.findElement(By.linkText("Employee")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7L));

        driver.findElement(By.linkText("Search")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7L));
        
        driver.findElement(By.id("Name")).sendKeys("Sai");
        driver.findElement(By.id("btnSearch")).click();
	}
	
	@Test
	public static void startWebTableTest(){
		loginToDashboard();
		action.build().perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10L));
		accessTheWebTable();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10L));
		
		//Get the Row count
		List<WebElement> tableRows = driver.findElements(By.xpath("//table[@id='tblEmployee']//child::tbody/tr"));
		System.out.println("The total number of results are: " + tableRows.size());
		
		//Get data from a specific cell
		String val = driver.findElement(By.xpath("//table[@id='tblEmployee']//child::tbody/tr[6]/td[8]")).getText();
		System.out.println("The value in the cell is: " + val);
		
		//Get the column count
		List<WebElement> tableColumns = driver.findElements(By.xpath("//table[@id='tblEmployee']//child::tbody/tr[6]/td"));
		System.out.println("The total number of table columns are: " + tableColumns.size());
	}
	
	@AfterTest
	public static void finishTest(){
		driver.close();
	}
}
