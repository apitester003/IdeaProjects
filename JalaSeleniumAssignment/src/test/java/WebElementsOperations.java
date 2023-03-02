import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WebElementsOperations {
    private static String projPath = System.getProperty("user.dir");
    private static WebDriver driver;

    @BeforeTest
    public static void initializeTest(){
        System.setProperty("webdriver.gecko.driver", projPath + "/src/main/resources/driver/geckodriver");
        driver = new FirefoxDriver();
        driver.get("http://magnus.jalatechnologies.com/");
        driver.manage().window().maximize();
    }

    @Test
    public static void textBoxTests(){

    }

    @AfterTest
    public static void closeTest(){
        driver.quit();
    }
}
