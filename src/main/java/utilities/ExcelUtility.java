package utilities;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

    public static Object[][] getLoginData() {

        Object[][] data = null;

        try {

            FileInputStream fis =
                    new FileInputStream(
                            "src/test/resources/TestData.xlsx");

            XSSFWorkbook workbook =
                    new XSSFWorkbook(fis);

            XSSFSheet sheet =
                    workbook.getSheet("LoginData");

            int rows = sheet.getPhysicalNumberOfRows();

            data = new Object[rows - 1][2];

            for (int i = 1; i < rows; i++) {

                data[i - 1][0] =
                        sheet.getRow(i)
                             .getCell(0)
                             .getStringCellValue();

                data[i - 1][1] =
                        sheet.getRow(i)
                             .getCell(1)
                             .getStringCellValue();
            }

            workbook.close();

        } catch (Exception e) {

            e.printStackTrace();
        }

        return data;
    }
}