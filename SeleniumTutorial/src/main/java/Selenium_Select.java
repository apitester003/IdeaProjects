import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Selenium_Select {
    private static String projPath = System.getProperty("user.dir");
    private static WebDriver driver;

    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", projPath + "/driver/geckodriver");
        driver = new FirefoxDriver();
        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select");
        driver.manage().window().maximize();
        driver.switchTo().frame(driver.findElement(By.id("iframeResult")));
        WebElement selectable = driver.findElement(By.xpath("//select[@name='cars']"));

        Select sel = new Select(selectable);
        sel.selectByIndex(1);
        System.out.println(sel.getFirstSelectedOption().getAttribute("value"));

    }
}
