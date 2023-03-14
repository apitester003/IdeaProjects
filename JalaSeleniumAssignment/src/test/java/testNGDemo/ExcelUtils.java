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

    public static int getRowCount() {
        //Get Row Count
        rowCount = sheet.getPhysicalNumberOfRows();
        //System.out.println("The row count is: " + rowCount);
        return rowCount;
    }

    public static int getColCount(){
        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
        return colCount;
    }

    public static Object[][] getCellData(){
        String cellValue = "";
        Object[][] data = new Object[10][10];
        if(rowCount > 0){
            for(int count = 1; count < rowCount; count++){
                cellCount = getColCount();
                if(cellCount > 0){
                    for(int ctr = 0; ctr < cellCount; ctr++){
                        cellValue = getCellDataString(count, ctr);
                        System.out.println(cellValue);
                        data[count][ctr] = cellValue;
                    }
                }
            }
        }
            return data;
    }

    public static String getCellDataString(int row, int col){
        String cellValue = "";
        cellValue = sheet.getRow(row).getCell(col).getStringCellValue();
        return cellValue;
    }
}
