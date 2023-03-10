package miscellaneous;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CookieAndBrowserProfileManagement {
	private static String projPath = System.getProperty("user.dir");
	private static WebDriver driver;
	
	@BeforeTest
	public static void initializeTest(){
		System.setProperty("webdriver.gecko.driver", projPath + "/src/main/resources/driver/geckodriver");
		driver = new FirefoxDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php");
	}
	
	@Test(priority = 1, enabled = false)
	public static void getAllCookies(){
		Set<Cookie> allCookies = driver.manage().getCookies();
		for(Cookie ck : allCookies){
			System.out.println(ck.getName() + "| " + ck.getValue() + "| " + ck.getDomain() + "| " + ck.getPath());
		}
	}
	
	@Test(priority = 2, enabled=false)
	public static void getAParticularCookie(){
		Cookie cookieDetails = driver.manage().getCookieNamed("orangehrm");	//833580e189cc40328cafdac198fc621d
		System.out.println(cookieDetails.getName() + "| " + cookieDetails.getValue() + "| " + cookieDetails.getPath() + "| " + cookieDetails.getDomain() );
	}
	
	@Test(priority=3, enabled=false)
	public static void deleteCookie(){
		driver.manage().deleteCookieNamed("orangehrm");
		if(driver.manage().getCookieNamed("orangehrm") != null){
			System.out.println("The cookie is available");
		} else {
			System.out.println("The cookie is not available");
		}
	}
	
	@Test(priority=4, enabled=false)
	public static void addACookie(){
		driver.manage().addCookie(new Cookie("newVal", "GiliGiliGoo"));
		//Retrieve all the current cookies
		Set<Cookie> getAllCookies = driver.manage().getCookies();
		for(Cookie ck : getAllCookies){
			System.out.println(ck.getName() + "| " + ck.getValue());
		}
	}
	
	@Test(priority=5, enabled=false)
	public static void deleteAllCookies(){
		driver.manage().deleteAllCookies();
		//Check if there are any cookies present now
		Set<Cookie> ck = driver.manage().getCookies();
		System.out.println(ck.size());
	}
	
	@Test(priority=6)
	public static void importCookiesFromExcel(){
		
	}
	
	@AfterTest
	public static void finishTest(){
		driver.close();
	}
}
