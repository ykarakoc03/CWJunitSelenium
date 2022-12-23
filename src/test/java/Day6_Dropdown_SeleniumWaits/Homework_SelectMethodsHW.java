package Day6_Dropdown_SeleniumWaits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.A;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class Homework_SelectMethodsHW {

/*
- https://demoqa.com/select-menu sitesine gidin
- <select> elementini locate edin
- <select> elementinin seceneklerini yazdirin
- Sirasiyla selectByIndex, selectByValue, selectByVisibleText methodlarini kullanarak;
    * Yellow (index)
    * Purple (value)
    * Black  (text)
    seceneklerini secin
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
    public void test01()  {

        //Go to URL:
        driver.get("https://demoqa.com/select-menu");

        //<select> elementini locate edin
        WebElement elements = driver.findElement(By.id("oldSelectMenu"));

        Select select = new Select(elements);

        //- <select> elementinin seceneklerini yazdirin
        select.getOptions().stream().forEach(t -> System.out.println(t.getText()));

/*
- Sirasiyla selectByIndex, selectByValue, selectByVisibleText methodlarini kullanarak;
    * Yellow (index)
    * Purple (value)
    * Black  (text)
    seceneklerini secin
 */
        select.selectByIndex(3);
        kontrol(select,"Yellow");
        select.selectByValue("4");
        kontrol(select,"Purple");
        select.selectByVisibleText("Black");
        kontrol(select,"Black");

    }

    public void kontrol(Select select,String renk) {
        Assert.assertEquals(select.getFirstSelectedOption().getText(), renk);

    }


}
