package com.OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class Element_Focused_Or_Not {
@Test(priority=1)
    public void Google_Search_Focus() {
        
    System.setProperty("webdriver.chrome.driver","D:\\F Drive\\Selenium Training Data\\workspace\\Allianz_UI_Testing\\chromedriver.exe");
    ChromeDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
        driver.navigate().to("https://www.google.co.in/");
        
        WebElement element = driver.findElement(By.name("q"));
        // Verify Search box is focused or not
        element.equals(driver.switchTo().activeElement());
        driver.quit();
    }

@Test
public void Login_Edit_Focus() {
    
    System.setProperty("webdriver.chrome.driver","D:\\F Drive\\Selenium Training Data\\workspace\\Allianz_UI_Testing\\chromedriver.exe");
    ChromeDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
      driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
    WebElement element=driver.findElement(By.name("txtUsername"));
    element.equals(driver.switchTo().activeElement());
    driver.quit();
}
}

