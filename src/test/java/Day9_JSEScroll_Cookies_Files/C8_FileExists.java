package Day9_JSEScroll_Cookies_Files;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;

public class C8_FileExists {

    @Test
    public void fileExists() {

        //masaüstündeki dosya
        //C:\Users\Nutzer\Desktop\fileExist.png

        System.out.println(System.getProperty("user.home"));//C:\Users\Nutzer

        String homePath = System.getProperty("user.home");//home yolunu atadım

        String filePath= "\\Desktop\\fileExist.png";//dosyanın kalan yolunu atadık

        String fullPath = homePath+filePath;//path leri birleştirip fullpath elde ettik

        File image = new File(fullPath);//Path imizi file çevirdik

        Assert.assertTrue(image.exists());//kontol ettik


    }
}
