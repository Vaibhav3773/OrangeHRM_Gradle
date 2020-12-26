package com.OrangeHRM;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Execute_JavaScript_executeAsyncScript {
    WebDriver driver;

    @Test
    public void Login() throws InterruptedException {
        
        //Creating the JavascriptExecutor interface object by Type casting      
        JavascriptExecutor js = (JavascriptExecutor)driver; 
        
        //Launching the Site.       
        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");           
     
          //Maximize window     
          driver.manage().window().maximize();      
             
          //Declare and set the start time      
          long start_time = System.currentTimeMillis();         
                   
          //Call executeAsyncScript() method to wait for 5 seconds      
          js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 5000);");           
                
         //Get the difference (currentTime - startTime)  of times.      
         System.out.println("Passed time: " + (System.currentTimeMillis() - start_time));
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
