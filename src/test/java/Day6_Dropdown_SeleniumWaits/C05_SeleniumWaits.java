package Day6_Dropdown_SeleniumWaits;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.BaseTest;

import java.time.Duration;

public class C05_SeleniumWaits extends BaseTest {

    //explicit wait

    @Test
    public void webDriverWait(){
        //1.adım WebDriverwait obj oluşturduk
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

       //WebElement category = driver.findElement(By.xpath());
       //wait.until(ExpectedConditions.visibilityOf())
    }





}
