package Day7_Iframe_WindowHandles;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.BaseTest;

public class Homework_Task01 extends BaseTest {

/*
Go to URL: https://testproject.io/
Selenium’s 4 newWindow() method to open a new Window for TestProject’s Blog page.
https://blog.testproject.io/
 */


@Test
    public void Test01(){

    //Go to URL: https://testproject.io/
    driver.get("https://testproject.io/");
    //Selenium’s 4 newWindow() method to open a new Window for TestProject’s Blog page.
    String homaPage=driver.getWindowHandle();

    WebElement adress=driver.findElement(By.xpath("//a[@title='Blog']"));

    WebDriver newWindow=driver.switchTo().newWindow(WindowType.WINDOW);
    newWindow.get("https://blog.testproject.io/");




}




}
