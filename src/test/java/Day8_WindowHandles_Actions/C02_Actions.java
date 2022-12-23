package Day8_WindowHandles_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.BaseTest;

import javax.swing.*;
import java.nio.file.WatchEvent;

public class C02_Actions extends BaseTest {


    @Test
    public void doubleClick() {
        driver.get("https://demoqa.com/buttons");
        WebElement doubleClick = driver.findElement(By.id("doubleClickBtn"));

        Actions actions = new Actions(driver);

        //aksiyonun çift tıklma oldugunu belirttik ve perform() ile uygula dedik
        actions.doubleClick(doubleClick).perform();

        //mesaj alannda mesajın görünüp görünmediğini gösteriyor
        Assert.assertTrue(driver.findElement(By.id("doubleClickMessage")).isDisplayed());

    }

    @Test
    public void rightClick() {

        driver.get("https://demoqa.com/buttons");
        WebElement rightClick = driver.findElement(By.id("rightClickBtn"));

        Actions actions=new Actions(driver);

        // sag tıklmayı yapıyoruz//build aksiyonları derleyerek çalıştırır.
        // perform ile problem olursa build ile kullanabiliriz
        /*
        build() olmazsa bizim istediğimiz webelement yerine yakınındaki webelemente tıklayabiliyor bazen.
        özellikle moveToElement metodunda işe yarıyor.
         */
        actions.contextClick(rightClick).build().perform();

//mesaj alannda mesajın görünüp görünmediğini gösteriyor
        Assert.assertTrue(driver.findElement(By.id("rightClickMessage")).isDisplayed());
    }

    @Test
    public void Click() {
        driver.get("https://demoqa.com/buttons");
        WebElement clickBtn = driver.findElement(By.xpath("//button[.='Click Me']"));

        Actions actions= new Actions(driver);

        actions.click(clickBtn).perform();

        WebElement clickMessage= driver.findElement(By.id("dynamicClickMessage"));
        Assert.assertTrue(clickMessage.isDisplayed());
    }

}
