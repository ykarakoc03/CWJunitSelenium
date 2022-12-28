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

public class Homework_WebElementScreenshot extends BaseTest {


    //Go to URL: https://opensource-demo.orangehrmlive.com/
    //Getting screenshot of  Orange HRM Page Section.
    //Save the screenshot with format 'screenshotname_yyyy_MM_dd_hh_mm_ss.png'

    @Test
    public void webElementScreenshot() throws IOException {
        //Go to URL: https://opensource-demo.orangehrmlive.com/
        driver.get("https://opensource-demo.orangehrmlive.com/");


        //Getting screenshot of  Orange HRM Page Section.
        WebElement element = driver.findElement(By.className("orangehrm-login-branding"));

        File elemanScreenshot = element.getScreenshotAs(OutputType.FILE);
        File sayfa=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        //Save the screenshot with format 'screenshotname_yyyy_MM_dd_hh_mm_ss.png'
        String date=new SimpleDateFormat("yyyy-MM-dd&hh_mm_ss").format(new Date());

        String path1="test-output\\Screenshots\\homeWork"+date+".png";
        String path2="test-output\\Screenshots\\homeWorkPage"+date+".png";

        FileUtils.copyFile(elemanScreenshot,new File(path1));
        FileUtils.copyFile(sayfa,new File(path2));






    }
}
