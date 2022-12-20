package Day3_LocatorPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Practice {
//    Go to https://www.linkedin.com/
//    When we write an e-mail without the @ sign in the e-mail box and press enter.
//    Let's test the "Invalid email address" warning.

    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        // 10 sn boyunca sitenin açılıp açılmadığını denetliyor
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

    }

    //@After
    //public void tearDown() {
    //    driver.quit();
    //}
@Test
    public void xpathPractice() {
        //1. adım Linkedin sayfası açıldı
        driver.get("https://www.linkedin.com/");

        //2. adım-> email alanına @ sembolü bulunmayan bir mail adresi gir
        driver.findElement(By.xpath("//input[@id='session_key']")).sendKeys("clarusway.com", Keys.ENTER);

        //3. adım Hata mesajının görüntülendiğini doğrula
    WebElement alertMassage=driver.findElement(By.xpath("//p[@class='alert-content']"));
    Assert.assertTrue(alertMassage.isDisplayed());
    //Assert.assertEquals(true,alertMassage.isDisplayed());
    //Assert.assertFalse(!alertMassage.isDisplayed());
    }


}
