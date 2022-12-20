package Day6_Dropdown_SeleniumWaits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_Alerts {

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
    public void alerts() {

        //    Go to URL:
        driver.get("http://demo.guru99.com/test/delete_customer.php");

        WebElement idInput= driver.findElement(By.name("cusid"));
        idInput.sendKeys("123");

        driver.findElement(By.name("submit")).click();

        driver.switchTo().alert().accept();// ekraan acılan(alert) penceresini kabul ettik
        driver.switchTo().alert().accept();// ikinci gelen alert penceresini kabul edildi


    }







    }
