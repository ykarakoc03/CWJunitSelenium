package Day8_WindowHandles_Actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.BaseTest;

public class C04_Actions extends BaseTest {



    @Test
    public void dragAndDrop(){
        driver.get("https://rangeslider.js.org/");


        //Slider locate ediliyor
        WebElement slider= driver.findElement(By.xpath("//div[@class='rangeslider__handle'][1]"));

        Actions actions = new Actions(driver);


        //saga taşıma işlemlerinde xoffset + olmalı sola taşıma işlemlerinde xoffset - olmalı
        //aynı zamanda dikey eksende hareket etmesini engellemek için yofset 0 olmalı
        actions.dragAndDropBy(slider,-20,0).perform();


    }
}
