package Practice.Day01;

import org.apache.hc.core5.util.Asserts;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.BaseTest;

import java.util.Set;

public class Task_06 extends BaseTest {

/*
    1- https://the-internet.herokuapp.com/context_menu sitesine gidelim.
    2- Çizili alan üzerinde sağ click yapalım.
    3- Alert'te çıkan yazının "You selected a context menu" olduğunu test edelim.
    4- Tamam diyerek Alert'i kapatalım.
    5- Elemental Selenium linkine tıklayalım.
    6- Açılan sayfada h1 tagında "Elemental Selenium" yazdığını test edelim.
 */


    @Test
    public void test01() {

        driver.get("https://the-internet.herokuapp.com/context_menu");

        WebElement ciziliAlan = driver.findElement(By.id("hot-spot"));
        Actions actions = new Actions(driver);
        actions.contextClick().perform();

        Assert.assertEquals(driver.switchTo().alert().getText(), "You selected a context menu");
        driver.switchTo().alert().accept();

        String firstPageHandle = driver.getWindowHandle();

        driver.findElement(By.linkText("Elemental Selenium")).click();

        Set<String> allWindowPageHandle = driver.getWindowHandles();
        String secondPageHandle = "";

        for (String each: allWindowPageHandle){
            if (!each.equals(firstPageHandle)){
                secondPageHandle = each;
            }
        }

        driver.switchTo().window(secondPageHandle);

        Assert.assertEquals("İkinci sayfadaki text istenenden farklı.",driver.findElement(By.tagName("h1")).getText(), "Elemental Selenium" );


    }
}
