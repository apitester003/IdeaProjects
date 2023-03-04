package webElementOperations;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class radioButtonAndCheckboxOperations {
    private static String projectDir = System.getProperty("user.dir");
    private static WebDriver driver;

    @BeforeSuite
    public static void initializeTest(){
        System.setProperty("webdriver.gecko.driver", projectDir + "/src/main/resources/driver/geckodriver" );
        driver = new FirefoxDriver();
        driver.get("https://demoqa.com/radio-button");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test(priority = 1)
    public static void selectRadioButtonByLabelText(){
        driver.findElement(By.xpath("//label[contains(text(),'Impressive')]/preceding-sibling::input[@id='impressiveRadio']")).sendKeys(Keys.SPACE);
    }

    @Test(priority = 2)
    public static void radioButtonContents(){
        List<WebElement> radioButtons = driver.findElements(By.name("like"));
        System.out.println("The total number of radio buttons are: " + radioButtons.size());

        //Get the radio button values
        System.out.println("The radio button values are: ");
        Iterator<WebElement> itr = radioButtons.iterator();
        while (itr.hasNext()){
            System.out.println(itr.next().getAttribute("value"));
        }
    }
    @Test(priority = 3)
    public static void getSelectedLabelText(){
        driver.findElement(By.xpath("//label[contains(text(),'Impressive')]/preceding-sibling::input[@id='impressiveRadio']")).sendKeys(Keys.SPACE);
        List<WebElement> radioButtons = driver.findElements(By.name("like"));
        for(WebElement radioElement : radioButtons){
            System.out.println("Enable Status: " + radioElement.isEnabled());
            boolean selectionStatus = radioElement.isSelected();
            System.out.println("Selection Status: " + selectionStatus);
            if(selectionStatus == true){
                System.out.println("Selected Id: " + radioElement.getAttribute("id"));
            }
            System.out.println("-----------");
        }
    }

    @AfterSuite
    public static void finishTest(){
        driver.close();
    }
}
