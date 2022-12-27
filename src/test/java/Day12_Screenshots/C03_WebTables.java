package Day12_Screenshots;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

public class C03_WebTables extends BaseTest {
   //Go to URL: http://demo.guru99.com/test/web-table-element.php
   //To find third row of table
   //To get 3rd row's 3nd column data
   //Get all the values of a Dynamic Table


    @Override
    public void tearDown() throws InterruptedException {

    }

    @Test
    public void webTableExamle() {
        driver.get("http://demo.guru99.com/test/web-table-element.php");

        //tablomuzu locate ettik
        WebElement table= driver.findElement(By.className("dataTable")).findElement(By.tagName("tbody"));

        //To find third row of table
        //tablo üzerinde locate ediyorum
        //table üzerinde arama yapıldıgı için.// ile başlıyoruz** . önemli ilk buldugu tr[3] getirir
        //normal olarak //table[@class='dataTable']//tr[3] xpath
        WebElement row3= table.findElement(By.xpath(".//tr[3]"));


        //To get 3rd row's 3nd column data
        WebElement row3cell3 = row3.findElement(By.xpath(".//td[3]"));

        //Get all the values of a Dynamic Table
        //satır sayımızı bulduk
        int satirSayisi= table.findElements(By.xpath(".//tr")).size();

        //herhangi bir satırdan sütun sayısı buluyoruz
        int sutunSayisi=row3.findElements(By.xpath(".//td")).size();

        for (int i=1; i<= satirSayisi; i++){

            for (int j=1; j<= sutunSayisi; j++){

                //her sutun için
                By locator =By.xpath(".//tr["+i+"]//td["+j+"]");
                WebElement tableData=table.findElement(locator);

                System.out.print(tableData.getText() + " ");
            }
            System.out.println();
        }


    }
}
