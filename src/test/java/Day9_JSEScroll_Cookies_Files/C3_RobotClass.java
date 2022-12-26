package Day9_JSEScroll_Cookies_Files;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

import java.awt.*;
import java.awt.event.KeyEvent;

public class C3_RobotClass extends BaseTest {

/*
dosya yükleme işi yapıyoruz
 */

    @Test
    public void robotTest01() throws AWTException, InterruptedException {
        driver.get("https://demo.guru99.com/test/upload/");

        WebElement input = driver.findElement(By.id("uploadfile_0"));
       //dosyayı seçiyor ancak "kaydet" gibi açılan pencereye basamıyor
        input.sendKeys("C:\\Users\\Nutzer\\IdeaProjects\\CWJunitSelenium\\src\\test\\java\\resources\\robot.txt");

        Robot robot =new Robot();
        // açılır penceredeki kaydete basacagız. ctrl + s basıp kaydet yapacagız
        robot.keyPress(KeyEvent.VK_CONTROL);//keyPress  tuşa basılı tutar, ctrl ye bastık
        robot.keyPress(KeyEvent.VK_S);// s tuşuna bastık
        Thread.sleep(2000);
        robot.keyRelease(KeyEvent.VK_CONTROL);//keyRelease tuşu serbest bıraktı
        robot.keyRelease(KeyEvent.VK_S);// s tşunu serbest bıraktık
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_ENTER);// enter a bastık
        robot.keyRelease(KeyEvent.VK_ENTER);//tuşu serbet bıraktık
        Thread.sleep(50000);
    }





}
