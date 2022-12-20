package Day4_LocatorPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class Deneme01_Practice {

/*
©
36
Relative Locator
Go to http://www.bestbuy.com
Verify that the page title contains "Best" Also, using Relative Locator.
LogoTest → Verify if the BestBuy logo is displayed.
mexicoLinkTest → Verify if the link is displayed
 */


    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        // 10 sn boyunca sitenin açılıp açılmadığını denetliyor
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://www.bestbuy.com");

        //driver maxsimum yapıldı
        driver.manage().window().maximize();
    }

    //@After
    //public void tearDown() {
    //    driver.quit();
    //}

    @Test
    @Ignore
    public void idLocators() {

        //link[rel='icon']
        //Verify that the page title contains "Best" Also, using Relative Locator.

        By titleName = RelativeLocator.with(By.tagName("title")).below(By.tagName("link"));
        System.out.println(driver.findElement(titleName).getText());
    }

    @Test
    public void logoTest() {

        //LogoTest → Verify if the BestBuy logo is displayed.
        By logo = RelativeLocator.with(By.className("logo")).below(By.tagName("heading"));

       Assert.assertTrue(driver.findElements(logo).get(0).isDisplayed());


    }










}
