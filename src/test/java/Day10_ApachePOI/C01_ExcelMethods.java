package Day10_ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ExcelMethods {


    public static void main(String[] args) throws IOException {

        //excel dosyanını path aldık
String path="src\\test\\java\\resources\\excelfile.xlsx";

        //dosyayı actık
        FileInputStream fileInputStream =new FileInputStream(path);

        // açtıgımız dosyayı excel workbookuna cevirdik
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        //workbook umuza sheetize indeksine göre geçiş yaptık (index 0 dan başlar)
        Sheet sheet1 = workbook.getSheetAt(0);

        //sayfanın ilk satırını aldık (index 0 dan başlar)
        Row row1= sheet1.getRow(0);

        //aldığımız satırın ilk hücresini aldık(indek ile) sütun gibide düşünülebilir
        Cell cell1 = row1.getCell(0);

        System.out.println("cell1 = " + cell1);

    }
}
