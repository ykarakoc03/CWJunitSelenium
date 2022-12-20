package Day5_LocatorPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class C03_ChoromeOptions {

    @Test
    public void chromeOptions(){

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        //options.addArguments("headless");// sayfa açılmadan çalışıyor
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);

    }


}
