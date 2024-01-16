package com.haloluxe.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.haloluxe.utils.UtilityClass;

public class AddToCartPage extends UtilityClass{
	
	WebDriver driver;
	
	public AddToCartPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//input[@aria-label='Search our store...']")
	List<WebElement> searchBox;  //1
	@FindBy(xpath = "//button[@type='submit']")
	List<WebElement> searchButton;  //1
	@FindBy(xpath = "//h2[@class='product-card__title f-family--heading f-caps--false f-space--1']")
	List<WebElement> clickOnItem;  //0
	@FindBy(xpath = "//button[@class='c-btn c-btn--full c-btn--primary product-form__add-btn js-product-add']")
	WebElement addToCartButton;
	@FindBy(xpath = "//h4[@class='ajaxcart__label-title']")
	WebElement message;
	String exp="Shopping Cart";
	
	@FindBy(xpath = "//button[@class='ajaxcart__qty-adjust ajaxcart__qty--plus']")
	WebElement addMorethan1Quantitybutton;
	@FindBy(xpath = "//input[@class='ajaxcart__qty-num js-qty-input']")
	WebElement text;
	
	@FindBy(xpath = "//*[@class='c-btn c-btn--full c-btn--hollow js-close-mfp ajaxcart__continue']")
	WebElement continueshoppingbutton;
	@FindBy(xpath = "//span[@class='money']")
	List<WebElement> totalPrice; //2
	
	@FindBy(xpath = "//h2[@class='section__title-text']")
	List<WebElement> continushop_PageText; //0
	
	  @FindBy(xpath =  "//*[@class='icon icon--close']") WebElement popup;
	
public boolean verifyAddingProductToCart() throws InterruptedException {
	searchBox.get(1).sendKeys("clips");
	searchButton.get(1).click();
	clickOnItem.get(0).click();
	addToCartButton.click();
	Thread.sleep(10000);
	Assert.assertEquals(message.getText(), exp);
	return true;
}
public boolean verifyAddingMoreThan1QuantityToCart() throws InterruptedException {
	searchBox.get(1).sendKeys("Headbands");
	searchButton.get(1).click();
	clickOnItem.get(0).click();
	addToCartButton.click();
	Thread.sleep(10000);
	addMorethan1Quantitybutton.click();
	Thread.sleep(10000);
	addMorethan1Quantitybutton.click();
	Thread.sleep(10000);
	String exp="";
	
	String act= text.getText();
	Thread.sleep(10000);

	Assert.assertEquals(act, exp);
	return true;
}
public boolean VerifyTotalPriceOfTheItem() throws InterruptedException {
	close_popup(popup);
	searchBox.get(1).sendKeys("clips");
	searchButton.get(1).click();
	clickOnItem.get(0).click();
	addToCartButton.click();
	Thread.sleep(10000);
	continueshoppingbutton.click();
	clickOnItem.get(0).click();
	addToCartButton.click();
	Thread.sleep(10000);
	String act=totalPrice.get(2).getText();
	Thread.sleep(10000);

	Assert.assertEquals(act, "$48.00");
	return true;
}
public boolean VerifyContinueShoppingAfterAddingAnItemToCart() throws InterruptedException {
	searchBox.get(1).sendKeys("clips");
	searchButton.get(1).click();
	clickOnItem.get(0).click();
	addToCartButton.click();
	continueshoppingbutton.click();
	Thread.sleep(10000);
	String exp=continushop_PageText.get(0).getText();
	String act="Related products";
	String act1="";
	Assert.assertEquals(act1, exp);
	
	return true;
	
}
}
