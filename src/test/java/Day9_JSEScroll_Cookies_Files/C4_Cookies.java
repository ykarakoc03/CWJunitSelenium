package Day9_JSEScroll_Cookies_Files;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.BaseTest;

import java.util.Set;

public class C4_Cookies extends BaseTest {


    @Test
    public void test01(){
        driver.get("https://kitchen.applitools.com/ingredients/cookie");
        System.out.println("test get cookie");

       Cookie cookie=driver.manage().getCookieNamed("protein");//cookie yi isimle çagırdık
        Assert.assertEquals("chicken",cookie.getValue());

        //sayfadaki tüm cookie leri getirir(locate olmadan)
        Set<Cookie> allCookies = driver.manage().getCookies();
        int numOfCookies =allCookies.size();
        System.out.println("numOfCookies = " + numOfCookies);

        for (Cookie each:allCookies) {
            System.out.println("each cookie : "+each);
            System.out.println("each cookie name : "+each.getName());
            System.out.println("each cookie value : "+each.getValue());
        }

        System.out.println("add cookie");
        Cookie cookie1= new Cookie("fruit","apple");//cookie oluşturduk
        driver.manage().addCookie(cookie1);//cookie ekledik

        //kontrol yapıyoruz //ilk deger cookie1'in value sini getirdi
        // ikinci deger sayfadan cookiename içinde name girerek value sini çağırdık
        Assert.assertEquals(cookie1.getValue(),driver.manage().getCookieNamed(cookie1.getName()).getValue());

        allCookies=driver.manage().getCookies();// sayfada var olan coockie leri doldurdu set oldugu için benzersiz oldu
        System.out.println("allCookies size= " + allCookies.size());

        //Edit Coocie
        System.out.println("edit cookie");
        //cookie1 e value olarak mango ile değiştirdik
        Cookie editedCookie = new Cookie(cookie1.getName(),"mango");
        driver.manage().addCookie(editedCookie);//cookie değiştirildi

        Assert.assertEquals(editedCookie.getValue(),driver.manage().getCookieNamed(cookie1.getName()).getValue());
        //sayfadai eklenen degeri yazdırdık
        System.out.println(driver.manage().getCookieNamed(cookie1.getName()).getValue());


        //delete Cookie.


    }


    @Test
    public void deleteCookies() {
        driver.get("https://kitchen.applitools.com/ingredients/cookie");

        System.out.println("delete cookie");
        //sayfadaki tüm cookie leri getirir(locate olmadan)
        Set<Cookie> allCookies = driver.manage().getCookies();
        int numOfCookies =allCookies.size();
        System.out.println("Cookies size= " + numOfCookies);

        Cookie addCookie= new Cookie("drins","ayran");//cookie oluşturduk
        driver.manage().addCookie(addCookie);//cookie ekledik

        allCookies=driver.manage().getCookies();// sayfada var olan coockie leri doldurdu set oldugu için benzersiz oldu
        System.out.println("ekli Cookies size= " + allCookies.size());

        driver.manage().deleteCookie(addCookie);//eklediğimiz cookie yi sildik

        //kontrol. Sildiğimiz cookiyi aradık. bulamayınca null dönürdü
        Assert.assertNull("cookie halen var",driver.manage().getCookieNamed(addCookie.getName()));

        //hepsini sildik
        driver.manage().deleteAllCookies();

        allCookies=driver.manage().getCookies();// sayfada var olan coockie leri doldurdu set oldugu için benzersiz oldu
        System.out.println("sildikten sonra Cookies size= " + allCookies.size());
    }
}
