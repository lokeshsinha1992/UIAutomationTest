package com.learnautomation.docker;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;


import com.learnautomation.docker.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class DockerTest extends TestBase {
	
	
	@Test	(dataProvider = "getBrowserName")
public void testDockerGrid(String browserName) throws InterruptedException, MalformedURLException {
	
//	WebDriverManager.chromedriver().setup();
	// WebDriver driver = new ChromeDriver();
	
	// Download crome standalone image in docker and give below command in powershell 
	
	
	// docker run -p 4444:4444 -p 7900:7900 selenium/standalone-chrome:108.0
	
	// Where 108.0 is version for chrome
		
		
		
		
	
	DesiredCapabilities capabilities = new DesiredCapabilities();
	
	capabilities.setBrowserName(browserName);
	

	WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
	
	
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	driver.get(url);
	System.out.println("Title: " + driver.getTitle());
	
	WebElement searchBox = driver.findElement(By.name("q"));

	searchBox.sendKeys("Full Stack Test Automation Engineer");
	searchBox.sendKeys(Keys.ENTER);

	
	Thread.sleep(5000);
	driver.quit();
	
	
}
	
	@DataProvider(parallel = true)
	public Object[][] getBrowserName(){
		
		return new Object[][] 
				{{"chrome"},{"firefox"}, {"chrome"}, {"firefox"}};
		
	}


	

}
