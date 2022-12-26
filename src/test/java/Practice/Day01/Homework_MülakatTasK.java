package Practice.Day01;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.BaseTest;

import java.time.Duration;
import java.util.Scanner;

public class Homework_MülakatTasK extends BaseTest {

    /*

Belli kurallar çerçevesinde bir sitenin Test Otomasyonu hazırlanacaktır. Dikkat
edilmesi gerekenler kısmındaki tüm adımların yapılması zorunlu değildir fakat her
birisi size artı puan olarak değerlendirilecektir.
Proje Hazırlanırken Dikkat Edilmesi Gerekenler
● Proje Java programlama dilinde yazılmalıdır.
● Kodlar GitHub üzerinden paylaşılması gereklidir.
(Fmharmanci ve VirgosolQA kullanıcı adları ile proje paylaşılacaktır.)
● Yazılacak senaryo için Selenium ve JUnit kullanılmalıdır.
● Assertions kullanarak senaryonun doğru çalışırlığı kontrol edilmelidir.
● Log4j kullanılmalıdır.
● Page Object Model uygulanmalıdır.
● OOP prensiplerine uygun geliştirilmelidir.
Projeyi aşağıdaki senaryoya uygun olarak hazırlamalısın.
Amazon Senaryosu
//o https://www.amazon.com.tr/ sitesi açılır.
//o Ana sayfanın açıldığı kontrol edilir.
//o Çerez tercihlerinden Çerezleri kabul et seçilir.
//o Siteye login olunur.
//o Login işlemi kontrol edilir.
//o Arama butonu yanındaki kategoriler tabından bilgisayar seçilir.
//o Bilgisayar kategorisi seçildiği kontrol edilir.
//o Arama alanına MSI yazılır ve arama yapılır.
//o Arama yapıldığı kontrol edilir.
//o Arama sonuçları sayfasından 2. sayfa açılır.
//o 2. sayfanın açıldığı kontrol edilir.
//o Sayfadaki 2. ürün favorilere eklenir.
//o 2. Ürünün favorilere eklendiği kontrol edilir.
//o Hesabım > Favori Listem sayfasına gidilir.
//o “Favori Listem” sayfası açıldığı kontrol edilir.
//o Eklenen ürün favorilerden silinir.
//o Silme işleminin gerçekleştiği kontrol edilir.
//o Üye çıkış işlemi yapılır.
//o Çıkış işleminin yapıldığı kontrol edilir.

     */

    @Override
    @After
    public void tearDown() throws InterruptedException {
        //super.tearDown();
    }

    @Test
    public void test01() {


        /*
        NOT:
        5. ve 6. adımlara kayıtlı e mail ve şifre girmeyi unutmayınız!!!
         */

        //o https://www.amazon.com.tr/ sitesi açılır.
        driver.get("https://www.amazon.com.tr/");

        //o Ana sayfanın açıldığı kontrol edilir.**farklı bir code olabilir
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.amazon.com.tr/");

        //o Çerez tercihlerinden Çerezleri kabul et seçilir.
        try {

            if (idElemanBul("sp-cc").isDisplayed()) {
                idElemanBul("sp-cc-accept").click();
            }
        }catch (NoSuchElementException e){
            System.out.println("çerez yok");
        }

        //o Siteye login olunur.
        Actions actions =new Actions(driver);
        actions.moveToElement(idElemanBul("nav-link-accountList")).perform();
        bekleBi(idElemanBul("nav-flyout-ya-signin"));


        //email girişi yapılır
        xpathElemanBul("//input[@name='email']").sendKeys("epostagir@eposta.com", Keys.ENTER);

        //şifre girişi yapılır
        cssSelectorElemanBul("#ap_password").sendKeys("sifree",Keys.ENTER);


        //o Login işlemi kontrol edilir.//ref_=nav_signin
           Assert.assertTrue(idElemanBul("nav-link-accountList-nav-line-1").isDisplayed());

        //o Arama butonu yanındaki kategoriler tabından bilgisayar seçilir.
        Select select=new Select(idElemanBul("searchDropdownBox"));
        select.selectByValue("search-alias=computers");


        //o Bilgisayar kategorisi seçildiği kontrol edilir.
        Assert.assertEquals(select.getFirstSelectedOption().getText(),"Bilgisayarlar");


        //o Arama alanına MSI yazılır ve arama yapılır.
        idElemanBul("twotabsearchtextbox").sendKeys("MSI",Keys.ENTER);


        //o Arama yapıldığı kontrol edilir.
        Assert.assertTrue(xpathElemanBul("//div[@class='a-section a-spacing-small a-spacing-top-small']").getText().contains("Aranan ürün"));

        //o Arama sonuçları sayfasından 2. sayfa açılır.
        WebElement button2sayfa= xpathElemanBul("//a[text()='2']");
        JavascriptExecutor jse= (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();",button2sayfa);
        button2sayfa.click();

        //o 2. sayfanın açıldığı kontrol edilir.
        Assert.assertTrue(driver.getCurrentUrl().contains("page=2") );

        //o Sayfadaki 2. ürün favorilere eklenir.
        xpathElemanBul("(//div[@data-component-type='s-search-result'])[2]").click();

        //o 2. Ürünün favorilere eklendiği kontrol edilir.
        //favoru yerine listeye ekleme olarak güncellenmiş:
        idElemanBul("add-to-wishlist-button-submit").click();

        //eger daha önce alışveriş listesi oluşturulmamışsa
        //Bu adım biraz bekletiyor
        try {

            if (idElemanBul("a-autoid-17-announce").isDisplayed()) {
                idElemanBul("a-autoid-17-announce").click();
            }
        }catch (NoSuchElementException e){
            System.out.println("önceden oluşturulmuş liste mevcut");
        }

        //alışverişe devam et butonu
        idElemanBul("continue-shopping").click();


        //o Hesabım > Favori Listem sayfasına gidilir.
        jse.executeScript("arguments[0].scrollIntoView();",idElemanBul("nav-link-accountList"));
        actions.moveToElement(idElemanBul("nav-link-accountList")).perform();

        bekleBi(idElemanBul("nav-flyout-wl-items"));

        //o “Favori Listem” sayfası açıldığı kontrol edilir.
        Assert.assertTrue(idElemanBul("profile-list-name").isDisplayed());

        //o Eklenen ürün favorilerden silinir.
        xpathElemanBul("//input[@name='submit.deleteItem']").click();

        //o Silme işleminin gerçekleştiği kontrol edilir.
        Assert.assertTrue(xpathElemanBul("//div[@class='a-row a-spacing-none']//div[@class='a-alert-content']").getText().contains("Silindi"));

        //o Üye çıkış işlemi yapılır.
        actions.moveToElement(idElemanBul("nav-link-accountList")).perform();
        bekleBi(idElemanBul("nav-item-signout"));



        //o Çıkış işleminin yapıldığı kontrol edilir.
        Assert.assertTrue(driver.getTitle().contains("Amazon Giriş Yap") );
    }
    public WebElement idElemanBul(String id){
        return driver.findElement(By.id(id));
    }

    public WebElement xpathElemanBul(String xpath){
        return driver.findElement(By.xpath(xpath));
    }
    public WebElement cssSelectorElemanBul(String cssSelector){
        return driver.findElement(By.cssSelector(cssSelector));
    }
    public void bekleBi(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));//Explicit Wait
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();//Explicit Wait
    }
}
