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
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;
import java.util.List;

public class C04_Checkbox {

//    Go to https://the-internet.herokuapp.com/checkboxes
//    Locate the elements of checkboxes.
//    Then click on checkbox 1 if box is not selected.
//    Then click on checkbox 2 if box is not selected.
//    Then verify that checkbox 1 is checked.

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


//    Go to https://the-internet.herokuapp.com/checkboxes
        driver.get("https://the-internet.herokuapp.com/checkboxes");


//    Locate the elements of checkboxes.
        List<WebElement> checkBoxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
        WebElement checkbox1 = checkBoxes.get(0);
        WebElement checkbox2 = checkBoxes.get(1);

//    Then click on checkbox 1 if box is not selected.
        if (!checkbox1.isSelected()) {
            checkbox1.click();
        }
//    Then click on checkbox 2 if box is not selected.
        if (!checkbox2.isSelected()) {
            checkbox2.click();
        }

//    Then verify that checkbox 1 and checkbox 2 is checked.
    Assert.assertTrue(checkbox1.isSelected());
    Assert.assertTrue(checkbox2.isSelected());

    }


}
