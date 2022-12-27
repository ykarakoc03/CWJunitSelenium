package Day9_JSEScroll_Cookies_Files;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C7_FileExist {

    public static void main(String[] args) {


        System.out.println(System.getProperty("user.dir"));//projemizin roorunun yolunu verir

        //Bulmak istedigimiz file proje içersinde oldugu için projeye kadar olan yolu verir
        String projectRoot =System.getProperty("user.dir");

        //// Bulmak istedigimiz dosyanin proje klasorunden sonraki yolunu aldik (Copy path from content root)
        String filePath="\\src\\test\\java\\resources\\fileExist.jpg";

        //birleştirerel absolut path buluyoruz
        filePath= projectRoot+filePath;


        System.out.println(Files.exists(Paths.get(filePath)));

        //dosyanın var olup olmadıgını kontrol ediyoruz
        if (Files.exists(Paths.get(filePath))){
            System.out.println("Dosya bulundu");
        }else {
            System.out.println("Dosya bulunamadı");
        }
    }



}
