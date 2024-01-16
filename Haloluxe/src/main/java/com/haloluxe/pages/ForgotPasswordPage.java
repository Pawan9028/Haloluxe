package com.haloluxe.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ForgotPasswordPage {

	WebDriver driver;
	
	public ForgotPasswordPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//a[@class='secondary-nav__link']")
	WebElement loginButton;
	
	@FindBy(xpath = "//a[@onclick='showRecoverPasswordForm();return false;']")
	WebElement forgotPassButton;
	@FindBy(xpath = "/html/body/div[4]/div[4]/section/div/div[1]/form/p")
	WebElement resetPassMessage;
	
	public boolean verifyForgotPassButtonClickable() throws InterruptedException {
		loginButton.click();
		forgotPassButton.click();
		Thread.sleep(10000);
		Assert.assertEquals(resetPassMessage.getText(), "We will send you an email to reset your password.");
		return true;
	}
}
