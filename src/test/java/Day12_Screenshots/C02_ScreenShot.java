package Day12_Screenshots;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C02_ScreenShot extends BaseTest {


    @Test
    public void getPageScreenshot() throws IOException {
        driver.get("https://www.n11.com/");

        File kaynak= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        //test-output-> Screenshot -> screenshot
        FileUtils.copyFile(kaynak, new File("test-output\\Screenshots\\n11Screenshot.png"));


    }


    @Test
    public void getElementScreenshot() throws IOException {
       // Go to URL: https://opensource-demo.orangehrmlive.com/
       // Saving the image to  the path.
       // Getting screenshot of Orange HRM Logo.
       // Getting screenshot of  Orange HRM Page Section
        driver.get("https://opensource-demo.orangehrmlive.com/");


        // Screenshot alınacak elementimizi locate ettik
        WebElement logo = driver.findElement(By.className("orangehrm-login-branding"));

        //element üzerinde Screenshot aldık
        File logoScreenshot = logo.getScreenshotAs(OutputType.FILE);

        //screenshot her çalıştığında üzerine yazmasın diye unıq deger olması için gün saat ekledik
        //dateyi formatladık
        String date =new SimpleDateFormat("yyyy-MM-dd&hh_mm_ss").format(new Date());

        //Uniq isimli oath oluşturduk
        String path ="test-output\\Screenshots\\logoScreenshot"+date+".png";

        //Dosyamızı kaydettik
        FileUtils.copyFile(logoScreenshot,new File(path));



    }
}
