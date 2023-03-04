package webElementOperations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TextBoxOperations {
    private static String projPath = System.getProperty("user.dir");
    private static WebDriver driver;

    @BeforeTest
    public static void initializeTest(){
        System.setProperty("webdriver.gecko.driver", projPath + "/src/main/resources/driver/geckodriver");
        driver = new FirefoxDriver();
        driver.get("http://magnus.jalatechnologies.com/");
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public static void textBoxEntry(){
        driver.findElement(By.xpath("//input[@id='UserName']")).sendKeys("training@jalaacademy.com");
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("jobprogram");
        System.out.println("Text entered in the textboxes");
    }

    @Test(priority = 2)
    public static void getTextboxAndPlaceholderValue(){
        String enteredUserName = driver.findElement(By.xpath("//input[@id='UserName']")).getAttribute("value");
        String placeholderUserName = driver.findElement(By.xpath("//input[@id=\"UserName\"]")).getAttribute("placeholder");
        System.out.println("The entered User Name is: " + enteredUserName);
        System.out.println("The placeholder for the Username is: " + placeholderUserName);
    }

    @Test(priority = 3)
    public static void clearTextboxEntry(){
        driver.findElement(By.xpath("//input[@id='Password']")).clear();
        System.out.println("The textbox is now cleared");
    }

    @Test(priority = 4)
    public static void checkTextBoxStatus(){
        boolean usernameFieldStatus = driver.findElement(By.xpath("//input[@id='UserName']")).isEnabled();
        if(!usernameFieldStatus){
            System.out.println("The username textbox is disabled");
        } else {
            System.out.println("The username textbox is enabled");
        }
    }

    @AfterTest
    public static void closeTest(){
        driver.quit();
    }
}
