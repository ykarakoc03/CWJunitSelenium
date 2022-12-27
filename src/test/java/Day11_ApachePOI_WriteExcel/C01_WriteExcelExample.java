package Day11_ApachePOI_WriteExcel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;
import utilities.BaseTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class C01_WriteExcelExample  {


    @Test
    public void writeExel() throws IOException {

        String path="src/test/java/resources/excelfile.xlsx";

        //dosyamızı açıyoruz
        FileInputStream fis=new FileInputStream(path);

        //dosyamızı bir workbook haline getiriyoruz
        Workbook workbook= WorkbookFactory.create(fis);

        //Sheet imizioluşturduk
        Sheet sheet2= workbook.getSheetAt(1);

        //ilk satırımıza gittik
        Row row1=sheet2.getRow(0);

        //ilk satırımızın 3. hücresini oluşturduk
        Cell row1cell3=row1.createCell(2);

        //HÜCREMİZE DEĞER ATADIK
        row1cell3.setCellValue("POPULATION");

        ///Method chain ile data ekleme/değiştirme methodu(zincirleme)
        sheet2.getRow(1).createCell(2).setCellValue("Rusya nın populasyonu");
        sheet2.getRow(2).createCell(2).setCellValue("Çin nin populasyonu");
        sheet2.getRow(3).createCell(2).setCellValue("ABD nin populasyonu");

        //Excell dosyamıza yazma işlemini yapıyoruz
        FileOutputStream fos = new FileOutputStream(path);

        //değişiklikler dosyamıza yazıldı
        workbook.write(fos);

        //dosyalarımızı kapattık
        fis.close();
        fos.close();

        //workbook umuzu kapattık
        workbook.close();

    }
}
