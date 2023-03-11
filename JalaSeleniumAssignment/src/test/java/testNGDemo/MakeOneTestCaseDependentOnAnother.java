package testNGDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

public class MakeOneTestCaseDependentOnAnother {
	private static String projPath = System.getProperty("user.dir");
	private static WebDriver driver;
	private static Actions action;
	private static WebDriverWait wait;
	
	@BeforeTest
	public static void initializeTest(){
		System.setProperty("webdriver.gecko.driver", projPath + "/src/main/resources/driver/geckodriver");
		driver = new FirefoxDriver();
		driver.get("http://magnus.jalatechnologies.com/");
		action = new Actions(driver);
	}
	
	
	@Test(dependsOnMethods = {"fillLoginDetails"}, invocationCount=5)
	public static void submitBUtton(){
		System.out.println("clicking the button");
		action.moveToElement(driver.findElement(By.xpath("//button[@id='btnLogin']")));
		action.click();
		action.build().perform();
	}
	
	@Test
	@Parameters({"username","password"})
	public static void fillLoginDetails(String login, String password){
		action.moveToElement(driver.findElement(By.xpath("//input[@id='UserName']")))
			  .click()
			  .sendKeys(login).build().perform();
		action.moveToElement(driver.findElement(By.xpath("//input[@id='Password']")))
			  .click()
			  .sendKeys(password).build().perform();
	}
	
	@AfterTest
	public static void afterTest(){
		//driver.close();
	}
}
