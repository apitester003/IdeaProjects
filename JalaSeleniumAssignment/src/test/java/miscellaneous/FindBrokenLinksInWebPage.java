package miscellaneous;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

public class FindBrokenLinksInWebPage {
    private static String projPath = System.getProperty("user.dir");
    private static WebDriver driver;
    private static HttpURLConnection huc;
    private static int respCode = 200;

    @BeforeTest
    public static void initializeTest(){
        System.setProperty("webdriver.gecko.driver", projPath + "/src/main/resources/driver/geckodriver");
        driver = new FirefoxDriver();
        driver.get("http://www.zlti.com");
    }

    @Test
    public static void findBrokenLinks(){
        List<WebElement> listOfLinks = driver.findElements(By.tagName("a"));
        Iterator<WebElement> itr = listOfLinks.iterator();
        while(itr.hasNext()){
            String url = itr.next().getAttribute("href");
            try{
                huc = (HttpURLConnection)(new URL(url).openConnection());
                huc.setRequestMethod("HEAD");
                huc.connect();
                respCode = huc.getResponseCode();

                if(respCode >= 400){
                    System.out.println("The " + url + " is broken");
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @AfterTest
    public static void finishTest(){
        driver.close();
    }
}
