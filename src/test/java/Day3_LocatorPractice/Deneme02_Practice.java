package Day3_LocatorPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Deneme02_Practice {
/*
Go to URL: https://opensource-demo.orangehrmlive.com/
Locate the username, password, login button using absolute xpath and relative xpa
 */
    static WebDriver driver;

    @BeforeClass
    public static void createDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        // 10 sn boyunca sitenin açılıp açılmadığını denetliyor
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

    }

    @Before
    public void beforeEach(){
        // sayfası açıldı
        driver.get("https://opensource-demo.orangehrmlive.com/");
    }


   // @AfterClass
   // public static void tearDown() {
   //    driver.quit();
   // }

    @Test
    public void test1() {

       //
        WebElement emailBox= driver.findElement(By.xpath("//input[@class='oxd-input oxd-input--active' and @name='username']"));
        String pass = driver.findElement(By.xpath(" //p[contains(text(),'Username ')]")).getText();

        emailBox.sendKeys("Admin");
        WebElement passBox= driver.findElement(By.xpath("//input[@class='oxd-input oxd-input--active'][@name='password']"));
        passBox.sendKeys("admin123");
        driver.findElement(By.xpath("//button")).click();






    }








}
