package Day7_Iframe_WindowHandles;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

import java.util.List;

public class Homework_Iframe extends BaseTest {

/*
Go to URL: http://demo.guru99.com/test/guru99home/
Find the number of iframes on the page.


 */
@Override
@After
public void tearDown() throws InterruptedException {

}

@Test
    public void Test01(){
driver.get("http://demo.guru99.com/test/guru99home/");

//Find the number of iframes on the page.
    List<WebElement> iframeSize=driver.findElements(By.xpath("//iframe"));
    System.out.println(iframeSize.size());
    String homePageId=driver.getWindowHandle();
    driver.switchTo().frame("a077aa5e");

    //Link to the fourth iframe (JMeter Made Easy) (https://www.guru99.com/live selenium project.html) click here.
    driver.findElement(By.tagName("a")).click();
    //Alternatif:
   //driver.findElement(By.xpath("//img[@src='Jmeter720.png']")).click();

    // Exit the iframe and return to the main page.
    driver.switchTo().defaultContent();
    driver.switchTo().window(homePageId);

}




}
