package Day9_JSEScroll_Cookies_Files;

import com.beust.ah.A;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

import java.util.List;

public class C10_FileUpload extends BaseTest {

/*
Go to URL: https://the-internet.herokuapp.com/upload
Find the path of the file that you want to upload.
Click on Upload button.
Verify the upload message.
 */
    @Test
    public void fileUpload() {



driver.get("https://the-internet.herokuapp.com/upload");

        WebElement dosyaSec= driver.findElement(By.id("file-upload"));

        //masaüstündeki bir dosyanın path verdik
        //dosya sece normalde biz tıklasakda sendKys zaten foculama yapın aktif hale getirdigi içib
        //clıck yapmadık
        dosyaSec.sendKeys("C:\\Users\\Nutzer\\Desktop\\fileExist.png");

        WebElement uploadFile = driver.findElement(By.id("file-submit"));
        uploadFile.click();

        //yüklendiğine dair mesajn er aldıgı locate
            WebElement message = driver.findElement(By.tagName("h3"));

        Assert.assertTrue(message.isDisplayed());

        //expected= beklenen, actual=olan,mevcut
        Assert.assertEquals("File Uploaded!",message.getText());


        //     **** önemli Trick    ****
        //locate no such hatalarını handle edebilmek için locate bölümü liste şeklinde aranır.
        //bu şekilde birşey bulamazsa hata vermez boş liste döndürür.
        //try-catch gerek kalmadan listenin boş durumuna göre istenen aktivite yapılabilir
        // eleman bulunamadı  nedeni ile code kırılmaz
        List<WebElement> bulunamayanLocateHataAlmama=driver.findElements(By.tagName("h8"));
        Assert.assertTrue("Element bulunamdı", !bulunamayanLocateHataAlmama.isEmpty());
        Assert.assertTrue(bulunamayanLocateHataAlmama.get(0).isDisplayed());





    }
}
