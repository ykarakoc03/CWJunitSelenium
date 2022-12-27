package Day10_ApachePOI;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.webaudio.WebAudio;
import utilities.BaseTest;

public class Homework_UploadFileTask extends BaseTest {

    //Go to URL: https://www.monsterindia.com/seeker/registration
    //Upload file.
    @Test
    public void uploadFile() throws InterruptedException {

        //Go to URL: https://www.monsterindia.com/seeker/registration
        driver.get("https://www.monsterindia.com/seeker/registration");

        //Upload file.
        WebElement element= driver.findElement(By.id("file-upload"));
        element.sendKeys("C:\\Users\\Nutzer\\IdeaProjects\\CWJunitSelenium\\src\\test\\java\\resources\\resume.txt");

        Thread.sleep(5000);

        Assert.assertTrue(driver.findElement(By.id("registrationDetails")).isDisplayed());


    }
}
