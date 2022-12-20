package Day3_LocatorPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Practice {
    //    Create the driver with BeforeClass and make it static inside the class.
//    Go to http://www.google.com
//    Type "Green Mile" in the search box and print the number of results.
//    Type "Premonition" in the search box and print the number of results.
//    Type "The Curious Case of Benjamin Button" in the search box and print the number of results.
//    Close with AfterClass.
    static WebDriver driver;

    @BeforeClass
    public static void createDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        // 10 sn boyunca sitenin açılıp açılmadığını denetliyor
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

    }

    @Before
    public void beforeEach(){
        // google sayfası açıldı
        driver.get("http://www.google.com");
    }


    @AfterClass
    public static void tearDown() {
       driver.quit();
    }

    @Test
    public void test1() {

       //1. adım-> Arama kutusuna "Green Mile" yazın ve sonuç sayısını yazdırın.
        WebElement search= driver.findElement(By.xpath("//input[@name='q']"));
        search.sendKeys("Green Mile", Keys.ENTER);

        WebElement result= driver.findElement(By.id("result-stats"));
        System.out.println(result.getText());

    }

    @Test
    public void test2() {

        //2. adım-> Arama kutusuna "Premonition" yazın ve sonuç sayısını yazdırın.
        WebElement search= driver.findElement(By.xpath("//input[@name='q']"));
        search.sendKeys("Premonition", Keys.ENTER);

        WebElement result= driver.findElement(By.id("result-stats"));
        System.out.println(result.getText());


    }

    @Test
    public void test3() {

        //3. adım-> Arama kutusuna "Benjamin Button'ın Tuhaf Hikayesi" yazın ve sonuç sayısını yazdırın.
        WebElement search= driver.findElement(By.xpath("//input[@name='q']"));
        search.sendKeys("The Curious Case of Benjamin Button", Keys.ENTER);

        WebElement result= driver.findElement(By.id("result-stats"));
        System.out.println(result.getText());


    }







}
