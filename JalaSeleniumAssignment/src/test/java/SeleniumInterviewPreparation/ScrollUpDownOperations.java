package SeleniumInterviewPreparation;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ScrollUpDownOperations {
	private static String projPath = System.getProperty("user.dir");
	private static WebDriver driver;
	private static Actions action;
	
	@BeforeTest
	public static void initializeTest(){
		System.setProperty("webdriver.gecko.driver", projPath + "/src/main/resources/driver/geckodriver");
		driver = new FirefoxDriver();
		driver.get("https://www.tutorialspoint.com/how-to-scroll-the-page-up-or-down-in-selenium-webdriver-using-java");
	}
	
	@Test
	public static void scrollTest(){
		action = new Actions(driver);
		action.sendKeys(Keys.PAGE_UP);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10L));
		action.sendKeys(Keys.PAGE_DOWN);
		action.sendKeys(Keys.PAGE_DOWN);
		action.sendKeys(Keys.PAGE_DOWN);
		action.sendKeys(Keys.PAGE_DOWN);
		action.build().perform();
	}
	
	@AfterTest
	public static void finishTest(){
		driver.close();
	}
}
