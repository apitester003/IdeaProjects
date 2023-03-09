package SeleniumInterviewPreparation;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TabOperationsInSelenium {
	private static String ProjectPath = System.getProperty("user.dir");
	private static WebDriver driver;
	private static Actions action;
	
	@BeforeTest
	public static void initializeTest(){
		System.setProperty("webdriver.gecko.driver", ProjectPath + "/src/main/resources/driver/geckodriver");
		driver = new FirefoxDriver();
		driver.get("https://www.amazon.in/");		
	}
	
	@Test
	public static void startTest() throws InterruptedException{
		String currentWindowHandle = driver.getWindowHandle();
		action = new Actions(driver);
		Thread.sleep(20000);
		action.moveToElement(driver.findElement(By.xpath("//div[@id='nav-xshop']/a[1]")));
		action.keyDown(Keys.CONTROL).click().keyUp(Keys.CONTROL);
		//action.sendKeys("T");
		action.build().perform();
		
		String newTab = "";
		Set<String> openTabs = driver.getWindowHandles();
		for(String tab : openTabs){
			if(!tab.equals(currentWindowHandle)){
				newTab = tab;
			}
		}
		
		System.out.println("New Window Handle: " + newTab);
		driver.switchTo().window(newTab);
		Thread.sleep(4000);
		System.out.println("Old Window Handle: " + currentWindowHandle);
		driver.switchTo().window(currentWindowHandle);
	}
	
	@AfterTest
	public static void finalizeTest(){
		driver.close();
	}
}
