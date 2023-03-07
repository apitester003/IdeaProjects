package miscellaneous;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class ScreenshotDemo {
    private static String projPath = System.getProperty("user.dir");
    private static WebDriver driver;

    @BeforeTest
    public static void initializeTest(){
        System.setProperty("webdriver.gecko.driver", projPath + "/src/main/resources/driver/geckodriver");
        driver = new FirefoxDriver();
        driver.get("https://magnus.jalatechnologies.com/");
    }

    @Test
    public static void takeAScreenshot(){
        try {
            File screenShotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenShotFile, new File(projPath + "/src/main/resources/images/jala.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterTest
    public static void finishTests(){
        driver.close();
    }
}
