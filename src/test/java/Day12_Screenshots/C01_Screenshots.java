package Day12_Screenshots;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utilities.BaseTest;

import java.io.File;
import java.io.IOException;

public class C01_Screenshots {


    @Test
    public void fullPageScreenshot() throws IOException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver =new FirefoxDriver();


        driver.get("https://www.amazon.com.tr/");
        File source=((FirefoxDriver)driver).getFullPageScreenshotAs(OutputType.FILE);

        //test-output-> Screenshot -> screenshot
        FileUtils.copyFile(source, new File("test-output\\Screenshots\\amaconFullScreenshot.png"));

    }
}
