import org.openqa.selenium.WebDriver;

public class Main {
    public static void main(String[] args) {
        DriverSingleton driverSingleton = DriverSingleton.getInstance();
        WebDriver driver = driverSingleton.getDriver();
        driver.get("https://bitheap.tech");
        driverSingleton.closeInstance();
    }
}
