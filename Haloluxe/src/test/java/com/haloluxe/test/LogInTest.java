package com.haloluxe.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.haloluxe.base.BaseClass;
import com.haloluxe.pages.LogInPage;

public class LogInTest extends BaseClass{

	LogInPage lp;
	
	@BeforeMethod
	public void loadObject() {
		lp= new LogInPage(driver);
	}
	@Test
	public void VerifyLogInWithValidCredential() throws InterruptedException {
		Assert.assertTrue(lp.VerifyLogInWithValidCredential());
	}
	
	@Test
	public void VerifyLogInWithInvalidCredential() throws InterruptedException {
		Assert.assertTrue(lp.VerifyLogInWithInvalidCredential());
	}
	@Test
	public void VerifyLogInWithInvalidEmailAndValidPass() throws InterruptedException {
		Assert.assertTrue(lp.VerifyLogInWithInvalidEmailAndValidPass());
	}
	@Test
	public void VerifyLogInWithInvalidPassAndValidEmail() throws InterruptedException {
		Assert.assertTrue(lp.VerifyLogInWithInvalidPassAndValidEmail());
	}
	@Test
	public void VerifyLogInWithoutProvidingAnyCredential() throws InterruptedException  {
		Assert.assertTrue(lp.VerifyLogInWithoutProvidingAnyCredential() );
	}
}
