package Day9_JSEScroll_Cookies_Files;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.BaseTest;

import java.util.Set;

public class Homework_Cookies extends BaseTest {

    //Go to URL: http://facebook.com
    //getCookies,
    //addCookie,
    //deleteCookieNamed,
    //deleteAllCookies.


    @Test
    public void cookiesTest()  {


        //Go to URL: http://facebook.com
        driver.get("http://facebook.com");


        //getCookies,
        Set<Cookie> cookies=driver.manage().getCookies();
        int cookiesSize=cookies.size();
        System.out.println("cookiesSize = " + cookiesSize);
        cookies.stream().forEach(t-> System.out.println(t.getValue()));


        //addCookie,
        Cookie addNewCookie= new Cookie("cips","leys");
        driver.manage().addCookie(addNewCookie);
        System.out.println("yeni eklenen varmı:"+driver.manage().getCookieNamed("cips").getValue());
        Assert.assertEquals(addNewCookie.getValue(),driver.manage().getCookieNamed(addNewCookie.getName()).getValue());

        System.out.println("ekleme sonrası cookie listesi :");
        cookies=driver.manage().getCookies();
        cookies.stream().forEach(t-> System.out.println(t.getValue()));



        //deleteCookieNamed,
        driver.manage().deleteCookieNamed(addNewCookie.getName());
        System.out.println("Yeni eklenen hala varmı :"+driver.manage().getCookieNamed(addNewCookie.getName()));
        Assert.assertNull(driver.manage().getCookieNamed(addNewCookie.getName()));


        //deleteAllCookies.
        driver.manage().deleteAllCookies();
        cookies=driver.manage().getCookies();
        System.out.println("silme sonrası cookies.size() = " + cookies.size());
        System.out.println("Silme işlemi sonrası kalanlar :");
        cookies.stream().forEach(t-> System.out.println(t.getValue()));




    }
}
