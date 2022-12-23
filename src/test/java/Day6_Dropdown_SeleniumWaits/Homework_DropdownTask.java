package Day6_Dropdown_SeleniumWaits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

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

        //Go to URL: https://the-internet.herokuapp.com/dropdown
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement dropdwn= driver.findElement(By.id("dropdown"));
        //Create method selectByIndexTest and Select Option 1 using index .
        Select select=new Select(dropdwn);
        select.selectByIndex(1);

        //Create method selectByValueTest Select Option 2 by value.
        select.selectByValue("2");

        //Create method selectByVisibleTextTest Select Option 1 value by visible text.
        select.selectByVisibleText("Option 1");
        //Create method printAllTest Print all dropdown value.
        printAllTest(select,"value");

        //        Verify the dropdown has Option 2 text.
        Assert.assertTrue(!select.getFirstSelectedOption().getText().contains("Option 2"));

        //        Create method printFirstSelectedOptionTest Print first selected option.
        System.out.println(select.getFirstSelectedOption().getText());

        //Find the size of the dropdown, Print "Expected Is Not Equal Actual" if there are not 3 elements in the dropdown.

        Assert.assertEquals("Expected Is Not Equal Actual",select.getOptions().size(),3);

    }
    private void printAllTest(Select select,String value) {
        List<WebElement> options = select.getOptions();
        options.stream().forEach(t -> System.out.println(t.getText()));
    }

}
