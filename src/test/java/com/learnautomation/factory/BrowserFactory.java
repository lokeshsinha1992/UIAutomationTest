package com.learnautomation.factory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.gargoylesoftware.htmlunit.BrowserVersion;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {
	
	// create method with Platform name,version Browser name,version
	
	// create method with MobileDevice name,version Browser name,version
	
	
//	public static WebDriver startBrowserOnHub(String platformType,String browserType,String urlToAutomate)
//	{
//		
//		System.out.println("****LOG:INFO-Starting browser session****");
//		WebDriver driver=null;
//		
//		DesiredCapabilities cap=new DesiredCapabilities();
//		
//		if(platformType.contains("Windows"))
//		{
//			cap.setPlatform(Platform.WINDOWS);
//		}
//		else if(platformType.contains("Linux"))
//		{
//			cap.setPlatform(Platform.LINUX);
//		}
//		else {
//			cap.setPlatform(Platform.MAC);
//		}
//		
//		if(browserType.equalsIgnoreCase("Chrome"))
//		{
//			cap.setBrowserName(BrowserType.CHROME);
//		}
//		else if(browserType.equalsIgnoreCase("Firefox"))
//		{
//			cap.setBrowserName(BrowserType.FIREFOX);
//
//		}
//		else if(browserType.equalsIgnoreCase("IE"))
//		{
//			cap.setBrowserName(BrowserType.IE);
//
//		}
//		
//		try {
//			driver=new RemoteWebDriver(new URL("http://172.18.0.2:4444"),cap);
//		} catch (MalformedURLException e) 
//		{
//			System.out.println("LOG:ERROR -hub is not reachable" +e.getMessage());
//		}
//		
//		driver.manage().window().maximize();
//		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
//		driver.get(urlToAutomate);
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		System.out.println("****LOG:INFO-Browser session is up and Running****");
//		
//		return driver;
//		
//	}
//	
	
	
	public static WebDriver startBrowser(String browserType,String urlToAutomate) throws MalformedURLException
	{
		
		System.out.println("****LOG:INFO-Starting browser session****");
		WebDriver driver=null;
		
		if(browserType.equalsIgnoreCase("Chrome"))
		{
			
			
			
         DesiredCapabilities caps = new DesiredCapabilities();
		 	
		    caps.setCapability("browserName", "chrome");
		    
		    caps.setCapability("os", "Windows");
		    
		    caps.setCapability("os_version", "10");
		    
		   
		    
		    caps.setCapability("name", "Bstack-[Java] Selenium Test");
		    
		    final String USERNAME = "lokeshsinha_bGyzeF";
			final String AUTOMATE_KEY = "M7AgY9FbNBx7nLfRj5Up";
			final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
			
		    
		     driver=new RemoteWebDriver(new URL(URL), caps);
			
////			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/BrowserDrivers/chromedriver.exe");
//			ChromeOptions chromeOptions = new ChromeOptions();
//			chromeOptions.addArguments("headless");
//			WebDriverManager.chromedriver().setup();
//			driver=new ChromeDriver(chromeOptions);	
//			
			
			
			
			
			
	//	 driver=new HtmlUnitDriver(BrowserVersion.CHROME);

			
		}
		else if(browserType.equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\USER\\Desktop\\April2020\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(browserType.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver", "C:\\Users\\USER\\Desktop\\April2020\\IEDriverServer_32.exe");
			driver=new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get(urlToAutomate);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("****LOG:INFO-Browser session is up and Running****");
		
		return driver;
		
	}
	
	public static void closeBrowser(WebDriver driver)
	{
		driver.quit();
		System.out.println("****LOG:INFO-Browser session terminated****");
	}

}
