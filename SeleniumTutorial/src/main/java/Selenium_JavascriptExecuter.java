import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Selenium_JavascriptExecuter {
    private static String projPath = System.getProperty("user.dir");
    private static WebDriver driver;

    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", projPath + "/driver/geckodriver");
        driver = new FirefoxDriver();
        driver.get("https://www.udemy.com/course/core-java-programming-language-tutorial/");
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //WebElement signUpButton = driver.findElement(By.cssSelector("#udemy > div.ud-main-content-wrapper > div.ud-app-loader.ud-component--header-v6--header.ud-header.ud-app-loaded > div.ud-text-sm.header--header--1SLKV.header--flex-middle--2QeVR > div:nth-child(9) > a > span"));


        //1-Clicking with Javascript Executor
        //Process 1
        //((JavascriptExecutor) driver).executeScript("arguments[0].click;", signUpButton);

        //Process 2
        /*
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].click;", signUpButton);
        */

        //2-Setting up timeouts
        //((JavascriptExecutor) driver).executeScript("window.setTimeout(arguments[arguments.length-1], 1000);");

        //3-Changing the webpage
        //((JavascriptExecutor) driver).executeScript("window.location = 'https://wikipedia.com'");
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //4-Scroll the webpage
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1000)");

        driver.close();
    }
}
