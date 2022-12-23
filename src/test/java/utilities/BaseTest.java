package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public abstract class BaseTest {
/*
Abstract yaparak TestBase Class'ından obje oluşturulmasının önüne geçeriz.
TestBase Class'ı sadece extends ile inherit ederek kullanacağız.
 Dolayısıyla oluşturduğumuz driver variable'i için protected access modifier seçiyoruz.
 */
   protected WebDriver driver;

    @Before
    public void setup() {
        //Driver ile ilgili her turlu initial(baslangic) islemi burada yapilir
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() throws InterruptedException {
        // test sonrasinda driver kapatmak (varsa raporlari dosyalamak) icin kullanilir.
       Thread.sleep(3000);
        driver.quit();
    }






}
