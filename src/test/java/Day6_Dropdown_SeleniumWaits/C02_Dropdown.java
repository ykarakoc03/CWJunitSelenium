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

public class C02_Dropdown {

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
    public void selecByIndex() {

        driver.get("https://demo.guru99.com/test/newtours/register.php");
//dropsown locate edildi
        WebElement drpDown = driver.findElement(By.name("country"));

        //Locate edilen dropdown select objesine dönüştü
        Select select = new Select(drpDown);

        //selectByIndex 0'dan başlar
        select.selectByIndex(1);

    }

    @Test
    public void selectByValue() {

        driver.get("https://demo.guru99.com/test/newtours/register.php");
        //dropsown locate edildi
        WebElement drpDown = driver.findElement(By.name("country"));

        //Locate edilen dropdown select objesine dönüştü
        Select select = new Select(drpDown);

        //selectByIndex 0'dan başlar
        select.selectByValue("TURKEY");

    }

    @Test
    public void selectByVisibleText() {

        driver.get("https://demo.guru99.com/test/newtours/register.php");

        //dropsown locate edildi
        WebElement drpDown = driver.findElement(By.name("country"));

        //Locate edilen dropdown select objesine dönüştü
        Select select = new Select(drpDown);

        select.selectByVisibleText("NEPAL");

        System.out.println(select.isMultiple());//çoklu seçim yapmaya izin veriyor mu?//false
    }

    @Test
    public void multipleSelect() {
     driver.get("https://output.jsbin.com/osebed/2");

     Select select= new Select(driver.findElement(By.id("fruits")));
        System.out.println(select.isMultiple());//çoklu seçime izin veriyor mu?//True

        // iki seçim yapıldı
        select.selectByValue("apple");
        select.selectByIndex(3);

    }
    @Test
    public void getOptions() {

        driver.get("https://demo.guru99.com/test/newtours/register.php");

        Select select = new Select(driver.findElement(By.name("country")));

        //bütün select seceneklerini listeye attık
        List<WebElement> options = select.getOptions();

        for (WebElement option:options ) {//her bir Webelement in textini yazdırıyoruz
            System.out.println(option.getText());
        }


    }


    @Test
    public void getFirstSelectedOptions() {
        driver.get("https://output.jsbin.com/osebed/2");

        Select select= new Select(driver.findElement(By.id("fruits")));


        // iki seçim yapıldı

        select.selectByIndex(3);
        select.selectByIndex(2);
        System.out.println(select.getFirstSelectedOption().getText());//seçili olanlardan ilkini getir
    }

    @Test
    public void getAllSelectedoptions() {
        driver.get("https://output.jsbin.com/osebed/2");

        Select select= new Select(driver.findElement(By.id("fruits")));


        // iki seçim yapıldı

        select.selectByValue("banana");
        select.selectByValue("apple");
        List<WebElement> options = select.getAllSelectedOptions();
        options.forEach(t-> System.out.println(t.getText()));
    }


}
