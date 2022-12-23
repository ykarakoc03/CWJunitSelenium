package Day8_WindowHandles_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.BaseTest;

public class C06_Actions extends BaseTest {



    @Test
    public void keyBoardActions(){

        driver.get("https://demoqa.com/auto-complete");

        WebElement input= driver.findElement(By.id("autoCompleteMultipleInput"));

        Actions actions = new Actions(driver);

        // KeyDown istenilen tuşu basılı tutuyor
        //KeyUp basılı tuşu kaldırmamız işlemini görüyor
        actions.click(input).
                keyDown(Keys.SHIFT).
                sendKeys("y").
                keyUp(Keys.SHIFT).
                sendKeys("es are ").
                keyDown(Keys.SHIFT).
                sendKeys("e").
                keyUp(Keys.SHIFT).
                sendKeys("xceptional").perform();




    }
}
