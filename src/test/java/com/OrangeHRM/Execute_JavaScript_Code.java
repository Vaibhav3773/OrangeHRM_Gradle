package com.OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Execute_JavaScript_Code {
    WebDriver driver;

    @Test
    public void Login() throws InterruptedException {
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/auth/login");

        // Creating the JavascriptExecutor interface object by Type casting
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement uname = driver.findElement(By.name("txtUsername"));
        WebElement upass = driver.findElement(By.name("txtPassword"));
        WebElement button = driver.findElement(By.id("btnLogin"));

        // Enter UserName using JavascriptExecutor
        js.executeScript("arguments[0].value='Admin';", uname);
        
        // Enter UserName using JavascriptExecutor
        js.executeScript("arguments[0].value='admin123';", upass);
        Thread.sleep(3000);
        // Perform Click on LOGIN button using JavascriptExecutor
        js.executeScript("arguments[0].click();", button);

        // Verify that Dashboard page displayed
        String ActElement = driver.findElement(By.linkText("Dashboard")).getText();
        String ExpElement = "Dashboard";
        Assert.assertEquals(ActElement, ExpElement);
        System.out.println(ActElement);

        // Method document.title fetch the Title name of the site. Tostring()
        // change object to name
        String TitleName = js.executeScript("return document.title;").toString();
        System.out.println("Title of the page = " + TitleName);

    }

    @BeforeTest
    public void LaunchBrowser() {
        WebDriverManager.chromedriver().setup();
        // WebDriverManager.firefoxdriver().setup();
        // WebDriverManager.edgedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterTest
    public void CloseBrowser() {
        // driver.close();//Close will close only current chrome browser
        driver.quit();
    }
}
