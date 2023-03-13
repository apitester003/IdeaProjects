package testNGDemo;

import org.testng.annotations.Test;

public class ExcelUtilsDemo {
    private static String projPath = System.getProperty("user.dir");
    private static String excelPath;
    private static String sheetName;

    @Test
    public static void initializeTest(){
        excelPath = projPath + "/src/main/resources/includes/data.xlsx";
        sheetName = "Sheet1";

        ExcelUtils eu = new ExcelUtils(excelPath, sheetName);
        eu.getRowCount();
        eu.getCellData();
    }
}
