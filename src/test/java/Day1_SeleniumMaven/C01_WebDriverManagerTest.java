package Day1_SeleniumMaven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_WebDriverManagerTest {

    // Set Path.
// Create chrome driver.
// Maximize the window.
// Open google home page https://www.google.com/
// Verify that you are Google in the title.

    public static void main(String[] args) {

        //System.setProprty("","") yerine maven sayesinde chrome binarylarimizi indirdik
        WebDriverManager.chromedriver().setup();

        //Driver objenizi oluşturduk.Browser açtık
        WebDriver driver = new ChromeDriver();

        // SAYFAYI MAXSİMİZE YAPTIK
        driver.manage().window().maximize();

        //google sayfasını açtık
        driver.get("https://www.google.com/");

        //sayfamızın title nı aldık
        String title = driver.getTitle();

        //title mizi doğruluyoruz
        System.out.println("Title Testi Yapılıyor....");
        if (title.equals("Google")) {
            System.out.println("Title test PASSED");
        } else {
            System.out.println("Title test FAILED");
        }



        driver.quit();
    }

}
