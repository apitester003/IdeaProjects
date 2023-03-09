package SeleniumInterviewPreparation;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public class ExplicitWaitDemo {
	private static String projPath = System.getProperty("user.dir");
	private static WebDriver driver;
	private static WebDriverWait wait;
	
	@BeforeTest
	public static void initializeTest(){
		System.setProperty("webdriver.gecko.driver", projPath + "/src/main/resources/driver/geckodriver");
		driver = new FirefoxDriver();
		driver.get("https://magnus.jalatechnologies.com/");
	}
	
	@Test
	public static void startTest(){
		WebElement buttonElement = driver.findElement(By.xpath("//button[@id='btnLogin']"));
		//Explicit wait
		wait = new WebDriverWait(driver, Duration.ofSeconds(20L));
		wait.until(ExpectedConditions.visibilityOf(buttonElement));
		
		driver.findElement(By.xpath("//input[@id='UserName']")).sendKeys("training@jalaacademy.com");
		driver.findElement(By.id("Password")).sendKeys("jobprogram");
		
		//Implicit Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4L));
		buttonElement.click();
	}
	
	@AfterTest
	public static void finishTest(){
		//driver.close();
	}
}
