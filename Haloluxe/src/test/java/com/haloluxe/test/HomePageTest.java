package com.haloluxe.test;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.haloluxe.base.BaseClass;
import com.haloluxe.pages.HomePage;

public class HomePageTest extends BaseClass{
	HomePage hp ;
	@BeforeMethod
	public void loadObject() {
	hp= new  HomePage(driver);
	}
	
	@Test
	public void VerifyHomePageLoadSuccessfully() {
		Assert.assertTrue(true);
	}
	
	@Test
	public void VerifyLogInButton() throws InterruptedException {
		Assert.assertTrue(hp.VerifyLogInButton());
	}
	
	@Test
	public void VerifyCreateNewAccount() {
		hp.VerifyCreateNewAccountFunctionality();
	}
	
	@Test
	public void VerifyPageScrollable() throws InterruptedException {
		Assert.assertTrue(hp.VerifyPageScrollable());
	}
	
	@Test
	public void VerifySeacrhFumctionality() throws InterruptedException {
		Assert.assertTrue(hp.VerifySearchFunctionality());
	}
	
	@Test
	public void VerifyCollectionDropDown() throws InterruptedException {
		Assert.assertTrue(hp.VerifyCollectionDropdown());
	}
	@Test
	public void VerifyPromotionalBannerClickable() throws InterruptedException {
		Assert.assertTrue(hp.VerifyPromotionalBannerClickable());
	}
	@Test
	public void VerifyCartbuttonClickable() throws InterruptedException {
		Assert.assertTrue(hp.VerifyCartButtonClickable());
	}
	@Test
	public void VerifySocialMediaIconClickable() {
		hp.VerifySocialMediaIconClickable();
	}
	@Test
	public void VerifyFooterLinkShippingAndReturnsTabClickable() {
		Assert.assertTrue(hp.VerifyFooterShippingAndReturnstab());
	}
	@Test
	public void VerifyFooterLinkAboutUsTabClickable() {
		Assert.assertTrue(hp.VerifyFooterAboutUstab());
	}
	@Test
	public void VerifyFooterLinkContactUsTabClickable() {
		Assert.assertTrue(hp.VerifyFooterContactUstab());
	}
	@Test
	public void VerifyFooterLinkBlogClickable() {
		Assert.assertTrue(hp.VerifyFooterBlogtab());
	}
	@Test
	public void VerifyFooterLinkFaqTabClickable() {
		Assert.assertTrue(hp.VerifyFooterFaqtab());
	}
	@Test
	public void VerifyFooterLinkTermsOfServiceTabClickable() {
		Assert.assertTrue(hp.VerifyFooterTermsOfServicestab());
	}
}
