package Day5_LocatorPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class C05_Checkbox {

//    Go to URL: https://demoqa.com/
//    Click on Elements.
//    Click on Checkbox.
//    Verify if Home checkbox is selected.
//    Verify that "You have selected" is visible.

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
    public void checkBoxes() throws InterruptedException {

//    Go to URL: https://demoqa.com/
        driver.get("https://demoqa.com/");

//    Click on Elements.////div[@class='card-body']//*[contains(text(),'Elements')]
        WebElement elements= driver.findElement(By.xpath("//div[@class='card-up']"));
        Thread.sleep(5000);
        elements.click();


//    Click on Checkbox.
        WebElement checkboxButton = driver.findElement(By.xpath("//li[@id='item-1']//span[contains(text(),'Check Box')]"));
checkboxButton.click();


        //    Verify if Home checkbox is selected.
        WebElement homeCheckBox= driver.findElement(By.id("tree-node-home"));
        Assert.assertFalse("Home Checkbox seçili değil", homeCheckBox.isSelected());

//    Verify that "You have selected" is visible.
        homeCheckBox.click();
        WebElement result= driver.findElement(By.xpath("//div[@id='result']"));

        Assert.assertTrue("seçtin mesajını yazmadı",result.getText().contains("You have selected"));




    }


}
