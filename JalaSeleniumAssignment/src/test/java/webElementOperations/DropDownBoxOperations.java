package webElementOperations;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DropDownBoxOperations {
	private static String projPath = System.getProperty("user.dir");
	private static WebDriver driver;
	
	@BeforeTest
	public static void initializeTest(){
		System.setProperty("webdriver.gecko.driver", projPath + "/src/main/resources/driver/geckodriver");
		driver = new FirefoxDriver();
		driver.get("http://magnus.jalatechnologies.com/");
		driver.manage().window().maximize();
	}
	
	private static WebElement loginToDashboardSelectWebElement(){
		driver.findElement(By.xpath("//input[@id='UserName']")).sendKeys("training@jalaacademy.com");
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("jobprogram");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//button[@id='btnLogin']")).click();
		driver.findElement(By.linkText("Employee")).click();
        driver.findElement(By.linkText("Create")).click();
        //driver.findElement(By.xpath("//span[@class = 'form-control']//parent::div"));
        WebElement countryDropdown = driver.findElement(By.xpath("//select[@id='CountryId']"));
		return countryDropdown;
	}
	
	@Test(priority=1, enabled=false) 
	public static void printAllDropdownOptions(){
		WebElement countryDropdown = loginToDashboardSelectWebElement();
        Select country = new Select(countryDropdown);
        List<WebElement> getAllDropdown = country.getOptions();
        /*Iterator<WebElement> itr = getAllDropdown.iterator();
        while(itr.hasNext()){
        	System.out.println("Option Val: " + itr.next().getAttribute("value"));
        	System.out.println("Option Text: " + itr.next().getText());
        	
        	System.out.println();
        }*/
        for(WebElement countryVal : getAllDropdown){
        	System.out.println("Option Val: " + countryVal.getAttribute("value"));
        	System.out.println("Option Text: " + countryVal.getText());
        	
        	System.out.println();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Test(priority=2)
	public static void getFirstSelectedOption(){
		WebElement countryDropdown = loginToDashboardSelectWebElement();
		Select country = new Select(countryDropdown);
		//Select By Index
		//country.selectByIndex(2);
		
		//Select By Value
		country.selectByValue("1");
		
		//Select By Visible Text
		//country.selectByVisibleText("Japan");
		
		//get the selected option
		System.out.println(country.getFirstSelectedOption().getText());
	}
	
	
	@AfterTest
	public static void finishTest(){
		driver.close();
	}
}
