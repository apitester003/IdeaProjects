package SeleniumInterviewPreparation;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.*;

public class ExcelOperationsInSelenium {
    private static String projPath = System.getProperty("user.dir");
    private static WebDriver driver;
    private static WebDriverWait wait;
    private static File src;
    private static FileInputStream inputStream;
    private static FileOutputStream outputStream;
    private static Workbook workbook;
    private static Sheet sheet;
    private static Cell cell;

    @BeforeTest
    public static void initializeTest(){
        System.setProperty("webdriver.gecko.driver", projPath + "/src/main/resources/driver/geckodriver");
    }

    @Test(priority=1,enabled = false)
    public static void createNewExcelSheet() throws IOException {
        //Create an empty excel workbook
        workbook = new XSSFWorkbook();

        //save the file
        outputStream = new FileOutputStream("/home/diyu/IdeaProjects/JalaSeleniumAssignment/src/main/resources/includes/new_test_excel.xlsx");
        workbook.write(outputStream);
    }

    @Test(priority = 2,enabled = false)
    public static void addANewRowInToTheExcelSheet() throws IOException {
        //Get the File
        src = new File("/home/diyu/IdeaProjects/JalaSeleniumAssignment/src/main/resources/includes/test_excel.xlsx");
        //Read the File
        inputStream = new FileInputStream(src);
        //Open the workbook
        workbook = new XSSFWorkbook(inputStream);
        //Open the Sheet Concerned
        sheet = workbook.getSheet("Sheet1");
        //Create a new Row in the sheet
        XSSFRow newRow = (XSSFRow) sheet.createRow(5);
        //add values in the cells
        newRow.createCell(0).setCellValue("tutor");
        newRow.createCell(1).setCellValue("tutor1234");

        //Finally Write into the cell
        outputStream = new FileOutputStream(src);
        workbook.write(outputStream);
        workbook.close();
    }

    @Test(priority=3, enabled = false)
    public static void editExcelFile() throws IOException {
        src = new File("/home/diyu/IdeaProjects/JalaSeleniumAssignment/src/main/resources/includes/test_excel.xlsx");
        inputStream = new FileInputStream(src);
        workbook = new XSSFWorkbook(inputStream);
        sheet = workbook.getSheet("Sheet1");
        //edit a cell in the workbook
        sheet.getRow(2).getCell(1).setCellValue("giligiligoo");

        outputStream = new FileOutputStream(src);
        workbook.write(outputStream);
    }

    @Test(priority=4, enabled = true)
    public static void deleteEntryInExcelFile(){
        try{
            src = new File("/home/diyu/IdeaProjects/JalaSeleniumAssignment/src/main/resources/includes/test_excel.xlsx");
            inputStream = new FileInputStream(src);
            workbook = new XSSFWorkbook(inputStream);
            sheet = workbook.getSheet("Sheet1");
            Row row = sheet.getRow(5);
            row.removeCell(row.getCell(0));
            row.removeCell(row.getCell(1));

            outputStream = new FileOutputStream(src);
            workbook.write(outputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    @Test(priority=5)
    public static void readExcelData() throws IOException {
        //Fetch the File
        src = new File("/home/diyu/IdeaProjects/JalaSeleniumAssignment/src/main/resources/includes/test_excel.xlsx");

        //Read from the file
        inputStream = new FileInputStream(src);

        //Load the work book
        workbook = new XSSFWorkbook(inputStream);
        //Load the first Sheet
        sheet = workbook.getSheet("Sheet1");
        //Iterate through the selected sheet
        for(int i = 1; i <= sheet.getLastRowNum(); i++){
            //Get the username
            cell = sheet.getRow(i).getCell(0);
            System.out.print("UserName: " + cell.getStringCellValue());

            //Get Password
            cell = sheet.getRow(i).getCell(1);
            System.out.print(" Password: " + cell.getStringCellValue());
            System.out.println();
        }
    }

    @AfterTest
    public static void finishTest(){
        //driver.close();
    }
}
