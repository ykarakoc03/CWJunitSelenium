package Day5_LocatorPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class C01_RelativeLocator {

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
    public void relativeLocator() {


        //Verify that the page title contains "Best" Also, using Relative Locator.
        Assert.assertTrue("Title Best kelimesini içermiyor.", driver.getTitle().contains("Best"));

        //Logo locate ediliyor
        By logoLocator = RelativeLocator.with(By.tagName("img")).above(By.xpath("//div[text()='Hello!']"));
        WebElement logo = driver.findElement(logoLocator);
        Assert.assertTrue(logo.isDisplayed());

        //mexicoLinkTest → Verify if the link is displayed
        By mexicoLocator = RelativeLocator.with(By.tagName("a")).toRightOf(By.xpath("//div[@lang='en']//a[@class='us-link']"));
        WebElement mexicoLink = driver.findElement(mexicoLocator);
        Assert.assertTrue(mexicoLink.isDisplayed());


    }


}
