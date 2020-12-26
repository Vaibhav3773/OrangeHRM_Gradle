package com.OrangeHRM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Mouse_Hover_Yatra_Com {
    @Test
    public void MouseHoverYatra() throws InterruptedException
    {
        WebDriverManager.chromedriver().setup();
        // create Edge instance and maximize it
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get( "https://www.flipkart.com/");
        driver.findElementByXPath("/html/body/div[2]/div/div/button").click();
        /*WebElement MyAccount = driver.findElementByXPath("//a[contains(text(),'My Account')]");
        Actions action = new Actions(driver);
        action.moveToElement(MyAccount).build().perform();*/
        Thread.sleep(6000);
        WebElement MyAccount = driver.findElementByXPath("//span[contains(text(),'Electronics')]");
        Actions action = new Actions(driver);
        action.moveToElement(MyAccount).build().perform();
        //driver.findElementById("signInBtn").click();
        Thread.sleep(6000);
        driver.findElementByXPath("//a[@title='Samsung']").click();


    }
}
