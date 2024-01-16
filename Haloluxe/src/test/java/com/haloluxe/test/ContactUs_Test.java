package com.haloluxe.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.haloluxe.base.BaseClass;
import com.haloluxe.pages.ContactUsPage;

public class ContactUs_Test extends BaseClass{
	
	ContactUsPage cup;
	@BeforeMethod
	public void loadObject() {
		cup=new ContactUsPage(driver);
	}
	@Test
	public void VerifyContactUsButtonOnHomePage() {
		Assert.assertTrue(cup.VerifyContactUsbuttonOnHomPage());
	}
	@Test
	public void verifyContactUsOnAccountPage() {
		Assert.assertTrue(cup.VerifyContactUsButtonOnAccountPage());
	}
	@Test
	public void verifyContactUsFormBySubmittingAllTheDetails() throws InterruptedException {
		Assert.assertTrue(cup.VerifyContactUsFormBySubmittingAllDetails());
	}
	@Test
	public void VerifyContactUsFormByNotSubmittingAnyDetails() {
		Assert.assertTrue(cup.VerifyContactUsFormByNotSubmittingAnyDetails());
	}
	@Test
	public void VerifyEnteringInvalidEmailIntoContactUsForm() {
		Assert.assertTrue(cup.VerifyEnteringInvalidEmailIntoContactUsForm());
	}
	
}
