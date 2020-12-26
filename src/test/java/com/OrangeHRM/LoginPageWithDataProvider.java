package com.OrangeHRM;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class LoginPageWithDataProvider extends OrangeHRM_TestData{

    ChromeDriver driver;
    final static String user = "Vaibhav";
    
    
    @BeforeTest
    public void launchBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    
    @AfterTest
    public void exitBrowser() {
        driver.quit();
    }
    @Test(dataProvider="Login")
    
    public void loginPage(String url, String user, String pass) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement userTxtbox= driver.findElementById("txtUsername");
        WebElement passwordTxtbox= driver.findElementById("txtPassword");
        WebElement loginBtn= driver.findElementById("btnLogin");
        userTxtbox.sendKeys(user);
        passwordTxtbox.sendKeys(pass);
        loginBtn.click();
        WebElement dashboardTxt= driver.findElementByXPath("//h1[contains(text(),'Dashboard')]");
        Assert.assertTrue("Dashboard loaded, successful login",dashboardTxt.isDisplayed());
        
    }
    
  //  @Test(dataProvider = "LoginData")
    public void Sign_On(String uname, String password) throws InterruptedException

    {

        driver.findElement(By.name("txtUsername")).sendKeys(uname);
        driver.findElement(By.name("txtPassword")).sendKeys(password);
        driver.findElement(By.id("btnLogin")).click();
        // ----------------To Verify Logout Function without using
        driver.findElement(By.id("welcome")).click();
        Thread.sleep(5000);
        driver.findElement(By.linkText("Logout")).click();
        driver.findElement(By.id("logInPanelHeading")).isDisplayed();
    }

 
       

}
