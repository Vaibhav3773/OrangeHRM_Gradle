package com.OrangeHRM;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Execute_JavaScript_CaptureScrapeData {
    WebDriver driver;

    @Test
    public void GetURL_Domain_Title() throws InterruptedException {

        //Creating the JavascriptExecutor interface object by Type casting      
        JavascriptExecutor js = (JavascriptExecutor)driver;     
                
        //Launching the Site.       
        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
            
        //Fetching the Domain Name of the site. Tostring() change object to name.       
        String DomainName = js.executeScript("return document.domain;").toString();         
        System.out.println("Domain name of the site = "+DomainName);                    
                
        //Fetching the URL of the site. Tostring() change object to name        
        String url = js.executeScript("return document.URL;").toString();           
        System.out.println("URL of the site = "+url);                   
                
       //Method document.title fetch the Title name of the site. Tostring() change object to name       
       String TitleName = js.executeScript("return document.title;").toString();            
       System.out.println("Title of the page = "+TitleName);                    

                
      //Navigate to new Page i.e to generate access page. (launch new url)      
      js.executeScript("window.location = 'https://opensource-demo.orangehrmlive.com/index.php/auth/requestPasswordResetCode'");    
      Thread.sleep(4000);
      //Fetching the URL of the site. Tostring() change object to name      
      String newurl = js.executeScript("return document.URL;").toString();          
      System.out.println("URL of the site = "+newurl);
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