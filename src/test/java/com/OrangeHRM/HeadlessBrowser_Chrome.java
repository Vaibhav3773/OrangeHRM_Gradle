package com.OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HeadlessBrowser_Chrome {
    WebDriver driver;
    @Test
    public void Chrome_Headless() {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.setHeadless(false);
        //options.setHeadless(true);
        // options.setHeadless(true);
        options.addArguments("incognito");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
        driver.findElement(By.name("txtUsername")).sendKeys("Admin");
        driver.findElement(By.name("txtPassword")).sendKeys("admin123");
        driver.findElement(By.id("btnLogin")).click();
        
    }

}
