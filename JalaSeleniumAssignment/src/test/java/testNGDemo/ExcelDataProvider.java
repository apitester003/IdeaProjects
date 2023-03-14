package testNGDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelDataProvider {
    private static String projPath = System.getProperty("user.dir");
    private static String excelPath = projPath + "/src/main/resources/includes/data.xlsx";
    private static String sheetName = "Sheet1";
    private static WebDriver driver;

    @BeforeTest
    public static void initializeTest(){
        System.setProperty("webdriver.gecko.driver", projPath + "/src/main/resources/driver/geckodriver");
        driver = new FirefoxDriver();
    }

    @DataProvider(name="test1data")
    public Object[][] getData(){
        Object[][] data = testData(excelPath, sheetName);
        return data;
    }

    @Test(dataProvider = "test1data")
    public void test1(String userName, String password){
        System.out.println(userName + " | " + password);

        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.findElement(By.name("username")).sendKeys(userName);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type=\"submit\" and contains(@class, 'orangehrm-login-button')]")).click();
    }

    public static Object[][] testData(String excelPath, String sheetName){
        String cellData = "";
        ExcelUtils excel = new ExcelUtils(excelPath, sheetName);
        int rowCount = excel.getRowCount();
        int colCount = excel.getColCount();
        Object data[][] = new Object[rowCount-1][colCount];
        for(int i=1; i<rowCount; i++){
            for(int j=0; j<colCount; j++){
                cellData = excel.getCellDataString(i, j);
                data[i-1][j] = cellData;
            }
        }
        return data;
    }
}
