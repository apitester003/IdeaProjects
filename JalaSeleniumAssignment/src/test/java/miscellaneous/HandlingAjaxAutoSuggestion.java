package miscellaneous;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HandlingAjaxAutoSuggestion {
	private static String projPath = System.getProperty("user.dir");
	private static WebDriver driver;
	private static WebDriverWait wait;
	private static Actions action;
	
	@BeforeTest
	public static void initializeTest(){
		System.setProperty("webdriver.gecko.driver", projPath + "/src/main/resources/driver/geckodriver"); 
		driver = new FirefoxDriver();
		driver.get("http://busindia.com/");
	}
	
	@Test
	public static void startTest(){
		action = new Actions(driver);
		String currentWindowHandle = driver.getWindowHandle();
		
		//Selecting Roundtrip
		action.moveToElement(driver.findElement(By.xpath("//input[@name='radOnewayOrReturnTrip' and contains(@value, 'R')]")));
		action.click();
		
		//From
		action.moveToElement(driver.findElement(By.xpath("//input[@id='matchFromPlace']")));
		action.click();
		action.sendKeys("udu");
		action.sendKeys(Keys.ARROW_DOWN);
		action.sendKeys(Keys.ARROW_DOWN);
		action.sendKeys(Keys.ARROW_DOWN);
		action.sendKeys(Keys.RETURN);
		action.build().perform();
		
		//To
		action.moveToElement(driver.findElement(By.xpath("//input[@id='matchToPlace']")));
		action.click();
		action.sendKeys("hyder");
		action.sendKeys(Keys.ARROW_DOWN);
		action.sendKeys(Keys.ARROW_DOWN);
		action.sendKeys(Keys.ARROW_DOWN);
		action.sendKeys(Keys.RETURN);
		action.build().perform();
		
		//Departure Date
		action.moveToElement(driver.findElement(By.xpath("//input[@id='txtdeptDateRtrip']")));
		action.click().build().perform();
		action.moveToElement(driver.findElement(By.xpath("//div[@id=\"ui-datepicker-div\"]/div[2]/div[1]/a[1]")));
		action.click().build().perform();		
		action.moveToElement(driver.findElement(By.xpath("//div[@id=\"ui-datepicker-div\"]/div[2]/div[1]/a[1]")));
		action.click().build().perform();
		action.moveToElement(driver.findElement(By.xpath("//div[@id=\"ui-datepicker-div\"]/div[2]/table[1]/tbody/tr[3]/child::td[@data-month='5' and @data-year='2023'][4]/a")));
		action.click().build().perform();
		
		//-------used this, as a workaround as the departure or send dates were not showing
		action.moveToElement(driver.findElement(By.xpath("//button[contains(text(),'Search') and contains(@class,'btn-search3')]")));
		action.click().build().perform();
		//---------
		
		//Return Date
		//((JavascriptExecutor) driver).executeScript("document.getElementById('txtretnDateRtrip')setAttribute('value','15/06/2023')");
		action.moveToElement(driver.findElement(By.id("txtretnDateRtrip")));
		action.click().build().perform();
		action.moveToElement(driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[2]/div/a")));
		action.click().build().perform();		
		action.moveToElement(driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[2]/div/a")));
		action.click().build().perform();
		action.moveToElement(driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[2]/div/a")));
		action.click().build().perform();
		action.moveToElement(driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[2]/table/tbody/tr[3]/td[4]")));
		action.click().build().perform();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10L));		
		
		action.moveToElement(driver.findElement(By.xpath("//button[contains(text(),'Search') and contains(@class,'btn-search3')]")));
		action.doubleClick().build().perform();
	}
	
	@AfterTest
	public static void finishTest(){
		driver.close();
	}
}
