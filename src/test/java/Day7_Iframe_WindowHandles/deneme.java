package Day7_Iframe_WindowHandles;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

import java.util.ArrayList;
import java.util.List;

public class deneme extends BaseTest {

    @Override
    public void tearDown() throws InterruptedException {

    }

    @Test
    public void Test(){
    driver.get("https://demoqa.com/browser-windows");
    String homePageID = driver.getWindowHandle();
    WebElement windowsBox = driver.findElement(By.cssSelector(".btn.btn-light.active#item-0"));
        windowsBox.click();
    List<WebElement> boxList = driver.findElements(By.cssSelector("#browserWindows button"));
        for (int i = 0; i<boxList.size();i++){
        boxList.get(i).click();
        ArrayList<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowHandles.get(windowHandles.size()-1));
        if(driver.getPageSource()!=null) {
            WebElement message = driver.findElement(By.tagName("body"));
            System.out.println("message.getText() = " + message.getText());
        }
        driver.switchTo().window(homePageID);
    }
        System.out.println("driver.getTitle() = " + driver.getTitle());
        driver.quit();


}


















}
