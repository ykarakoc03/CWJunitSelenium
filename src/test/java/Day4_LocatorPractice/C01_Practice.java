package Day4_LocatorPractice;

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

//Navigate to website  https://testpages.herokuapp.com/styled/index.html
// Under the ORIGINAL CONTENTS
// Click on Alerts
// Print the URL
// Navigate back
// Print the URL
// Click on Basic Ajax
// Print the URL
// Enter value  20 and Enter
// And then verify Submitted Values is displayed open page
// Close driver.



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

    //@After
    //public void tearDown() {
    //    driver.quit();
    //}

    @Test
    public void idLocators() {
        // sayfası açıldı
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        //Under the ORIGINAL CONTENTS,Click on Alerts
        WebElement alerts= driver.findElement(By.xpath("//*[@id='alerts']"));
        alerts.click();
        // Print the URL
        System.out.println(driver.getCurrentUrl());
        // Navigate back
        driver.navigate().back();
        // Print the URL
        System.out.println(driver.getCurrentUrl());
        // Click on Basic Ajax
        WebElement basic = driver.findElement(By.id("basicajax"));
        basic.click();
        // Print the URL
        System.out.println(driver.getCurrentUrl());
        // Enter value  20 and Enter
        WebElement value= driver.findElement(By.id("lteq30"));
        value.sendKeys("20", Keys.ENTER);
        // And then verify Submitted Values is displayed open pag
        WebElement submitElement = driver.findElement(By.xpath("// p[text()='Submitted Values']"));
        Assert.assertTrue(submitElement.isDisplayed());
        //sadece text ten locat etme:
        // p[text()='Submitted Values']
        //p[.='Submitted Values']//kendisi yada alt childlarıda dahil
        //p[contains(text(),'Submitted Values')]
    }










}
