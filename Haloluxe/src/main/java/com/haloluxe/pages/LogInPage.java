package com.haloluxe.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.haloluxe.utils.UtilityClass;

public class LogInPage extends UtilityClass{

	WebDriver driver;
	
	 public LogInPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
		logInButton.click();
	}
	 @FindBy(xpath = "//a[@class='secondary-nav__link']")
	public WebElement logInButton;
	 
	 @FindBy(xpath = "//input[@id='CustomerEmail']")
	 WebElement enterEmail;
	 @FindBy(xpath = "//input[@id='CustomerPassword']")
	 WebElement enterPass;
	 @FindBy(xpath = "//input[@value='Sign In']")
	 WebElement signInButton;
	 @FindBy(xpath = "//*[text()='Incorrect email or password.']")
	 WebElement errorMessage_emai_pass;
	 
	 @FindBy(xpath =  "//*[@class='icon icon--close']") 
	 WebElement popup;
	 
	 public boolean VerifyLogInWithValidCredential() throws InterruptedException {
		 close_popup(popup);
		 eraseAndType(enterEmail, "pavan@aristasystems.in");
		 eraseAndType(enterPass, "Pawan@12345");
		// enterEmail.sendKeys("pavan@aristasystems.in");
		// enterPass.sendKeys("Pawan@12345");
		 signInButton.click();
		Assert.assertEquals(driver.getTitle(), "Challenge – Halo Luxe");
		return true;
	 }
	 
	 public boolean VerifyLogInWithInvalidCredential() throws InterruptedException {
		 close_popup(popup);
		 eraseAndType(enterEmail, "pawan@aristasystems.in");
		 eraseAndType(enterPass, "saWan@33");
		 signInButton.click();
		 System.out.println(errorMessage_emai_pass.getText());
		 Assert.assertEquals(errorMessage_emai_pass.getText(), "Incorrect email or password.");
		 return true;
	 }
	 public boolean VerifyLogInWithInvalidEmailAndValidPass() throws InterruptedException {
		 close_popup(popup);
		 eraseAndType(enterEmail, "pawan@aristasystems.in");
		 eraseAndType(enterPass, "Pawan@12345");
		 signInButton.click();
		 System.out.println(errorMessage_emai_pass.getText());
		 Assert.assertEquals(errorMessage_emai_pass.getText(), "Incorrect email or password.");
		 return true;
	 }
	 public boolean VerifyLogInWithInvalidPassAndValidEmail() throws InterruptedException {
		 close_popup(popup);
		 eraseAndType(enterEmail, "pavan@aristasystems.in");
		 eraseAndType(enterPass, "saWan@33");
		 signInButton.click();
		 System.out.println(errorMessage_emai_pass.getText());
		 Assert.assertEquals(errorMessage_emai_pass.getText(), "Incorrect email or password.");
		 return true;
	 }
	 public boolean VerifyLogInWithoutProvidingAnyCredential() throws InterruptedException {
		 close_popup(popup);
		 eraseAndType(enterEmail, "");
		 eraseAndType(enterPass, "");
		 signInButton.click();
		 System.out.println(errorMessage_emai_pass.getText());
		 Assert.assertEquals(errorMessage_emai_pass.getText(), "Incorrect email or password.");
		 return true;
	 }
	 public void VerifyForgotPasswordButtonClickable() {
		 
	 }
}
