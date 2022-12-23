package Day8_WindowHandles_Actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.BaseTest;

import java.util.Iterator;
import java.util.Set;

public class C01_WindowHanles_Actions extends BaseTest {


/*
Go to URL: https://testproject.io/
Selenium’s 4 newWindow() method to open a new Window for TestProject’s Blog page.
https://blog.testproject.io/
 */


    @Test
    public void newWindow() {

        //Go to URL: https://testproject.io/
        driver.get("https://testproject.io/");


        //Selenium’s 4 newWindow() method to open a new Window for TestProject’s Blog page.
        //Yeni pencere oluşturulup o pencereye switch ediliyor(aktif pencere yeni pencere olur)
        driver.switchTo().newWindow(WindowType.WINDOW);

        //yeni penceremize url giriyoruz
        driver.get("https://blog.testproject.io/");


    }

    @Test
    public void newTab() {
        /*
            WindowType.TAB -->yeni sekmede
            WindowTyoe.WINDOW --> yeni sayfada
         */
        driver.get("https://www.amazon.com/");

        //alternatif kullanım ve newWindow parametresi .TAB
        WebDriver newTab = driver.switchTo().newWindow(WindowType.TAB);

        newTab.get("https://testproject.io/");

        //yeni sekmenin title nı alıyoruz-> Aktif tabımız yeni oluşturduğumuz sayfa
        System.out.println(driver.getTitle());

    }


    @Test
    public void handleWindow() {

        driver.get("https://www.amazon.com/");

        String homepageHandle= driver.getWindowHandle();

        //yeni sekme oluşturduk
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.com.tr/");

        //yeni sayfa oluşturduk
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.google.com/");

        //Açık olan bütün sayfaların handle sini alıyoruz(getWindowHandles)
        Set<String> hantles=driver.getWindowHandles();
        Iterator<String> i= hantles.iterator();

        while (i.hasNext()){
            String currentTab=i.next();

            driver.switchTo().window(currentTab);

            System.out.println(driver.getTitle());

            //Ana sayfa harivindekileri kapatıyoruz
            if (!driver.getWindowHandle().equals(homepageHandle)) {
                driver.close();
            }
            /*
            //Ana sayfanın handle si alınmadıgı taktirde bu şekilde titlen içeriginden yararlanılabilir
            if(!driver.getTitle().contains("Spend")){
            }

             */

        }





    }


}