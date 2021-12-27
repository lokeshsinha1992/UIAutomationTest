package com.learnautomation.testcases;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.net.MalformedURLException;

public class GridTest {
   public WebDriver driver;
   public String URL, Node;
   protected ThreadLocal<RemoteWebDriver> threadDriver = null;
   
   
   @BeforeTest
   public void launchapp() throws MalformedURLException {
      String URL = "http://www.calculator.net";
      
       
         System.out.println(" Executing on CHROME");
         DesiredCapabilities cap = new DesiredCapabilities();
         cap.setBrowserName("chrome");
         String Node = "http://localhost:4444/wd/hub";
         driver = new RemoteWebDriver(new URL(Node), cap);
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         
         // Launch website
         driver.navigate().to(URL);
         driver.manage().window().maximize();
     
   }
   
   @Test
   public void calculatepercent() {
      // Click on Math Calculators
//      driver.findElement(By.xpath(".//*[@id = 'menu']/div[3]/a")).click();     	
//      
//      // Click on Percent Calculators
//      driver.findElement(By.xpath(".//*[@id = 'menu']/div[4]/div[3]/a")).click();
//      
//      // Enter value 10 in the first number of the percent Calculator
//      driver.findElement(By.id("cpar1")).sendKeys("10");
//      
//      // Enter value 50 in the second number of the percent Calculator
//      driver.findElement(By.id("cpar2")).sendKeys("50");
//      
//      // Click Calculate Button
//      // driver.findElement(By.xpath(".//*[@id = 'content']/table/tbody/tr/td[2]/input")).click();
//      // Get the Result Text based on its xpath
//      String result =
//         driver.findElement(By.xpath(".//*[@id = 'content']/p[2]/span/font/b")).getText();
      
      // Print a Log In message to the screen
      System.out.println(" The Result is " );
      
//      if(result.equals("5")) {
//         System.out.println(" The Result is Pass");
//      } else {
//         System.out.println(" The Result is Fail");
//      }
   }
   
   @AfterTest
   public void closeBrowser() {
     driver.quit();
   }
}