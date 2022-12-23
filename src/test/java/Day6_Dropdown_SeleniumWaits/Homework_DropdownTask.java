package Day6_Dropdown_SeleniumWaits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Homework_DropdownTask {

/*
Go to URL: https://the-internet.herokuapp.com/dropdown
Create method selectByIndexTest and Select Option 1 using index .
Create method selectByValueTest Select Option 2 by value.
Create method selectByVisibleTextTest Select Option 1 value by visible text.
Create method printAllTest Print all dropdown value.
Verify the dropdown has Option 2 text.
Create method printFirstSelectedOptionTest Print first selected option.
Find the size of the dropdown, Print "Expected Is Not Equal Actual" if there are not 3 elements in the dropdown.
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


    //  @After
    // public void tearDown() throws InterruptedException {
    //     Thread.sleep(3000);
    //     driver.quit();
    // }

    @Test
    public void checkBoxes() throws InterruptedException {

        //Go to URL:
        driver.get("https://demoqa.com/select-menu");
        //Go to URL: https://the-internet.herokuapp.com/dropdown
        //Create method selectByIndexTest and Select Option 1 using index .
        //Create method selectByValueTest Select Option 2 by value.
        //Create method selectByVisibleTextTest Select Option 1 value by visible text.
        //Create method printAllTest Print all dropdown value.
        //        Verify the dropdown has Option 2 text.
        //        Create method printFirstSelectedOptionTest Print first selected option.
        //Find the size of the dropdown, Print "Expected Is Not Equal Actual" if there are not 3 elements in the dropdown.
    }
        public void kontrol(Select select,String renk) {
        Assert.assertEquals(select.getFirstSelectedOption().getText(), renk);
    }


}
