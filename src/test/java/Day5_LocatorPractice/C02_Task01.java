package Day5_LocatorPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class C02_Task01 {

//https://www.teknosa.com/ adresine gidiniz.
// Arama çubuğuna ''oppo'’ yazıp ENTER tıklayınız.
// Sonuç sayısını yazdırınız.
// Çıkan ilk ürüne tıklayınız.
// Sepete ekleyiniz.
// Sepetime gite tıklayınız.
// Konsolda "Sipariş Özeti" WebElement'inin text'ini yazdırınız.
// Alışverişi tamamlayınız.
// Son olarak "Teknosa'ya Hoş Geldiniz" WebElement'inin text'ini yazdırınız.
// Driver'ı kapatınız.


    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        // 10 sn boyunca sitenin açılıp açılmadığını denetliyor
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.teknosa.com/");

        //driver maxsimum yapıldı
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void teknosaTest() {
        //https://www.teknosa.com/ adresine gidiniz.
        driver.get("https://www.teknosa.com/");


        // Arama çubuğuna ''oppo'’ yazıp ENTER tıklayınız.**alternatif //input[@name='s']
        WebElement searchArea = driver.findElement(By.name("s"));
        searchArea.sendKeys("oppo", Keys.ENTER);

        // Sonuç sayısını yazdırınız.
        WebElement sonucSayısı = driver.findElement(By.xpath("//div[@class='plp-info']"));
        System.out.println(sonucSayısı.getText());

        // Çıkan ilk ürüne tıklayınız.
        WebElement ilkÜrün = driver.findElement(By.className("prd-link"));
        ilkÜrün.click();

        // Sepete ekleyiniz.
        WebElement sepeteEkle = driver.findElement(By.id("addToCartButton"));
        sepeteEkle.click();


        // Sepetime gite tıklayınız.**alternatif //a[@class='btn btn-secondary']
        WebElement sepeteGit = driver.findElement(By.xpath("//span[text()=\"Sepetim'e Git\"]"));
        sepeteGit.click();

        // Konsolda "Sipariş Özeti" WebElement'inin text'ini yazdırınız.
        WebElement siparisÖzeti = driver.findElement(By.xpath("//div[@class='cart-sum-body']"));
        System.out.println(siparisÖzeti.getText());


        // Alışverişi tamamlayınız.
        WebElement alisVerisTamamla = driver.findElement(By.partialLinkText("Alışverişi Tamamla"));
        alisVerisTamamla.click();

        // Son olarak "Teknosa'ya Hoş Geldiniz" WebElement'inin text'ini yazdırınız.
        WebElement mesaj = driver.findElement(By.xpath("//div[@class='lrp-title']"));
        System.out.println(mesaj.getText());


    }


}
