package Day9_JSEScroll_Cookies_Files;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.BaseTest;

public class C2_ScrolWithJSExecutor extends BaseTest {

  /*
            executeScript("window.scrollBy(x-piksel,y-piksel)");  ya da js.executeScript("scroll(x,y);");
            x-piksel x eksenindeki sayıdır, sayı pozitifse sola, sayı negatifse saga hareket eder.
            y-piksel y eksenindeki sayıdır, sayı pozitifse ise aşağı doğru,sayı negatif ise yukarı doğru hareket eder.
            js.executeScript("window.scrollBy(0,1000)"); // Dikey olarak 1000 piksel asagi kaydır
            js.executeScript("window.scrollTo(0, 0)");  // en asagiya gider
            js.executeScript("window.scrollTo(0, document.body.scrollHeight)"); // en asagiya gider
                // scrollTo : Verilen pixele gider.
                // scrollBy : Verilen kadar daha ileri gider.
           scrollIntoView () web sayfasindaki bir ogenin gorunurlulugune gore kaydirir
           js.executeScript("arguments[0].scrollIntoView();"  , webelement);
 */


    @Test
    public void scrollWithJSExecuter(){

        //go to url : https://api.jquery.com/dblclick/
        driver.get("https://api.jquery.com/dblclick/");

        //double click on the blue square at the bottom of the page and then write the changed color.

        //sayfada 1 tane iframe vardı onun için indeks 0 olara verdik ve iframe içine girdik
        driver.switchTo().frame(0);


        //span[text()='Double click the block'] bu locate tıklamadı.
        // cssSelector ile body>div şeklinde aldık ve kabul etti
        //iframe icine girdikten sonra bir tane vardı bu locate den
        WebElement blueBox = driver.findElement(By.cssSelector("body>div"));

        //driver i javascript Ex. hizmetine verdik. yazarken kırmızı cizdi.
        //düzenle diyince cast yaptı. (JavascriptExecutor) driver;
        JavascriptExecutor jse=(JavascriptExecutor) driver;

        //hedef bir web elemente yönlendirdik, oraya kadar sayfada indi
        jse.executeScript("arguments[0].scrollIntoView();",blueBox);


        //background_color rengini aldık
        System.out.println("colour before :" + blueBox.getCssValue("background-color"));//colour before :rgba(0, 0, 255, 1)
        Actions actions = new Actions(driver);
        actions.doubleClick(blueBox).perform();
        System.out.println("colour after :" + blueBox.getCssValue("background-color"));//colour after :rgba(255, 255, 0, 1)
    }



}
