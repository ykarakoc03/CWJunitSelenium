package Day6_Dropdown_SeleniumWaits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Homework_MultipleSelectHW {

/*
- https://demoqa.com/select-menu sitesine gidin
- Multiple select yapabileceginiz <select> elementini locate edin
- Birden fazla secim yapip secimlerinizi DOGRULAyin
 */

    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        // 10 sn boyunca sitenin açılıp açılmadığını denetliyor
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //driver maxsimum yapıldı
        driver.manage().window().maximize();
    }


    //  @After
    // public void tearDown() throws InterruptedException {
    //     Thread.sleep(3000);
    //     driver.quit();
    // }

    @Test
    public void checkBoxes() throws InterruptedException {

        //Go to URL:
        driver.get("https://demoqa.com/select-menu");
        //- https://demoqa.com/select-menu sitesine gidin
        //- Multiple select yapabileceginiz <select> elementini locate edin
        //- Birden fazla secim yapip secimlerinizi DOGRULAyin
    }

    public void kontrol(Select select,String renk) {
        Assert.assertEquals(select.getFirstSelectedOption().getText(), renk);
    }


}
