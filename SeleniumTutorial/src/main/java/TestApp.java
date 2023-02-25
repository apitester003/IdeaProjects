import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestApp {
    private static String projectPath = System.getProperty("user.dir");
    private static WebDriver driver;
    private static WebElement webElement;

    public static void main(String[] args){
        System.setProperty("webdriver.gecko.driver", projectPath + "/driver/geckodriver");
        driver = new FirefoxDriver();
        driver.get("http://www.wikipedia.org");
        driver.manage().window().maximize();

        //1-Getting Text From Webpage
        String title = driver.findElement(By.xpath("//span[contains(@class, 'svg-Wikipedia')]")).getText();
        System.out.println("The title is: " + title);

        //2-Clicking on a Webpage in Selenium
        //driver.findElement(By.xpath("//a[contains(@title, 'The Free')]")).sendKeys(Keys.RETURN);

        //3-Send Text to Webpage
        driver.findElement(By.id("searchInput")).sendKeys("Elon Musk");
        driver.findElement(By.xpath("//button[contains(@class, 'pure')]")).click();


        driver.close();
    }
}
