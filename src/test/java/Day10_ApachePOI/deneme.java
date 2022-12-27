package Day10_ApachePOI;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utilities.BaseTest;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class deneme extends BaseTest {




    @Test
    public void login_TestCase_fireFox() throws IOException {

        driver.get("http://www.google.com/");

        File scrFile1 = ((TakesScreenshot)driver)
                .getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile1,
                new File("C:\\Users\\Nutzer\\Desktop\\scrFile1\\deneme.png"));
    }
}