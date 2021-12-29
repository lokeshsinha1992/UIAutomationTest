package com.learnautomation.testcases;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class BrowserStackTest 
{
	
	
	@Test
	public void test1() throws MalformedURLException, InterruptedException
	{
		
		 	DesiredCapabilities caps = new DesiredCapabilities();
		 	
		    caps.setCapability("browserName", "chrome");
		    
		    caps.setCapability("os", "Windows");
		    
		    caps.setCapability("os_version", "10");
		    
		   
		    
		    caps.setCapability("name", "Bstack-[Java] Selenium Test");
		    
		    final String USERNAME = "lokeshsinha_bGyzeF";
			final String AUTOMATE_KEY = "M7AgY9FbNBx7nLfRj5Up";
			final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
			
		    
		    WebDriver driver=new RemoteWebDriver(new URL(URL), caps);
		    
		    driver.get("http://www.google.com");
		    
		    WebElement element = driver.findElement(By.name("q"));

		    element.sendKeys("Mukesh Otwani");
		    
		    Thread.sleep(5000);
		    
		    element.submit();

		    System.out.println(driver.getTitle());
		    
		    driver.quit();
	}

}
