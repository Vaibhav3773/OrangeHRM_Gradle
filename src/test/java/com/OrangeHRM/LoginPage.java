package com.OrangeHRM;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class LoginPage {

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
    @Test(priority =1)
    public void loginPage() {
        WebElement userTxtbox= driver.findElementById("txtUsername");
        WebElement passwordTxtbox= driver.findElementById("txtPassword");
        WebElement loginBtn= driver.findElementById("btnLogin");
        userTxtbox.sendKeys("Admin");
        passwordTxtbox.sendKeys("admin123");
        loginBtn.click();
        WebElement dashboardTxt= driver.findElementByXPath("//h1[contains(text(),'Dashboard')]");
        Assert.assertTrue("Dashboard loaded, successful login",dashboardTxt.isDisplayed());
        
    }
    @Test(priority = 2)
    public void verifyUser() {
        String tableUser;
        new Actions(driver);
        WebElement adminOption = driver.findElement(By.xpath("//a[contains(@class,'firstLevelMenu')]"));
        adminOption.click();
        tableUser = driver.findElement(By.xpath("//table/tbody/tr/td/a[contains(text(),"+user+")]")).getText();
        if(user.equals(tableUser)) {
            System.out.println("User exist" + user);
        }
        else {
            System.out.println("User does not exist");
        }
    }
    @Test(priority=4)
    public void logout() {
         driver.findElementById("welcome").click();
         driver.findElementByXPath("//a[text()='Logout']").click();
         driver.findElementById("btnLogin").isDisplayed();
    }
    @Test(priority = 3)
    public void deleteUser() {
       List<WebElement> element = driver.findElements(By.xpath("//table/tbody/tr/td/a[contains(text(),"+user+")]"));
       if(element.isEmpty()) {
           System.out.println("User does not exists");
       }else {
           int value = element.size();
           while(value>0) {
        driver.findElement(By.xpath("//table/tbody/tr/td/a[contains(text(),"+user+")]//preceding::input[1]")).click();
        driver.findElement(By.xpath("//input[@name='btnDelete']")).click();
        driver.findElement(By.xpath("//div[@id='deleteConfModal']//input[@type= 'button' and @value='Ok']")).click();
        value--;
           }
       }
    }

}
