package webElementOperations;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PopupsAlertsOperations {
	private static String projPath = System.getProperty("user.dir");
	private static WebDriver driver;
	
	@BeforeTest
	public static void initializeTest(){
		System.setProperty("webdriver.gecko.driver", projPath + "/src/main/resources/driver/geckodriver");
		driver = new FirefoxDriver();
		driver.get("http://magnus.jalatechnologies.com/");
		driver.manage().window().maximize();
	}
	
	private static void loginToDashboard(){
		driver.findElement(By.xpath("//input[@id='UserName']")).sendKeys("training@jalaacademy.com");
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("jobprogram");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//button[@id='btnLogin']")).click();
	}
	
	@Test(priority=1, enabled=false)
	public static void alertBoxOperations(){
		loginToDashboard();
		driver.findElement(By.linkText("More")).click();
        driver.findElement(By.linkText("Popups")).click();
		driver.findElement(By.xpath("//button[@id='alertBtn']")).click();
		Alert alertBox = driver.switchTo().alert();
		String alertBoxMessage = alertBox.getText().toString();
		System.out.println("Alert Box Text: " + alertBoxMessage);
		alertBox.accept();
	}
	
	@Test(priority=2)
	public static void promptBoxOperations(){
		loginToDashboard();
		driver.findElement(By.linkText("More")).click();
        driver.findElement(By.linkText("Popups")).click();
		driver.findElement(By.xpath("//button[@id='promptBtn']")).click();
		//switch to the promptbox
		Alert promptBox = driver.switchTo().alert();
		promptBox.sendKeys("Hi this is Sam");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		promptBox.accept();
	}
	
	@AfterTest
	public static void finalizeTest(){
		driver.quit();
	}
}
