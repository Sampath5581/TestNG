package com.qa.utility;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utility {
public static void screenshotcapture(WebDriver driver,String Screenshotname){
	try{
	TakesScreenshot ts=(TakesScreenshot)driver;
	File source=ts.getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(source,new File("D:\\cafe_cbf\\TestNG\\src\\com\\qa\\utility\\"+Screenshotname+".png"));
	System.out.println("Screenshot Taken");
}
	catch (Exception e)
	{
		System.out.println("Exception while taking screenshot"+e.getMessage());
	}
}
}
