package Day6_Dropdown_SeleniumWaits;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;
import java.time.Duration;
import java.util.List;

public class Homework_DropDownFakerClass {

/*
Go to URL: https://opensource-demo.orangehrmlive.com/
Login with Username: Admin
Login with Password: admin123
Click login button
Click on PIM
Click on Employee List
    Employee Name -> Use Faker Class
    ID -> Use Faker Class
    Employment Status -> select by index: 2
    Include -> selectByVisibleText: Current and Past Employees
    Supervisor Name -> Use Faker Class
    Job Title ->selectByValue: IT Manager
    Sub Unit ->selectByValue: 3
Click search button
Verify text visible : "No Records Found"
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
    public void dropDownFaker()  {

        //Go to URL: https://opensource-demo.orangehrmlive.com/
        driver.get("https://opensource-demo.orangehrmlive.com/");

        //Login with Username: Admin
        WebElement admin= driver.findElement(By.xpath("//input[@name='username']"));
        admin.sendKeys("Admin");


        //Login with Password: admin123
        WebElement password=driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("admin123");

        //Click login button
        WebElement button= driver.findElement(By.xpath("//button[@type='submit']"));
        button.click();

        //Click on PIM
        WebElement pim= driver.findElement(By.xpath("//li[@class='oxd-main-menu-item-wrapper'][2]"));
        pim.click();

        //Click on Employee List
        WebElement employee= driver.
                findElement(By.xpath("//a[@class='oxd-topbar-body-nav-tab-item' and text()='Employee List']"));
        employee.click();


        Faker faker=new Faker();
        //input elementleri için liste(faker ile doldurulacak)
        List<WebElement> infoButtons = driver.
                findElements(By.xpath("//div[@class='oxd-grid-4 orangehrm-full-width-grid']//input"));

        //iç ice div ile yapılan select elementlerinin listesi
        List<WebElement> selectList = driver.
                findElements(By.xpath("//div[@class='oxd-grid-4 orangehrm-full-width-grid']//div[@class='oxd-select-wrapper']"));

        //div elementlerinde seçim için Action
        Actions actions = new Actions(driver);

        //Employee Name -> Use Faker Class
        infoButtons.get(0).sendKeys(faker.name().name());

        //ID -> Use Faker Class
        infoButtons.get(1).sendKeys(faker.idNumber().valid());

        //Employment Status -> select by index: 2
        //selectList.get(0).click();
        actions.click(selectList.get(0)).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).click().build().perform();

        //Include -> selectByVisibleText: Current and Past Employees
        actions.click(selectList.get(1)).sendKeys(Keys.DOWN).click().perform();

        //Supervisor Name -> Use Faker Class
        infoButtons.get(2).sendKeys(faker.name().firstName());

        //Job Title ->selectByValue: IT Manager
        actions.click(selectList.get(2)).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).
                sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).click().perform();

        //Sub Unit ->selectByValue: 3
        actions.click(selectList.get(3)).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).
                sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).click().perform();

        //Click search button
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        //Verify text visible : "No Records Found"
        WebElement noRecordText = driver.findElement(By.xpath("(//span[@class='oxd-text oxd-text--span'])[1]"));
        Assert.assertTrue(noRecordText.isDisplayed());







    }


}
