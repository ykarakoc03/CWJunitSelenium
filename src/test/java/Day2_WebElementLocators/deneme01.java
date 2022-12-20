package Day2_WebElementLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class deneme01 {

    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        // 10 sn boyunca sitenin açılıp açılmadığını denetliyor
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //Linkedin sayfası açıldı


        //driver maxsimum yapıldı
        driver.manage().window().maximize();
    }

    //@After
    //public void tearDown() {
    //    driver.quit();
    //}


/*

Go to http://automationpractice.com/index.php
When we write an e-mail without the @ sign in the e-mail box and press enter.
Let's test the "Invalid email address" warning.
 */

    @Test
    public void emailTest() {
        driver.get("http://www.n11.com/");
        WebElement girisYap = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div[5]/div/div/div/a[2]"));
       girisYap.click();


       driver.findElement(By.id("email")).sendKeys("deneme123.com");
       driver.findElement(By.id("password")).sendKeys("12345wert");
       driver.findElement(By.id("loginButton")).click();

    }
    /*
    ©
24
Locators
Create the driver with BeforeClass and make it static inside the class.
Go to http://www.google.com
Type "Green Mile" in the search box and print the number of results.
Type "Premonition" in the search box and print the number of results.
Type "The Curious Case of Benjamin Button" in the search box and print the number of results.
Close with AfterClass.
     */

    @Test
    public void aramaTest() {
        driver.get("http://www.google.com");
        WebElement arama = driver.findElement(By.xpath("//html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input"));
        arama.sendKeys("Green Mile",Keys.ENTER);
        System.out.println(driver.findElement(By.id("result-stats")).getText());


    }






}
