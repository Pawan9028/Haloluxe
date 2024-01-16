package com.haloluxe.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.haloluxe.utils.UtilityClass;

public class LogoutPage extends UtilityClass{

	WebDriver driver;
	
	public LogoutPage(WebDriver driver){
		this.driver= driver;
		PageFactory.initElements(driver, this);
		//logInButton.click();
		// eraseAndType(enterEmail, "pavan@aristasystems.in");
		// eraseAndType(enterPass, "Pawan@12345");
		 //signInButton.click();
		 
		 driver.get("https://haloluxe.com/account?analytics_trace_id=03321002-4f8d-414a-aa5d-881d2f043931");
		
	}
	
	 @FindBy(xpath = "//a[@class='secondary-nav__link']")
		public WebElement logInButton;
	 @FindBy(xpath = "//input[@id='CustomerEmail']")
	 WebElement enterEmail;
	 @FindBy(xpath = "//input[@id='CustomerPassword']")
	 WebElement enterPass;
	 @FindBy(xpath = "//input[@value='Sign In']")
	 WebElement signInButton;
	 
	 @FindBy(xpath = "//*[@class='link']")
	 WebElement logoutButton;
	 
	 @FindBy(xpath = "//*[@aria-controls='account-links-header']")
	 WebElement accountTab;
	 
	
	 public boolean VerifyLogoutButton() {
		// logoutButton.click();
		 Assert.assertEquals(driver.getTitle(), "Account – Halo Luxe");
		 return true;
	 }
	 public boolean verifyLoggingOutAndLogInImmediatelyAfterLogOut() {
		 driver.get("https://haloluxe.com/account?analytics_trace_id=03321002-4f8d-414a-aa5d-881d2f043931");
		 Assert.assertEquals(driver.getTitle(), "Account – Halo Luxe");
		 return true;
	 }
	 
}
