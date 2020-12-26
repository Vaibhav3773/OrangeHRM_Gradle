package com.OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Drag_and_Drop {
    @Test
      public void DragDrop() throws InterruptedException {
           
          WebDriverManager.chromedriver().setup();
          ChromeDriver driver = new ChromeDriver();
          //WebDriver driver = new ChromeDriver();
          // maximize browser
          driver.manage().window().maximize();
          // Open webpage
          driver.get("http://jqueryui.com/resources/demos/droppable/default.html");
          // Add 5 seconds wait
          Thread.sleep(3000);
          // Create object of actions class
          Actions act=new Actions(driver);
          // find element which we need to drag
          //WebElement drag=driver.findElementById("draggable");
          WebElement drag=driver.findElement(By.id("draggable"));
          // find element which we need to drop
          //WebElement drop=driver.findElementById("droppable");
          WebElement drop=driver.findElement(By.id("droppable"));
          // this will drag element to destination
          act.dragAndDrop(drag, drop).build();
          act.perform();
           Thread.sleep(5000);
          driver.quit();
       
          }
  }
