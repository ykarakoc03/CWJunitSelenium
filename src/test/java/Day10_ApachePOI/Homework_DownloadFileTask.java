package Day10_ApachePOI;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

public class Homework_DownloadFileTask extends BaseTest {

    // Go to https://the-internet.herokuapp.com/download
//  Download sample.png file
//  Then verify if the file downloaded successfully
    @Test
    public void downloadFile() throws InterruptedException {
        // Go to https://the-internet.herokuapp.com/download
        driver.get("https://the-internet.herokuapp.com/download");


//  Download sample.png file
        WebElement element=driver.findElement(By.xpath("//a[contains(text(),'sample.png')]"));
        element.click();

        Thread.sleep(5000);

//  Then verify if the file downloaded successfully
        Assert.assertTrue(Files.exists(Path.of("C:\\Users\\Nutzer\\Downloads\\sample.png")));

    }
}
