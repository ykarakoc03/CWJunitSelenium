package Day4_LocatorPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_CSSPractice {
    //http://the-internet.herokuapp.com/add_remove_elements/
// Click on the "Add Element" button 100 times.
// Write a function that takes a number, and clicks the "Delete" button.
// Given number of times, and then validates that given number of buttons was deleted.
// 1. Method: createButtons(100)
// 2. Method: DeleteButtonsAndValidate()
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

    //@After
    //public void tearDown() {
    //    driver.quit();
    //}


    @Test
    public void idLocators() {
        // sayfası açıldı
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");

        //createButton methodu ile 100 defa butona tıklıyoruz
        createElements(100);

        //deleteBuutton methodu ile 40 buton silinir ve kontrol edilir
        deleteButtonsAndValidate(40);


    }

    public void createElements(int amount) {
        WebElement addElementButton = driver.findElement(By.cssSelector("button[onclick='addElement()']"));
        for (int i = 0; i < amount; i++) {
            addElementButton.click();
        }

    }

    public void deleteButtonsAndValidate(int amount) {

        // sayfadaki delete button sayısını saklarız
        List<WebElement> deleteButtonList = driver.findElements(By.cssSelector(" button[onclick='deleteElement()']"));
        int silinmedenOnceDeleteButtonSayısı = deleteButtonList.size();//100

        //bizden istenen sayi kadar buttonu sileriz
        for (int i = 0; i < amount; i++) {
            deleteButtonList.get(i).click();
        }

        //silindikten sonraki buton sayısını sileriz
        List<WebElement> deleteButtunListAfter = driver.findElements(By.cssSelector(" button[onclick='deleteElement()']"));
        int silmeSonrasıButonSayısı = deleteButtunListAfter.size();//60

        //ilk sayı ile son sayı arasındaki farkı buluruz
        Assert.assertEquals(silinmedenOnceDeleteButtonSayısı - amount, silmeSonrasıButonSayısı);
        // Assert.assertEquals(silinmedenOnceDeleteButtonSayisi - amount, silinmedenSonraDeleteButtonSayisi);

    }


}
