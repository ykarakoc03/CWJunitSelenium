package Day6_Dropdown_SeleniumWaits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_BasicAuthentication {


    /*
    driver.switchTo().alert().accept();//ok demek
    driver.switchTo().alert().dismiss();//cancel demek
    driver.switchTo().alert().getText();//metni getirir
    driver.switchTo().alert().sendKeys("");//metin kutusu doldurulur
     */
    WebDriver driver;

    @Before
    public void setup() {
        // driver ile ilgili her türlü başlangıç işlemi burada yazılır
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        // 10 sn boyunca sitenin açılıp açılmadığını denetliyor
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //driver maxsimum yapıldı
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void basicAuth() {
        //https://the-internet.herokuapp.com/basic_auth

        // sayfa açılır açılmaz gelen açılır pencere(alert) ile
        // kullanıcı adı ve passwordu hızlı bir şekilde geçmek için
        //https://USERNAME:PASSWORD@URL
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");//alert ile ugraşmadan authorize yaptık

        WebElement content = driver.findElement(By.id("content"));

        Assert.assertTrue(content.getText().contains("Congratulations") );



    }


    }
