package com.haloluxe.base;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseClass {

	public WebDriver driver;
	String url="https://haloluxe.com/";
	
	@BeforeMethod
	public WebDriver OpenBrowser() {
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	  //  driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		return driver;
	}
	
	@AfterMethod
	public void CloseBrowser() {
		driver.close();
	}
}
