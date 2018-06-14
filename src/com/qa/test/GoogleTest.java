package com.qa.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.utility.Utility;

public class GoogleTest {
static WebDriver driver;

@BeforeMethod
public void Setup(){
	//System.getProperty("user.dir").concat("geckodriver.exe");
	driver=new FirefoxDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	driver.get("http://google.com");
}

@Test(priority=3)
public void googleTitleTest(){
	String title=driver.getTitle();
	System.out.println(title);
}

@Test
public void logotest(){
	boolean logo=driver.findElement(By.id("hplogo")).isDisplayed();
}

@Test(priority=2)
public void maillinkTest(){
	boolean maillink=driver.findElement(By.linkText("Gmail1")).isEnabled();
}

@AfterMethod
public void teardown(ITestResult result)
{
	if(ITestResult.FAILURE==result.getStatus())
	{
		Utility.screenshotcapture(driver, result.getName());
	}
	driver.quit();
}

}
