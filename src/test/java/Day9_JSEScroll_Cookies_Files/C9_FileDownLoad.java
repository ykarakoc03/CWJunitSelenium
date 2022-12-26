package Day9_JSEScroll_Cookies_Files;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C9_FileDownLoad extends BaseTest {
/*
Go to URL: https://opensource-demo.orangehrmlive.com/
Login page valid credentials.
Download sample CSV file.
Verify if the file downloaded successfully.
 */

    @Override
    public void tearDown() throws InterruptedException {

    }

    @Test
    public void filrDownload() throws InterruptedException {

        driver.get("https://opensource-demo.orangehrmlive.com/");

        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("Admin");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("admin123");

        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        WebElement PIM = driver.findElement(By.xpath("(//a[@class='oxd-main-menu-item'])[2]"));
        PIM.click();

        WebElement configuration = driver.findElement(By.xpath("//span[text()='Configuration ']"));
        configuration.click();

        WebElement dataImport = driver.findElement(By.linkText("Data Import"));
        dataImport.click();

        WebElement download = driver.findElement(By.className("download-link"));
        download.click();
        Thread.sleep(3000);//indirmesi için süre

        //indirilen klasörde olması gereken yeri ve dosya adını verdik
        String downloadPath = "C:\\Users\\Nutzer\\Downloads\\importData.csv";


        Assert.assertTrue("indirilen dosya bulunamadı", Files.exists(Paths.get(downloadPath)));


    }
}
