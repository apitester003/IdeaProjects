import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefox implements DriverStrategy {
    private static String projectPath = System.getProperty("user.dir");

    public WebDriver setStrategy() {
       System.setProperty("webdriver.gecko.driver", projectPath + "/src/main/resources/driver/geckodriver");
       WebDriver driver = new FirefoxDriver();
       return driver;
    }
}
