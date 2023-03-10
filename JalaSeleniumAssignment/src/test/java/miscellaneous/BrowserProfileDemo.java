package miscellaneous;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BrowserProfileDemo {
    private static String projPath = System.getProperty("user.dir");
    private static WebDriver driver;
    private static WebDriverWait wait;

    @BeforeTest
    public static void initializeTests(){
        System.setProperty("webdriver.gecko.driver", projPath + "/src/main/resources/driver/geckodriver");
        driver = new FirefoxDriver();
        driver.get("http://localhost");
    }

    @Test
    public static void startBrowserTest(){

    }

    @AfterTest
    public static void finishTest(){
        driver.close();
    }
}
