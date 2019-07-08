package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcilReader {

    static FileInputStream fis = null ;
    String filpath ;

    public FileInputStream getFileInputStream()
    {
        // this location for my file
        filpath = System.getProperty("user.dir")+"/src/test/java/Data/UserData.xlsx" ;
        File srcfile = new File(filpath);
        try {
            fis = new FileInputStream(srcfile);
        } catch (FileNotFoundException e) {

            System.out.println("Test Data file not found " + e.getMessage());
            System.exit(0);
        }

        return fis;

    }

    @SuppressWarnings("deprecation")
    public Object[][] getExcelData (int sheetnum , int lastColum) throws IOException
    {
        fis = getFileInputStream();

        // here we need install org.apache.poi from maven


        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheetAt(sheetnum);

        int TotalNumOfRows = (sheet.getLastRowNum()+1);
        int TotalNumOfCols = lastColum ;

        String [][] arrayExcelData = new String [TotalNumOfRows][TotalNumOfCols];

        for (int i = 0; i < TotalNumOfRows; i++)
        {
            for (int j = 0; j < TotalNumOfCols ; j++) {
                XSSFRow row = sheet.getRow(i);
                arrayExcelData[i][j] = row.getCell(j).toString();
            }

        }

        wb.close();
        return arrayExcelData;

    }

}
