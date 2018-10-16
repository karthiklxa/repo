package framework.util.excelManagement;

import org.apache.poi.ss.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;

/**
 * Created by karthik.m on 6/4/2018.
 */
public class ExcelUtils {

    private static final Logger logger = LoggerFactory.getLogger(ExcelUtils.class);
    /**
     * Get Table as Array - use this method for creating a Data Provider
     * @param FilePath - TestData file path
     * @param SheetName - sheet name is same as the Test Case ID
     * @return
     * @throws Exception
     */
    public static Object[][] getTableArray(String FilePath, String SheetName) throws Exception {

        String[][] tabArray = null;

        try {

            FileInputStream inp = new FileInputStream(FilePath);
            Workbook wb = WorkbookFactory.create(inp);
            Sheet sheet = wb.getSheetAt(0); // TODO Change this to Sheet Name
            int startRow = 1;
            int startCol = 0;
            int ci, cj;

            // get total roles
            int totalRows = sheet.getLastRowNum();
            Row r = sheet.getRow(1);

            // get total number of columns
            int totalCols = r.getLastCellNum();

            tabArray = new String[totalRows][totalCols];
            ci = 0;
            for (int i = startRow; i <= totalRows; i++, ci++) {
                cj = 0;
                for (int j = startCol; j < totalCols; j++, cj++) {
//                    r.getCell(j,r.CREATE_NULL_AS_BLANK);
                    Cell cell = sheet.getRow(i).getCell(j);
                    if(cell == null){
                        tabArray[ci][cj] = "";
                    }else{
                        tabArray[ci][cj] = cell.getStringCellValue();
                    }
                }
            }

        } catch (Exception e) {
            logger.error("Could not read the Excel sheet");
            e.printStackTrace();
        }

        return (tabArray);
    }
}
