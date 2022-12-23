package Day6_Dropdown_SeleniumWaits;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Deneme01_FreeWork {

/*
©
19
Free Work
https://demo.guru99.com/test/newtours/register.php
Bu sayfada çalışma yapabilirsiniz.
 */

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

    // @After
    // public void tearDown() throws InterruptedException {
    //     Thread.sleep(3000);
    //     driver.quit();
    // }

    @Test
    public void formTest() {

        driver.get("https://demo.guru99.com/test/newtours/register.php");
        Faker faker = new Faker();
        locator("//input[@name='firstName']").sendKeys(faker.name().firstName());
        locator("//input[@name='lastName']").sendKeys(faker.name().lastName());
        locator("//input[@name='phone']").sendKeys(faker.phoneNumber().phoneNumber());
        locator("//input[@name='userName']").sendKeys(faker.internet().emailAddress());
        locator("//input[@name='address1']").sendKeys(faker.address().fullAddress());
        locator("//input[@name='city']").sendKeys(faker.address().city());
        locator("//input[@name='state']").sendKeys(faker.address().state());
        locator("//input[@name='postalCode']").sendKeys(faker.address().zipCode());


        Select select=new Select(locator("//select[@name='country']"));
        select.selectByIndex(9);

        locator("//input[@name='email']").sendKeys(faker.name().username());

        String passt=faker.internet().password();
        locator("//input[@name='password']").sendKeys(passt);
        locator("//input[@name='confirmPassword']").sendKeys(passt);

        locator("//input[@name='submit']").submit();

    }


    public WebElement locator(String xpath) {

        WebElement element = driver.findElement(By.xpath(xpath));

        return element;
    }
}
