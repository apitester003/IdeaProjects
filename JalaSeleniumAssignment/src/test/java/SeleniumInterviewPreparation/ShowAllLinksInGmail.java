package SeleniumInterviewPreparation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ShowAllLinksInGmail {
	private static String ProjectPath = System.getProperty("user.dir");
	private static WebDriver driver;
	
	@BeforeTest
	public static void initializeTest(){
		System.setProperty("webdriver.gecko.driver", ProjectPath + "/src/main/resources/driver/geckodriver");
		driver = new FirefoxDriver();
		driver.get("https://www.gmail.com/");
		
	}
	
	@Test
	public static void startTest(){
		List<WebElement> tagList = driver.findElements(By.tagName("a"));
		for(WebElement link : tagList){
			String tag = link.getAttribute("href");
			System.out.println(tag);
		}
	}
	
	@AfterTest
	public static void finishTest(){
		driver.close();
	}
}
