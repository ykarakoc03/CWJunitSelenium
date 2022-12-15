package Day2_WebElementLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_Locators {

    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        // 10 sn boyunca sitenin açılıp açılmadığını denetliyor
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //Linkedin sayfası açıldı
        driver.get("https://www.linkedin.com/");

        //driver maxsimum yapıldı
        driver.manage().window().maximize();
    }

    //@After
    //public void tearDown() {
    //    driver.quit();
    //}

    @Test
    public void idLocators() {
        //id Locator->"session_key"
        WebElement email = driver.findElement(By.id("session_key"));
        email.sendKeys("clarusway@gmail.com");
    }

    @Test
    public void nameLocators() {
        //name Locators-> "session_password"
        WebElement password = driver.findElement(By.name("session_password"));
        password.sendKeys("Clarus123."/* ,Keys.ENTER */);
    }

    @Test
    public void classLocators() {
        //class Locators->input__input
        WebElement email = driver.findElement(By.className("input__input"));
        //findElement tek eleman getirir ama class  ismiyle birden çok element olabilir.bu methot ilk eşleşmeyi getiriyor. eşleşme olmazsa exception fırlatır
        //findElements butun bulunanaları liste şekline döndürür. bulamaazsa boş liste döndürür (Rte vermez)
        email.sendKeys("Class locator test");


    }

    @Test
    public void tagLocator(){

        // tag locator -> "input"

        List<WebElement> emailList = driver.findElements(By.tagName("input"));


        // 2. elementimiz email text alanimiz. Bu yuzden bu elemani email degiskenine assign ettik.
        WebElement email = emailList.get(1);

        email.sendKeys("Tag locator test");

    }

    @Test
    public void linkLocator() {//anlamadım çalışmıyor
        // link text -> "Şifrenizi mi unuttunuz?"

        WebElement forgotPwd = driver.findElement(By.linkText("Şifrenizi mi unuttunuz?"));
        forgotPwd.click();

    }

    @Test
    public void partiallinkTextLocator() {// anlamadım çalışmıyor
        // link text -> "Forgot password?"

        WebElement forgotPwd = driver.findElement(By.partialLinkText("unuttunuz"));
        forgotPwd.click();
/*
 normal LinkText konumlandırıcısına benzer şekilde çalışır.
Selenium WebDriver’da Partial LinkText kullanılma nedeni, uzun bir bağlantı metninizin olması ve
üzerinde daha fazla işlem yapmak için yalnızca kısmi metin kullanmak istediğinizden kaynaklanmaktadır.
Bazen bunu kullanma amacı, ortak kısmi metne sahip bir sayfada birden çok bağlantıyı bulmak olabilir
 */
    }


    @Test
    public void absoluteXpath() {
        //ilgili kod blogunu bulup sag tıklayıp copy-> full path aldık (çok kullanılmaz) :html/body/main/section[1]/div/div/form/div[2]/div[1]/input
        // güncelleme oldugunda ve bu silsilede en ufak bir değişiklik olunca problem olur. çalışmaz
        WebElement email = driver.findElement(By.xpath("/html/body/main/section[1]/div/div/form/div[2]/div[1]/input"));
        email.sendKeys("absolut xpath başarılı");
    }


    @Test
    public void relativeXpath() {
        //ilgili kod blogunu bulup sag tıklayıp copy-> xpath aldık (tercih edilen) ://*[@id="session_key"]
        // çift çizgi ile başlar.[]-> opsiyoneldir,zorunlu değil
        //en yavaş çalışmasına rağmen sektörde çok yaygın kullanılır
        WebElement email = driver.findElement(By.xpath("//*[@id='session_key']"));
        email.sendKeys("relative xpath başarılı");
    }


}
