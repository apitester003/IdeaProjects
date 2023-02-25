import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Iterator;
import java.util.List;

public class TableOperations {
    private static String projectPath = System.getProperty("user.dir");
    private static WebDriver driver;
    private static WebElement webElement;

    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", projectPath + "/driver/geckodriver");
        driver = new FirefoxDriver();
        driver.get("file:///home/diyu/IdeaProjects/SeleniumTutorial/includes/SeleniumDemo/tablePage.html");
        String value = driver.findElement(By.xpath("//tbody/tr[2]/td[1]")).getText();
        System.out.println(value);
        String heading = driver.findElement(By.xpath("//tbody/tr[1]/th/following-sibling::th")).getText();
        System.out.println(heading);

        List<WebElement> listOfHeadings = driver.findElements(By.xpath("//tbody/tr"));
        for(WebElement individualHeading : listOfHeadings){
            System.out.println(individualHeading.getText());
        }
        driver.close();
    }
}
