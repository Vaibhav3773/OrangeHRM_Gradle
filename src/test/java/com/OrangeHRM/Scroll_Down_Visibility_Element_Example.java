package com.OrangeHRM;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Scroll_Down_Visibility_Element_Example {

    ChromeDriver driver;
    @Test
    public void ByVisibleElement() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\adixit\\workspace\\Selenium_WebDriver_3.9\\chromedriver.exe");
        driver = new ChromeDriver();
      JavascriptExecutor js = driver;

        driver.get( "https://www.shutterfly.com/");
        Thread.sleep(6000);
        driver.findElementByClassName("overlay-modal-close").click();
        //driver.findElementByLinkText("Order Status").click();
        //Thread.sleep(6000);
        WebElement Element = driver.findElementByLinkText("Order Status");
        //This will scroll the page till the element is found       
         js.executeScript("arguments[0].scrollIntoView();", Element);
         Thread.sleep(2000);
         Element.click();
    }
}