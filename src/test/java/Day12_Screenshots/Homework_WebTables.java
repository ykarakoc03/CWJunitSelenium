package Day12_Screenshots;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

import java.util.List;

public class Homework_WebTables extends BaseTest {

    //Go to URL: https://the-internet.herokuapp.com/tables
    //Print the entire table
    //Print All Rows
    //Print Last row data only
    //Print column 5 data in the table body
    //Write a method that accepts 2 parameters
    //parameter 1 = row number
    //parameter 2 = column number
    //printData(3,4); => prints
    //parameter 3 = table id
    //printData(3,4,"table1") => prints data in 3rd row 4th Column with table id
    @Test
    public void webtables() {

        //Go to URL: https://the-internet.herokuapp.com/tables
        driver.get("https://the-internet.herokuapp.com/tables");

        //Print the entire table
        WebElement table1= driver.findElement(By.id("table1"));
        System.out.println(table1.getText());

        System.out.println();

        //Print All Rows
        List<WebElement> rows=table1.findElement(By.tagName("tbody")).findElements(By.xpath(".//tr"));
        rows.forEach(t-> System.out.println(t.getText()));

        System.out.println();

        //Print Last row data only
        //1. çözümlistenin son indexsi ile yazdırdık
        System.out.println(rows.get(rows.size() - 1).getText());

        //2. çözümxpath ile yazdırdık
        int rowSize=table1.findElements(By.xpath(".//tr")).size();
        System.out.println(table1.findElement(By.xpath(".//tr[" + (rowSize - 1) + "]")).getText());


        //Print column 5 data in the table body
        List<WebElement> colomn5=table1.findElements(By.xpath(".//tr//td[5]"));
        colomn5.forEach(t-> System.out.println(t.getText()));

        //Write a method that accepts 2 parameters
        //parameter 1 = row number
        //parameter 2 = column number
        //printData(3,4); => prints
        prinData(3,4);

        //parameter 3 = table id
        //printData(3,4,"table1") => prints data in 3rd row 4th Column with table id
        prinData(3,4,"table1");

    }
    private void prinData(int row,int column) {
        WebElement cell= driver.findElement(By.id("table1")).findElement(By.xpath(".//tr["+row+"]//td["+column+"]"));
        System.out.println(cell.getText());
    }


    private void prinData(int row,int column, String id) {
        WebElement cell= driver.findElement(By.id(id)).findElement(By.xpath(".//tr["+row+"]//td["+column+"]"));
        System.out.println(cell.getText());
    }

}
