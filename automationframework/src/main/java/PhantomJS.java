import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class PhantomJS implements DriverStrategy {
    private static String projectPath = System.getProperty("user.dir");

    public WebDriver setStrategy() {
        System.setProperty("phantomjs.binary.path", projectPath + "/src/main/resources/driver/phantomjs-64bit/bin/phantomjs");
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setJavascriptEnabled(true);
        WebDriver driver = new PhantomJSDriver(desiredCapabilities);
        return driver;
    }
}
