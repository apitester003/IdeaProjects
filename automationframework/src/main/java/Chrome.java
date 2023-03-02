import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Chrome implements DriverStrategy {
    private static String projectPath = System.getProperty("user.dir");

    public WebDriver setStrategy() {
        System.setProperty("webdriver.chrome.driver", projectPath + "/src/main/resources/driver/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("useAutomationExtension", false);
        options.addArguments("--no-sandbox");

        return new ChromeDriver(options);
    }
}
