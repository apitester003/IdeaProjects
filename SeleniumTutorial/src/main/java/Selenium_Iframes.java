import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Selenium_Iframes {
    private static String projectDir = System.getProperty("user.dir");
    private static WebDriver driver;

    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", projectDir + "/driver/geckodriver");
        driver = new FirefoxDriver();
        driver.get("https://www.w3schools.com/html/html_iframe.asp");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //System.out.println(title);
        //String title = driver.switchTo().frame(0).findElement(By.cssSelector("#main > h1")).getText();
        driver.switchTo().frame(0).findElement(By.cssSelector("#topnav > div > div.w3-bar.w3-left > a:nth-child(5)")).click();

        driver.close();
    }
}
