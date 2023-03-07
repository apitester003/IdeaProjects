package miscellaneous;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class ClickAlinkInsideIframe {
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
        driver.findElement(By.id("UserName")).sendKeys("training@jalaacademy.com");
        driver.findElement(By.id("Password")).sendKeys("jobprogram");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.id("btnLogin")).click();
    }

    @Test
    public static void iframeTest(){
        loginToDashboard();
        driver.findElement(By.linkText("More")).click();
        driver.findElement(By.linkText("iFrames")).click();

        //Wait till the iframe2 is available.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60L));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("iframe2"))));

        WebElement requiredIframe = driver.findElement(By.id("iframe2"));
        driver.switchTo().frame(requiredIframe);
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[1]/div/div/p/a")).click();
        //switch back to the Dashboard
        driver.switchTo().defaultContent();
    }

    @AfterTest
    public static void finishTest(){
        driver.close();
    }
}
