package com.haloluxe.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.haloluxe.base.BaseClass;
import com.haloluxe.pages.LogoutPage;

public class LogoutTest extends BaseClass{

	LogoutPage lop;
	
	@BeforeMethod
	public void loadObject() {
	lop = new LogoutPage(driver);
	
	}
	@Test
	public void VerifyLogoutButton() {
		Assert.assertTrue(lop.VerifyLogoutButton());
	}
	@Test
	public void VerifyLoggingOutAndLogInImmediatelyAfterLogout() {
		Assert.assertTrue(lop.verifyLoggingOutAndLogInImmediatelyAfterLogOut());
		
	}
}
