package Day1_SeleniumMaven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_JunitAssertions {

    //    Go to Amazon homepage.
//    Do the following tasks by creating 3 different test methods.
//    1- Test if the URL contains Amazon.
//    2- Test if the title does not contain Facebook.
//    3- Test that the Amazon logo appears in the upper left corner.

    //    assertEquals
//    assertTrue
//    assertFalse
//    assertNull
//    assertNotNull
//    assertSame
//    assertNotSame
//    assertArrayEquals
    WebDriver driver;

    @Before
    public void before() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @After
    public void after() {
        driver.quit();
    }

    @Test
    public void urlTest() {
        driver.get("https://www.amazon.com");
        String currentUrl = driver.getCurrentUrl();

        //URL amazon kelimesini içeriyor mu kontrol ediyoruz
        //message yazmasak da olur. tek boolean deger de alabilir
        Assert.assertTrue("Url amazon içermiyor", currentUrl.contains("amazon"));

    }

    @Test
    public void titleTest() {
        driver.get("https://www.amazon.com");
        String title = driver.getTitle();
        Assert.assertFalse(title.contains("Facebook"));//assertTrue kullanıp şarta ! konularakta kullanaılabilir

    }

    //TO BE CONTINUED
    // 3- Test that the Amazon logo appears in the upper left corner.
    @Test
    public void testLogo(){
        driver.get("https://www.amazon.com/");
        WebElement logoElement = driver.findElement(By.xpath("//a[@id='nav-logo-sprites']"));
        // WebElement logoElement = driver.findElement(By.cssSelector("#nav-logo > a > span.nav-sprite.nav-logo-base"));
        // Check if the logo element is displayed
        Assert.assertTrue(logoElement.isDisplayed());
    }
}
