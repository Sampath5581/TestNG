package com.parameters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTest {
	WebDriver driver;
	
	@Test
	@Parameters({"Browser","url","username","password"})
	public void AmazonTest(String Browser,String url,String username,String password) throws InterruptedException{
		if(Browser.equals("chrome")){
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
		driver=new ChromeDriver();
		} 
		else if(Browser.equals("firefox")){
		System.setProperty("webdriver.gecko.driver","D:\\geckodriver.exe");
		driver=new FirefoxDriver();
		}
		else if(Browser.equals("IE")){
			DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
			cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		System.setProperty("webdriver.ie.driver","D:\\IEDriverServer.exe");
		driver=new InternetExplorerDriver(cap);
		}
	
		driver.get(url);
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.findElement(By.xpath("(//span[@class='nav-line-2'])[3]")).click();
		driver.findElement(By.xpath("//input[(@type='email') and (@id='ap_email')]")).clear();
		driver.findElement(By.xpath("//input[(@type='email') and (@id='ap_email')]")).sendKeys(username);
		Thread.sleep(2000);
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("ap_password")).sendKeys(password);
		driver.close();
		
	}

}
