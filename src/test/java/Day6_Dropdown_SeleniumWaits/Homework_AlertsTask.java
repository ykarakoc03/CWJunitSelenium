package Day6_Dropdown_SeleniumWaits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import utilities.BaseTest;

import javax.swing.plaf.basic.BasicButtonUI;
import java.time.Duration;

public class Homework_AlertsTask extends BaseTest {

/*
Go to URL: http://demo.automationtesting.in/Alerts.html
Click "Alert with OK" and click 'click the button to display an alert box:’
Accept Alert(I am an alert box!) and print alert on console.
Click "Alert with OK & Cancel" and click 'click the button to display a confirm box’
Cancel Alert  (Press a Button !)
Click "Alert with Textbox" and click 'click the button to demonstrate the prompt box’
And then sendKeys «BootcampCamp» (Please enter your name)
Finally print on console this message "Hello BootcampCamp How are you today" assertion these message.
 */



    @Test
    public void test1() throws InterruptedException {

        driver.get(" http://demo.automationtesting.in/Alerts.html");


        //Click "Alert with OK" and click 'click the button to display an alert box:
        //Accept Alert(I am an alert box!) and print alert on console.
        butonlaraBas("//a[contains(text(),'Alert with OK')]");
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();


        //Click "Alert with OK & Cancel" and click 'click the button to display a confirm box
        butonlaraBas("//a[contains(@href,'CancelTab')]");
        //Cancel Alert  (Press a Button !)
        driver.switchTo().alert().dismiss();


        //Click "Alert with Textbox" and click 'click the button to demonstrate the prompt box
        butonlaraBas("//a[contains(@href,'Textbox')]");
        //And then sendKeys «BootcampCamp» (Please enter your name)
        driver.switchTo().alert().sendKeys("BootcampCamp");
        //Finally print on console this message "Hello BootcampCamp How are you today" assertion these message.
        Assert.assertEquals(consolMesaj(),"Hello BootcampCamp How are you today");

    }


    public void butonlaraBas(String xPath) {
        //parametre ile gelen xpath ve click
        WebElement alertWithOk = driver.findElement(By.xpath(xPath));
        alertWithOk.click();

        //yeri sabit olan "click the button to display a comfirm box"
        WebElement clickTheButton = driver.findElement(By.xpath("//button[contains(@class,'btn-danger')]"));
        clickTheButton.click();

    }

    public String consolMesaj() {
        //sitedeki konsolekranına yazan mesaj
      return   driver.findElement(By.xpath("//p[@id='demo1']")).getText();
    }


}
