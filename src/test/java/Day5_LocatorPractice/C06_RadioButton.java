package Day5_LocatorPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_RadioButton {

//    Go to URL:  https://www.facebook.com/
//    Click on Create an Account button.
//    Then click on the radio buttons.
//    Click 'Kadin'
//    Click 'Erkek'
//      Validate 'Kadin' is not selected and 'Erkek' is selected.


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

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void checkBoxes() {

//    Go to URL:  https://www.facebook.com/
        driver.get("https://www.facebook.com/");

//    Click on Create an Account button.// önemli contains kullanımı önemli
        WebElement registerButton = driver.findElement(By.xpath("//a[contains(@data-testid,'registration-form')]"));
        registerButton.click();

//    Then click on the radio buttons.
        WebElement kadinRadio = driver.findElement(By.xpath("//input[@name='sex' and @value='1']"));
        WebElement erkekRadio = driver.findElement(By.xpath("//input[@name='sex' and @value='2']"));

//    Click 'Kadin'
//    Click 'Erkek'


        kadinRadio.click();
        erkekRadio.click();

//      Validate 'Kadin' is not selected and 'Erkek' is selected.
        Assert.assertTrue(erkekRadio.isSelected());
        Assert.assertFalse(kadinRadio.isSelected());
        // Assert.assertTrue(!kadinRadio.isSelected());


    }


}
