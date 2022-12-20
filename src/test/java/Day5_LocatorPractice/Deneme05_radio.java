package Day5_LocatorPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Deneme05_radio {

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

   // @After
   // public void tearDown() throws InterruptedException {
   //     Thread.sleep(3000);
   //     driver.quit();
   // }
/*
    @Test
    public void checkBoxes() throws InterruptedException {

//Go to URL: https://demoqa.com/radio-button
        driver.get("https://demoqa.com/radio-button");


        //Soruya verilen 3 seçeneğin de seçilme durumlarını doğrulayınız.//input[@id='yesRadio']
        List<WebElement> radioButon = driver.findElements(By.xpath("//input[@type='radio'] "));


        for (int i = 0; i < radioButon.size()-1; i++) {
            radioButon.get(i).click();
            Assert.assertTrue(radioButon.get(i).isSelected());
            System.out.println(driver.findElement(By.xpath("//p[@class='mt-3'] ")));
        }

        // Her bir seçenek seçildiğinde aşağıda çıkan text’leri konsolda yazdırınız.





    }


 */
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




}
