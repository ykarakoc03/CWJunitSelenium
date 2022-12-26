package Day9_JSEScroll_Cookies_Files;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Homework_RobotClass extends BaseTest {

    //https://api.jquery.com/ sitesine gidelim
    //arama alanina json yazalim
    //Enter islemini robot class kullanrak yapalim


    @Test
    public void robotClassTest() throws AWTException {

        //https://api.jquery.com/ sitesine gidelim
        driver.get("https://api.jquery.com/");

        //arama alanina json yazalim
       WebElement seach=driver.findElement(By.xpath("//input[@name='s']"));
               seach.sendKeys("json");

        //Enter islemini robot class kullanrak yapalim
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);


    }
}
