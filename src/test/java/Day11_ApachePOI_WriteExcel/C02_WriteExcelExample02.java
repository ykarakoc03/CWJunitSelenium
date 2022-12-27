package Day11_ApachePOI_WriteExcel;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.*;

public class C02_WriteExcelExample02 {

   //Create an object of File class to open xlsx file.
   //Create an object of FileInputStream class to read excel file.
   //Create an object of FileInputStream class to read excel file.
   //Creating workbook instance that refers to .xlsx file.
   //Creating a Sheet object.
   //Get all rows in the sheet.
   //Create a row object to retrieve row at index 3.
   //Create a cell object to enter value in it using cell Index.
   //Write the data in excel using output stream.

    @Test
    public void changeExcelData() throws IOException {
        String filepath="src/test/java/resources/excelData.xlsx";

        //Path den file oluşturduk
        File file=new File(filepath);

        //dosyamızı açtık
        FileInputStream fis =new FileInputStream(file);

        //workbook umuzu oluşturduk
        Workbook wb = WorkbookFactory.create(fis);

        //Sheet imizi excwldwki ismiyle oluşturduk
        Sheet informationData=wb.getSheet("informationData");

        //ilk satırdan son satırı çıkardı ve dolu hücreleri aldık. üstte boş satırlar varsa çıkardık
        int totalRowsUsed= informationData.getLastRowNum() - informationData.getFirstRowNum();
        System.out.println("total Rows = " + totalRowsUsed);

        //yeni bir row oluşturup row içersindeki celleri de oluşturarak degerlerini atadık
        Row row5 = informationData.createRow(4);

        row5.createCell(0).setCellValue("yakup");
        row5.createCell(1).setCellValue("Karakoc");
        row5.createCell(2).setCellValue("yakup@gmail.com");
        row5.createCell(3).setCellValue("Male");
        row5.createCell(4).setCellValue("12345678");
        row5.createCell(5).setCellValue("adress");

        //dosyamızı yazma işlemini gerçekleştirdik
        FileOutputStream fos=new FileOutputStream(file);
        wb.write(fos);

        fis.close();
        fos.close();

        wb.close();

    }
}
