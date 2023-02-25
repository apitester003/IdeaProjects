import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumWaits {
    private static String projectDir = System.getProperty("user.dir");
    private static WebDriver driver;

    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", projectDir + "/driver/geckodriver");
        driver = new FirefoxDriver();
        driver.get("file:///home/diyu/IdeaProjects/SeleniumTutorial/includes/SeleniumAlertsDemo/alerts.html");

        //implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement basicAlertButton = driver.findElement(By.xpath("//body/button[1]"));
        /*basicAlertButton.click();
        //Explicit Wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert basicAlert = driver.switchTo().alert();
        basicAlert.accept();*/

        /*WebElement confirmationAlertButton = driver.findElement(By.xpath("//body/button[2]"));
        confirmationAlertButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert confirmationAlert = driver.switchTo().alert();
        confirmationAlert.dismiss();*/

        WebElement promptAlertButton = driver.findElement(By.xpath("//body/button[3]"));
        promptAlertButton.click();
        Alert promptAlert = driver.switchTo().alert();
        promptAlert.sendKeys("My Name is Sam");
        System.out.println(promptAlert.getText());
        promptAlert.accept();
        driver.close();
    }
}
