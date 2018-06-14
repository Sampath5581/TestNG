package com.qa.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.utility.Utility;

public class AmazonLogin {
	WebDriver driver;
	@BeforeMethod
	public void setup(String Browsername){
		if(Browsername.equals("chrome")){
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");

		System.out.println(System.getProperty("user.dir"));
		/*	System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"\\chrome.exe"); */
		driver=new ChromeDriver();
		}else if(Browsername.equalsIgnoreCase("firefox")){
			driver=new FirefoxDriver();
		}else if(Browsername.endsWith("IE"));
		{
			/*System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"\\IEDriverServer.exe");*/
			System.setProperty("webdriver.IE,driver","D:\\IEDriverServer.exe");
			
					driver=new InternetExplorerDriver();
			
		}
			}
	@Test
	@Parameters("Browser")
	public void amazon(){
		driver.get("http://www.amazon.in/");
		String s="Online Shopping site in India: Shop Online for Mobiles, Books";
		String ttle=driver.getTitle();
		Assert.assertEquals(ttle,s);
		
	}
	@AfterMethod
public void teardown(ITestResult result){
	if(ITestResult.FAILURE==result.getStatus())
	{
		Utility.screenshotcapture(driver, result.getName());
	}
	driver.quit();
}
}
