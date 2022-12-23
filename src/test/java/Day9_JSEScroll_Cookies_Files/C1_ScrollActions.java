package Day9_JSEScroll_Cookies_Files;

import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.BaseTest;

import javax.swing.*;

public class C1_ScrollActions extends BaseTest {

    @Test
    public void scrollPageUpDown() throws InterruptedException {
        driver.get("https://amazon.com");
        Actions action = new Actions(driver);
        Thread.sleep(2000);

        // sayfayı aşagı ve yukarı kaydırıyoruz
        //yandaki bir cubuk boyutu kadar aşagı indirir
        action.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);
        action.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);
        action.sendKeys(Keys.PAGE_UP).perform();
        Thread.sleep(2000);
        action.sendKeys(Keys.PAGE_UP).perform();


    }

    @Test
    public void scrollArrowPageUpDown() throws InterruptedException {
        driver.get("https://amazon.com");
        Actions action = new Actions(driver);
        Thread.sleep(2000);

        //sayfayı aşagı tuş ile hareket ettirir. daha kısa ve küçük hareket eder
        action.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(2000);
        action.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(2000);
        action.sendKeys(Keys.ARROW_UP).perform();
        Thread.sleep(2000);
        action.sendKeys(Keys.ARROW_UP).perform();

    }


}
