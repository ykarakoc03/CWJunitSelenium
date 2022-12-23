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

public class Homework_SelectGetMethods {

/*
- https://demoqa.com/select-menu sitesine gidin
- multiple <select> elementini locate edin
- getOptions(), getFirstSelectedOption(), getAllSelected() methodlarini kullanmak adina:
    * Farkli secimler yaparak methodlarinizi kullanin ve Assertion yapmayi unutmayin
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

        //- https://demoqa.com/select-menu sitesine gidin
        driver.get(" https://demoqa.com/select-menu");

       //- multiple <select> elementini locate edin
        WebElement arabalar= driver.findElement(By.id("cars"));
        Select select=new Select(arabalar);

       //- getOptions(), getFirstSelectedOption(), getAllSelected() methodlarini kullanmak adina:
       //* Farkli secimler yaparak methodlarinizi kullanin ve Assertion yapmayi unutmayin
        select.getOptions().stream().forEach(t-> System.out.println(t.getText()));

        select.selectByIndex(2);
        select.selectByValue("audi");

        Assert.assertTrue( select.getFirstSelectedOption().getText().contains("Opel"));

        Assert.assertTrue( select.getAllSelectedOptions().size()==2);


    }




}
