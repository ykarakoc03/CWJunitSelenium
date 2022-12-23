package Day5_LocatorPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Homework_radio {

/*
©
45
Radio Button
Go to URL: https://demoqa.com/radio-button
Soruya verilen 3 seçeneğin de seçilme durumlarını doğrulayınız.
Her bir seçenek seçildiğinde aşağıda çıkan text’leri konsolda yazdırınız.
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


    @After
   public void tearDown() throws InterruptedException {
       Thread.sleep(3000);
       driver.quit();
   }

    @Test
    public void checkBoxes() throws InterruptedException {

        //Go to URL: https://demoqa.com/radio-button
        driver.get("https://demoqa.com/radio-button");



         //Wait<WebDriver> waitt= new FluentWait<WebDriver>(driver).
         //      withTimeout(Duration.ofSeconds(10)).
         //      pollingEvery(Duration.ofMillis(10)).
         //      ignoring(NoSuchFieldError.class);
//
        //Soruya verilen 3 seçeneğin de seçilme durumlarını doğrulayınız.
        WebElement YesRadioButon = driver.findElement(By.xpath("//input[contains(@id,'yesRadio')]"));

        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));//Explicit Wait
        //wait.until(ExpectedConditions.elementToBeClickable(YesRadioButon)).click();//Explicit Wait

        YesRadioButon.click();

        System.out.println(driver.findElement(By.xpath("//p[contains(@class,'mt-3')]")).getText());
        Assert.assertTrue(YesRadioButon.isSelected());


        WebElement impressiveRadioButon = driver.findElement(By.xpath(" //input[contains(@id,'impressiveRadio')]"));
        impressiveRadioButon.click();
        System.out.println(driver.findElement(By.xpath("//p[contains(@class,'mt-3')]")).getText());
        Assert.assertTrue(impressiveRadioButon.isSelected());

        /*
        WebElement noRadioButon = driver.findElement(By.xpath(" //input[contains(@id,'noRadio')]"));
        noRadioButon.click();
        System.out.println(driver.findElement(By.xpath("//p[contains(@class,'mt-3')]")).getText());
        Assert.assertTrue(noRadioButon.isSelected());

         */



    }



 /*
   @Test
   public void test(){
       //Go to URL: https://demoqa.com/radio-button
       driver.get("https://demoqa.com/radio-button");
//Soruya verilen 3 seçeneğin de seçilme durumlarını doğrulayınız.
       WebElement yes= driver.findElement(By.xpath("//label[text()='Yes']"));
       yes.click();
       //Assert.assertTrue(yes.isSelected());
       WebElement Impressive= driver.findElement(By.xpath("//label[text()='Impressive']"));
       Impressive.click();
       Assert.assertFalse(Impressive.isSelected());
       WebElement No= driver.findElement(By.xpath("//label[text()='No']"));
       No.click();
       Assert.assertTrue(!No.isSelected());
//Her bir seçenek seçildiğinde aşağıda çıkan text’leri konsolda yazdırınız.
       System.out.println(yes.getText());
       System.out.println(Impressive.getText());
       System.out.println(No.getText());
   }




  */

}
