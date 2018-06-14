package com.qa.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGbasics {

/*	setup system Property for Chrome
	Launch Chrome Browser
	Login to app
	enter URL
	Google Title Test
	logout to app
	close Browser
	deleteAll Cookies
	PASSED: googleTitleTest*/
	
//Pre-condition annotations which starts with @Before	
	@BeforeSuite //1
	public void setup(){
		System.out.println("setup system Property for Chrome");
	}
	
	@BeforeTest //2
	public void launchBrowser(){
		System.out.println("Launch Chrome Browsr");
		}
	
	@BeforeClass //3
	public void login(){
		System.out.println("Login to app");
	}
	
	@BeforeMethod //4
	public void enterURL(){
		System.out.println("enter URL");
	}
	
		//Test annotations which are starts with @test
	@Test //5
	public void googleTitleTest(){
		System.out.println("Google Title Test");
	}
	
	@Test 
	public void search(){
		System.out.println("Search test");
	}
	
	@AfterMethod //6
	public void logout(){
		System.out.println("logout to app");
	}
	
	@AfterClass //7
	public void closeBrowser(){
		System.out.println("close Browser");
	}
	
	@AfterTest //8
	public void deleteAllCookies(){
		System.out.println("deleteAll Cookies");
	}


	@AfterSuite //9
	public void generatetestreport(){
		System.out.println("generate test report");
	}
	
	
	
	
	
}
