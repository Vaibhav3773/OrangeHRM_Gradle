package readDataFromExcel;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class OrangeHRM_LoginWithExcelData {

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

    
    @Test(dataProvider = "LoginExcelData")
    public void Sign_On(String uname, String upass) throws InterruptedException

    {

        driver.findElement(By.name("txtUsername")).sendKeys(uname);
        driver.findElement(By.name("txtPassword")).sendKeys(upass);
        driver.findElement(By.id("btnLogin")).click();
        // ----------------To Verify Logout Function without using
        driver.findElement(By.id("welcome")).click();
        Thread.sleep(5000);
        driver.findElement(By.linkText("Logout")).click();
        driver.findElement(By.id("logInPanelHeading")).isDisplayed();
    }

 
       

}

