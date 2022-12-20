package Day4_LocatorPractice;

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

public class Homework01 {
//https://id.heroku.com/login sayfasına gidiniz.
//Bir mail adresi giriniz.
//Bir password giriniz.
//Login butonuna tıklayınız.
//"There was a problem with your login." text görünür ise "Kayıt Yapılamadı" yazdırınız.
//Eğer yazı görünür değilse "Kayıt Yapıldı" yazdırınız.
//Tüm sayfaları kapatınız.

WebDriver driver;

@Before
    public void setup(){
    WebDriverManager.chromedriver().setup();
    driver=new ChromeDriver();

    // 10 sn boyunca sitenin açılıp açılmadığını denetliyor
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    //driver maxsimum yapıldı
    driver.manage().window().maximize();
}

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void idLocators() {

        // sayfası açıldı
        driver.get("https://id.heroku.com/login");

        //Bir mail adresi giriniz.
        WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
        email.sendKeys("clarusway@gmail.com");

        //Bir password giriniz.
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("asd123.");

        //Login butonuna tıklayınız.
        driver.findElement(By.xpath("//button[@name='commit']")).click();

        //"There was a problem with your login." text görünür ise "Kayıt Yapılamadı" yazdırınız.
        String message = driver.findElement(By.xpath("//div[@role='alert']")).getText();



        if (message.equals("There was a problem with your login.")){
            System.out.println("Kayıt yapılamadı");

            //Eğer yazı görünür değilse "Kayıt Yapıldı" yazdırınız.
        }else System.out.println("Kayıt Yapıldı");



    }






}
