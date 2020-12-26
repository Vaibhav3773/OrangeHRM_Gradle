package com.OrangeHRM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Double_Click_Example {
    @Test
    public void DragDrop() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        // maximize browser
        driver.manage().window().maximize();
        // Open webpage
        driver.get("https://www.testandquiz.com/selenium/testing.html");
        
        WebElement DoubleClick = driver.findElementById("dblClkBtn");
        Actions action = new Actions(driver);
        action.doubleClick(DoubleClick).perform();

        String ActText = driver.switchTo().alert().getText();
        String ExpText = "hi, JavaTpoint Testing";
        Assert.assertEquals(ActText, ExpText);
        System.out.println(ActText);
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        //int value="5";
        

    }
}

