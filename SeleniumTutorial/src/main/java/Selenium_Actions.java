import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Selenium_Actions {
    private static String projPath = System.getProperty("user.dir");
    private static WebDriver driver;

    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", projPath + "/driver/geckodriver");
        driver = new FirefoxDriver();
        driver.get("https://jqueryui.com/droppable/");
        driver.manage().window().maximize();

        driver.switchTo().frame(driver.findElement(By.cssSelector("#content > iframe")));

        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));

        Actions dragAndDropAction = new Actions(driver);
        dragAndDropAction.dragAndDrop(draggable, droppable).build().perform();

        Actions rightclickInside = new Actions(driver);
        rightclickInside.contextClick().build().perform();

        Actions actionObj = new Actions(driver);
        actionObj.keyDown(Keys.F1);
    }
}
