package WindowAndFrameOperations;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WindowOperations {
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
	
	@Test(priority=1)
	public static void getAllWindowHandle(){
		loginToDashboard();
		driver.findElement(By.linkText("More")).click();
        driver.findElement(By.linkText("Popups")).click();
        String childWindowHandle = "";
		String currentWindowHandle = driver.getWindowHandle();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//a[@id='btn-two']")).click();
		System.out.println("Current Window Handle: " + currentWindowHandle);
		Set<String> windowHandles = driver.getWindowHandles();
		for(String windowHandle : windowHandles){
			System.out.println(windowHandle);
			if(windowHandle.equalsIgnoreCase(currentWindowHandle)){
				
			} else {
				childWindowHandle = windowHandle;
			}
		}
		
		//switch to the popup handle
		driver.switchTo().window(childWindowHandle);
		String newWindowHandle = driver.getCurrentUrl().toString();
		System.out.println("Switched to: " + newWindowHandle);
	}
	
	@AfterTest
	public static void finalizeTest(){
		driver.quit();
	}
}
