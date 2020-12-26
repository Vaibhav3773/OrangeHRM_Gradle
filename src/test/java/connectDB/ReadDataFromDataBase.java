package connectDB;

import java.sql.SQLException;
import java.util.ArrayList;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReadDataFromDataBase extends ConnectDB_Improved {
    ChromeDriver driver;

    @BeforeTest
    public void LaunchApp() throws Exception {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
        // driver.manage().window().maximize();
    }

    @Test
    public void ConnectSQLDB() throws ClassNotFoundException, SQLException, InterruptedException,
            InstantiationException, IllegalAccessException {

        ArrayList<String> sqlData = ConnectMySQLDatabase("jdbc:mysql://localhost:3306/orangehrm", "root", "root");
        System.out.println("SQL Data from DB Example Class : " + sqlData + "\n Array List Size : " + sqlData.size());

        for (String sqlValues : sqlData) {
            System.out.println(sqlValues + " split : 0\t" + sqlValues.split("~")[0]);
            System.out.println(sqlValues + " split : 1\t" + sqlValues.split("~")[1]);
            String uname=sqlValues.split("~")[0];
            String upass=sqlValues.split("~")[1];

            driver.findElementById("txtUsername").clear();
            driver.findElementById("txtUsername").sendKeys(uname);
            driver.findElementById("txtPassword").clear();
            driver.findElementById("txtPassword").sendKeys(upass);
            driver.findElementById("btnLogin").click();
            Thread.sleep(4000);
            driver.findElementById("welcome").click();
            Thread.sleep(3000);
            driver.findElementByLinkText("Logout").click();
            Thread.sleep(3000);
        }

    }

    @AfterTest
    public void CloseApp() throws Exception {

        driver.quit();
    }


}
