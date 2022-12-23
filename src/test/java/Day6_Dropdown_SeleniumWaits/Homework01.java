package Day6_Dropdown_SeleniumWaits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Homework01 {

/*
Launch the browser.
Open "https://demoqa.com/select-menu".
Select the Standard Multi-Select using the element id.
Verifying that the element is multi-select.
Select 'Opel' using the index and deselect the same using index.
Select 'Saab' using value and deselect the same using value.
Deselect all the options.
Close the browser.
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


    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void checkBoxes() throws InterruptedException {

        //Go to URL:
        //        Open "https://demoqa.com/select-menu".
        driver.get("https://demoqa.com/select-menu");

        // Select the Standard Multi-Select using the element id.
        WebElement cars = driver.findElement(By.id("cars"));
        Select select = new Select(cars);


        //Verifying that the element is multi-select.
        Assert.assertTrue(select.isMultiple());

        //Select 'Opel' using the index and deselect the same using index.
        select.selectByIndex(2);
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "Opel");
        select.deselectByIndex(2);
        Assert.assertTrue(!cars.isSelected());

        //Select 'Saab' using value and deselect the same using value.
        select.selectByValue("saab");
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "Saab");
        select.deselectByValue("saab");
        Assert.assertTrue(!cars.isSelected());

        //Deselect all the options.
        select.deselectAll();

    }

}
