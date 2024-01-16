package com.haloluxe.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.haloluxe.base.BaseClass;
import com.haloluxe.pages.ForgotPasswordPage;

public class ForgotPassTest extends BaseClass{

	ForgotPasswordPage fp;
	
	@BeforeMethod
	public void loadObject() {
		fp=new ForgotPasswordPage(driver);
		
	}
	@Test
	public void verifyForgotPassButtonClickable() throws InterruptedException {
		Assert.assertTrue(fp.verifyForgotPassButtonClickable());
	}
}
