package webElementOperations;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LinkOperations {
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
		driver.findElement(By.linkText("More")).click();
        driver.findElement(By.linkText("Links")).click();
        driver.findElement(By.linkText("Working Links")).click();
	}
	
	@Test(priority = 1)
	public static void getLinkTextAndColor(){
		loginToDashboard();
		WebElement firstLink = driver.findElement(By.linkText("Link 1"));
		String linkColor = firstLink.getCssValue("color");
		System.out.println("RGB Value: " + linkColor);
		String hexValue = Color.fromString(linkColor).asHex();
		System.out.println("Hex Value: " + hexValue);
		
		//identify element with text() xpath
        WebElement conText = driver.findElement(By.xpath("//a[text()='Link 1']"));
        
        //identify element with contains xpath
        WebElement contain = driver.findElement(By.xpath("//a[contains(text(), 'Link')]"));
        
        // find an element that starts-with()
        WebElement start =driver.findElement(By.xpath("//*[starts-with(@id,'UserName')]"));
        
        //Finding Current Node
        driver.findElement(By.xpath("//span[@class = 'active']"));
        
        // XPath of children elements of current node using child axis
        driver.findElement(By.xpath("//span[@class = 'active']//child::a"));
        
        //nodes using preceding-sibling axis
        driver.findElement(By.xpath("///a[text() = 'Link 2']//preceding-sibling::a"));
	}
	
	@AfterTest
	public static void finishTest(){
		driver.close();
	}
}
