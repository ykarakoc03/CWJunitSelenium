package Day7_Iframe_WindowHandles;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

import java.util.Iterator;
import java.util.Set;

public class Homework_Task02 extends BaseTest {

    @Override
    @After
    public void tearDown() throws InterruptedException {

    }

    @Test
    public void Test01() {

        //Go to URL: https://demoqa.com/browser-windows
        driver.get("https://demoqa.com/browser-windows");
        String homePageId = driver.getWindowHandle();
        //Click on the windows - "WindowButton"
        driver.findElement(By.xpath("//button[@id='windowButton']")).click();
        driver.switchTo().window(homePageId);

        //Click on all the child windows.
        driver.findElement(By.xpath("//button[@id='tabButton']")).click();
        driver.switchTo().window(homePageId);

         driver.findElement(By.xpath("//button[@id='messageWindowButton']")).click();
         driver.switchTo().window(homePageId);

        //Print the text present on all the child windows in the console.
        //Print the heading of the parent window in the console.

        Set<String> page = driver.getWindowHandles();

        Iterator<String> iterator = page.iterator();
        while (iterator.hasNext()) {
            String Pencere = iterator.next();
            if (!Pencere.equals(homePageId)) {
                driver.switchTo().window(Pencere);
                WebElement element = driver.findElement(By.xpath("//*[text()]"));
                System.out.println(element.getText());
            }

        }

    }

}
