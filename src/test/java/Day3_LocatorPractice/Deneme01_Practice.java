package Day3_LocatorPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Deneme01_Practice {
/*
Navigate to website https://testpages.herokuapp.com/styled/index.html
Under the ORIGINAL CONTENTS
Click on Alerts
Print the URL
Navigate back
Print the URL
Click on Basic Ajax
Print the URL
Enter value → 20 and Enter
And then verify Submitted Values is displayed open page
Close driver
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
        driver.get("https://testpages.herokuapp.com/styled/index.html");
    }


   // @AfterClass
   // public static void tearDown() {
   //    driver.quit();
   // }

    @Test
    public void test1() {

       //
        WebElement alerts= driver.findElement(By.xpath("//*[@id='alerts']"));
        alerts.click();
        System.out.println(driver.getCurrentUrl());
        driver.navigate().back();
        System.out.println(driver.getCurrentUrl());
        WebElement basic = driver.findElement(By.id("basicajax"));
        basic.click();
        WebElement value= driver.findElement(By.id("lteq30"));
        value.sendKeys("20",Keys.ENTER);

        WebElement submitElement = driver.findElement(By.xpath("// p[text()='Submitted Values']"));
        Assert.assertTrue(submitElement.isDisplayed());
        //sadece text ten locat etme:
            // p[text()='Submitted Values']
             //p[.='Submitted Values']
             //p[contains(text(),'Submitted Values')]


    }








}
