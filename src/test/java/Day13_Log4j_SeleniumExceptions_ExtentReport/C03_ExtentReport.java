package Day13_Log4j_SeleniumExceptions_ExtentReport;

import com.aventstack.extentreports.ExtentTest;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseTestReport;

public class C03_ExtentReport extends BaseTestReport {

    @Test
    public void test01() {

        //Testi yapacak olan her türlü mesajı geçip kaldıgını belirtecek axtentTest obj oluşturduk
        extentTest=extentReports.createTest("My Test", "Bu bir açıklamadır");

        //info mesaji yazdiriliyor
        extentTest.info("Amazon'a gidiliyor" );
        driver.get("https://amazon.com.tr/");

        WebElement serchBox = driver.findElement(By.id("twotabsearchtextbox"));
        extentTest.info("Arama kısmına lenovo laptop yazılıyor");
        serchBox.sendKeys("lenovo laptop");


        //Pass mesaji
        extentTest.pass("Testimiz gecerli");

        //Fail mesaji
        extentTest.fail("Testimiz gecersiz");

        //Skip mesaji
        extentTest.skip("Testimiz skip edildi");


    }
}
