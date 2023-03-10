package miscellaneous;




import java.io.File;
import java.io.FileInputStream;
import java.util.Set;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CookieManagement {
	private static String projPath = System.getProperty("user.dir");
	private static WebDriver driver;
	private static File file;
	private static String fileName = "test_excel.xlsx";
	
	@BeforeTest
	public static void initializeTest(){
		System.setProperty("webdriver.gecko.driver", projPath + "/src/main/resources/driver/geckodriver");
		driver = new FirefoxDriver();
		driver.get("http://localhost");
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
	
	/*@Test(priority=6,enabled = false)
	public static void importCookiesFromExcel(){
		try{
			Workbook passwordCookieListWorkbook;
			String cookieName = null, cookiePassword = null;

			//Create an object of File class to open xlsx file
			file = new File(projPath + "/src/test/java/main/resources/includes/" + fileName);
			FileInputStream fileInputStream = new FileInputStream(file);

			//Find the file extension by splitting file name in substring  and getting only extension name
			String fileExtensionName = fileName.substring(fileName.indexOf('.'));

			//For .xls
			//passwordCookieListWorkbook = new HSSFWorkbook(fileInputStream);
			//Sheet passwordSheet = passwordCookieListWorkbook.getSheet("Sheet1");

			//For .xlsx
			passwordCookieListWorkbook = new XSSFWorkbook(fileInputStream);
			Sheet passwordSheet = passwordCookieListWorkbook.getSheet("Sheet1");

			//Find number of rows in excel file
			int rowCount = passwordSheet.getLastRowNum() - passwordSheet.getFirstRowNum();
			//loop through the rows
			for(int i = 1; i < rowCount + 1; i++){
				Row row = passwordSheet.getRow(i);
				cookieName = row.getCell(0).getStringCellValue();
				cookiePassword = row.getCell(1).getStringCellValue();
				driver.manage().addCookie(new Cookie(cookieName, cookiePassword));
			}

		} catch(Exception e) {
			e.printStackTrace();
		}

	}*/
	
	@AfterTest
	public static void finishTest(){
		driver.close();
	}
}
