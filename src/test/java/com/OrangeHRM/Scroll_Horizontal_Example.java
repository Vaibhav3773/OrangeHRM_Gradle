package com.OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Scroll_Horizontal_Example {

    ChromeDriver driver;
    @Test
    public void ScrollHorizontally() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\adixit\\workspace\\Selenium_WebDriver_3.9\\chromedriver.exe");
        driver = new ChromeDriver();
        JavascriptExecutor js = driver;

        // Launch the application       
        driver.get("http://demo.guru99.com/test/guru99home/scrolling.html");

        WebElement Element = driver.findElement(By.linkText("VBScript"));
        Thread.sleep(2000);
        //This will scroll the page Horizontally till the element is found      
        js.executeScript("arguments[0].scrollIntoView();", Element);
    }
}