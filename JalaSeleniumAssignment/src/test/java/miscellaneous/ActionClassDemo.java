package miscellaneous;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ActionClassDemo {
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
	
	@Test(priority = 1)
	public static void keyBoardKeyPress(){
		WebElement usernameField = driver.findElement(By.xpath("//input[@id='UserName']"));
		usernameField.sendKeys("training@jalaacademy.com");
		WebElement passwordField = driver.findElement(By.xpath("//input[@id='Password']"));
		action.moveToElement(passwordField);
		action.click(passwordField);
		action.sendKeys("jobprogram");
		action.moveToElement(usernameField);
		action.doubleClick();
		action.keyDown(Keys.CONTROL);
		action.keyDown("a");
		action.build().perform();
	}
	
	@AfterTest
	public static void finishTest(){
		driver.close();
	}
}
