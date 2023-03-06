package WindowAndFrameOperations;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class IFrameOperations {
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
	
	@Test
	public static void iframeOperations(){
		loginToDashboard();
		driver.findElement(By.linkText("More")).click();
        driver.findElement(By.linkText("iFrames")).click();
        
        //Select the iframe and click the menu
        driver.switchTo().frame(driver.findElement(By.id("iframe2")));
        driver.findElement(By.xpath("/html/body/div[2]/header/nav")).click();
	}
	
	@AfterTest
	public static void finalizeTest(){
		driver.quit();
	}
}
