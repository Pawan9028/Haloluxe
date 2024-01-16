package com.haloluxe.pages;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.haloluxe.utils.UtilityClass;

public class HomePage extends UtilityClass {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='secondary-nav__link']")
	WebElement logInButton;

	@FindBy(xpath = "//a[@class='link account__form-secondary-btn']")
	List<WebElement> createAccount;

	@FindBy(id = "FirstName")
	WebElement firstName;
	@FindBy(id = "LastName")
	WebElement lastName;
	@FindBy(id = "Email")
	WebElement email;
	@FindBy(id = "CreatePassword")
	WebElement pass;
	@FindBy(xpath = "//*[@value='Create']")
	WebElement createButton;

	@FindBy(xpath = "//*[@class='section__title-text']")
	List<WebElement> socialFooterTitle;

	@FindBy(xpath = "//*[@class='search-page__form-input']")
	WebElement enterSearchItem;
	@FindBy(xpath = "//*[@class='search-page__form-submit']")
	List<WebElement> searchIcon;

	@FindBy(xpath = "//*[@aria-controls='sub-2']")
	WebElement collection_dropdown;
	@FindBy(xpath = "//*[@class='primary-nav__link animsition-link nav__link--sub js-header-sub-link-a']")
	List<WebElement> dropDown;
	@FindBy(xpath = "//*[@class='nav__sub__item']")
	List<WebElement> dropdownList;

	@FindBy(xpath = "//a[@class='home-carousel__btn c-btn c-btn--primary c-btn--small-mobile c-btn--default ']")
	List<WebElement> promotionalbBanners;

	@FindBy(xpath = "//*[@class='secondary-nav__link js-cart-trigger js-no-transition']")
	WebElement cartButton;
	@FindBy(xpath = "//*[@class='ajaxcart__label-title']")
	WebElement carttitle;

	@FindBy(xpath = "//*[@class='icon icon--facebook']")
	List<WebElement> fbIcon;
	@FindBy(xpath = "//*[@class='icon icon--twitter']")
	List<WebElement> twitterIcon;
	@FindBy(xpath = "//*[@class='icon icon--pinterest']")
	List<WebElement> pinterestIcon;
	@FindBy(xpath = "//*[@class='icon icon--instagram']")
	List<WebElement> instaIcon;

	@FindBy(xpath = "//*[@class='footer-nav__link']")
	List<WebElement> footerLinks;

	@FindBy(xpath = "//h1[@class='section__title-text h2']")
	WebElement textForSearchFunctionality;

	@FindBy(xpath = "//i[@class='icon icon--close']")
	WebElement pop_up;

	@FindBy(xpath = "//a[@class='promo-pop__close js-promo-pop-close icon-fallback']")
	WebElement popup;

	public boolean VerifyHomePageUrl() {
		String Exp_title = driver.getTitle();
		String Act_title = "Halo Luxe Luxury Hair Accessories";
		Assert.assertEquals(Act_title, Exp_title);
		return true;
	}

	public boolean VerifyLogInButton() throws InterruptedException {
		logInButton.click();
		close_popup(pop_up);
		String exp_title = "Account – Halo Luxe";
		String act_title = driver.getTitle();
		// System.out.println(act_title);
		Assert.assertEquals(act_title, exp_title);
		return true;
	}

	public void VerifyCreateNewAccountFunctionality() {
		logInButton.click();
		createAccount.get(1).click();
		firstName.sendKeys("");
		lastName.sendKeys("");
		email.sendKeys("");
		pass.sendKeys("");
		createButton.click();

	}

	public boolean VerifyPageScrollable() throws InterruptedException {
		alertHandle();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// js.executeScript("window.scrollBy(0, 2500)");
		Thread.sleep(10000);
		js.executeScript("arguments[0].scrollIntoView();", socialFooterTitle.get(3));
		System.out.println(socialFooterTitle.get(3).getText());
		Assert.assertEquals(socialFooterTitle.get(3).getText(), "Be the first to know");
		return true;
	}

	public boolean VerifySearchFunctionality() throws InterruptedException {

		// close_popup(pop_up);
		try {
			Thread.sleep(10000);
			driver.findElement(By.xpath("//*[@class='icon icon--close']")).click();
			System.out.println("Dynamic popup handled");
		} catch (Exception e) {
			System.out.println("Dynamic Popup not found");
			e.printStackTrace();
		}

		enterSearchItem.sendKeys("clips");

		searchIcon.get(0).click();
		System.out.println(driver.getTitle());
		String act = textForSearchFunctionality.getText();
		Assert.assertEquals(act, "Search results");
		return true;
	}

	public boolean VerifyCollectionDropdown() throws InterruptedException {
		close_popup(pop_up);
		dropDown.get(0).click();
		List<WebElement> options = dropdownList;
		for (WebElement option : options) {
			System.out.println("Text: " + option.getText() + " | Value: " + option.getAttribute("value"));
			Thread.sleep(10000);
			option.getText();
			option.click();
		}
		Thread.sleep(1000);
		Assert.assertEquals(true, true);
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		return true;
	}

	public boolean VerifyPromotionalBannerClickable() throws InterruptedException {
		// promotionalbBanners.get(0).click();
		// List<WebElement> options =promotionalbBanners;
		// for (WebElement option : options) {
		// System.out.println("Text: " + option.getText() + " | Value: " +
		// option.getAttribute("value"));
		// option.click();
		// System.out.println(driver.getTitle());]

		// closePopup();
		/*
		 * JavascriptExecutor js = (JavascriptExecutor)driver;
		 * js.executeScript("arguments[0].click();", promotionalbBanners);
		 */
		close_popup(pop_up);
		promotionalbBanners.get(0).click();
		Assert.assertEquals(driver.getTitle(), "Isabella – Halo Luxe");
		return true;

	}

	public boolean VerifyCartButtonClickable() throws InterruptedException {
		cartButton.click();
		Thread.sleep(1000);
		System.out.println(carttitle.getText());
		Assert.assertEquals(carttitle.getText(), "Shopping Cart");
		return true;
	}

	public void VerifySocialMediaIconClickable() {
		fbIcon.get(1).click();
		twitterIcon.get(1).click();
		pinterestIcon.get(1).click();
		instaIcon.get(1).click();

		// System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Halo Luxe Luxury Hair Accessories");
		driver.quit();
	}

	public boolean VerifyFooterShippingAndReturnstab() {
		footerLinks.get(0).click();
		Assert.assertEquals(driver.getTitle(), "Shipping & Returns – Halo Luxe");
		return true;
	}

	public boolean VerifyFooterAboutUstab() {
		footerLinks.get(1).click();
		Assert.assertEquals(driver.getTitle(), "About Us – Halo Luxe");
		return true;
	}

	public boolean VerifyFooterContactUstab() {
		footerLinks.get(2).click();
		Assert.assertEquals(driver.getTitle(), "Contact Us ❤ – Halo Luxe");
		return true;
	}

	public boolean VerifyFooterBlogtab() {
		footerLinks.get(3).click();
		Assert.assertEquals(driver.getTitle(), "Blog – Halo Luxe");
		return true;
	}

	public boolean VerifyFooterFaqtab() {
		footerLinks.get(4).click();
		Assert.assertEquals(driver.getTitle(), "FAQ – Halo Luxe");
		return true;
	}

	public boolean VerifyFooterTermsOfServicestab() {
		footerLinks.get(5).click();
		Assert.assertEquals(driver.getTitle(), "Terms of service – Halo Luxe");
		return true;
	}

	public void blockAd() {
		try {
			// adblock.click();
			// driver.findElement(By.linkText("icon icon--close")).click();
			pop_up.click();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("No ad found");
		}
	}

	/*
	 * public void closePopup() { Set<String> wids=driver.getWindowHandles();
	 * if(wids.size()>1) { driver.switchTo().window("Window Handle"); try {
	 * WebElement elementOnPopup=driver.findElement(By.
	 * xpath("//a[@class='promo-pop__close js-promo-pop-close icon-fallback']"));
	 * if(elementOnPopup.isDisplayed()) { elementOnPopup.click(); }
	 * }catch(NoSuchElementException e) {
	 * System.out.println("Alert is displayed but could not clcik");
	 * e.printStackTrace(); } } }
	 */

	/*
	 * public void close_popup() throws InterruptedException {
	 * //Thread.sleep(10000); try{ Thread.sleep(10000); driver.findElement(By.
	 * xpath("//a[@class='promo-pop__close js-promo-pop-close icon-fallback']")).
	 * click(); System.out.println("Dynamic popup handled"); }catch(Exception e) {
	 * System.out.println("Dynamic Popup not found"); e.printStackTrace(); } }
	 */

}
