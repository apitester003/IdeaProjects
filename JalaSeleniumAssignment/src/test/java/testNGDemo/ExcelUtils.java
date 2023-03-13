package testNGDemo;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class ExcelUtils {
    private static String projPath;
    private static Workbook workbook;
    private static Sheet sheet;
    private static int rowCount;
    private static int cellCount;

    ExcelUtils(String excelPath, String sheetName) {
        try{
            projPath = System.getProperty("user.dir");
            /* workbook = new XSSFWorkbook(projPath + "/src/main/resources/includes/data.xlsx");
            sheet = workbook.getSheet("Sheet1");*/
            workbook = new XSSFWorkbook(excelPath);
            sheet = workbook.getSheet(sheetName);

        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void getRowCount() {
        //Get Row Count
        rowCount = sheet.getPhysicalNumberOfRows();
        System.out.println("The row count is: " + rowCount);
    }

        public static void getCellData(){
        if(rowCount > 0){
            for(int count = 1; count < rowCount; count++){
                cellCount = sheet.getRow(count).getPhysicalNumberOfCells();
                if(cellCount > 0){
                    for(int ctr = 0; ctr < cellCount; ctr++){
                        String cellValue = sheet.getRow(count).getCell(ctr).getStringCellValue();
                        System.out.println(cellValue);
                    }
                }
            }
        }
    }
}
