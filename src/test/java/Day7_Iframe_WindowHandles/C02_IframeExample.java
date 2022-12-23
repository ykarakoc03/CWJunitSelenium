package Day7_Iframe_WindowHandles;

import com.github.dockerjava.api.model.Link;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.BaseTest;

import java.time.Duration;
import java.util.List;

public class C02_IframeExample extends BaseTest {
    // Web sitesini maximize yapınız.
// İkinci emojiye tıklayınız.
// Tüm ikinci emoji öğelerine tıklayınız.
// Parent iframe geri dönünüz.
// Formu doldurun (Formu istediğiniz metinlerle doldurun) apply button'a basınız.

    @Test
    public void iframeExample() {

        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");

        driver.switchTo().frame("emoojis");

        // İkinci emojiye tıklayınız.
        WebElement secondEmojiTab = driver.findElement(By.xpath("//a[contains(@href,'nature')]"));
        secondEmojiTab.click();

        // Tüm ikinci emoji öğelerine tıklayınız.
        List<WebElement> emojiList = driver.findElements(By.xpath("//div[@id='nature']//img"));
        emojiList.forEach(WebElement::click); // her bir img elementine tiklaniyor

        // Parent iframe geri dönünüz.
        driver.switchTo().defaultContent();


        //Form dolduruluyor
        WebElement text = driver.findElement(By.id("text"));
        text.sendKeys("Text");

        WebElement smiles = driver.findElement(By.id("smiles"));
        smiles.sendKeys("Smiles");

        WebElement nature = driver.findElement(By.id("nature"));
        nature.sendKeys("Nature");

        WebElement food = driver.findElement(By.id("food"));
        food.sendKeys("Food");

        WebElement activities = driver.findElement(By.id("activities"));
        activities.sendKeys("Activities");

        WebElement places = driver.findElement(By.id("places"));
        places.sendKeys("Places");

        WebElement objects = driver.findElement(By.id("objects"));
        objects.sendKeys("Objects");


        WebElement applyButton = driver.findElement(By.id("send"));
        applyButton.click();


    }
}
