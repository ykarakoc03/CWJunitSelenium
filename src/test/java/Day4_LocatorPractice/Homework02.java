package Day4_LocatorPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Homework02 {

//Navigate to https://testpages.herokuapp.com/styled/index.html
// Click on Calculate under Micro Apps.
// Type any number in the first input.
// Type any number in the second input.
// Click on Calculate.
// Get the result.
// Print the result.

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

        //Navigate to https://testpages.herokuapp.com/styled/index.html sayfası açıldı
        driver.get("https://testpages.herokuapp.com/styled/index.html");


// Click on Calculate under Micro Apps.
        driver.findElement(By.xpath("//a[@id='calculatetest']")).click();

// Type any number in the first input.
driver.findElement(By.xpath("//input[@id='number1']")).sendKeys("1100");

// Type any number in the second input.
        driver.findElement(By.xpath("//input[@id='number2']")).sendKeys("89");
// Click on Calculate.
        driver.findElement(By.xpath("//input[@id='calculate']")).click();
// Get the result.
        String result = driver.findElement(By.xpath("//span[@id='answer']")).getText();
// Print the result.
        System.out.println("Toplam sonuç "+result);

    }













}
