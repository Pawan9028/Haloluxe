package com.haloluxe.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.haloluxe.utils.UtilityClass;

public class ContactUsPage extends UtilityClass{
	
	WebDriver driver;
	public ContactUsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//a[@href='/pages/contact-us']")
	WebElement contactUshomePageButton;
	
	@FindBy(xpath = "href=\"/account\"")
	List<WebElement> accountTab;  //1
	
	@FindBy(xpath = "//a[@href='/pages/contact-us']")
	WebElement contactUsAccountPageButton;
	
	@FindBy(xpath = "//input[@id='ContactFormName']")
	WebElement nameTextBox;
	@FindBy(xpath = "//input[@id='ContactFormEmail']")
	WebElement emailTextBox;
	@FindBy(xpath = "//input[@id='ContactFormPhone']")
	WebElement mobTextBox;
	@FindBy(xpath = "//textarea[@id='ContactFormMessage']")
	WebElement msgTextBox;
	@FindBy(xpath = "//input[@type='submit']")
	WebElement submitButton;
	
	@FindBy(xpath = "//h4[@class='contact-form__note form-success']")
	WebElement successmsg;

	public boolean VerifyContactUsbuttonOnHomPage() {
		contactUshomePageButton.click();
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Contact Us ❤ – Halo Luxe");
		return true;
	}
	
	public boolean VerifyContactUsButtonOnAccountPage() {
		//driver.get("https://haloluxe.com/");
		//accountTab.get(1).click();
		contactUsAccountPageButton.click();
		Assert.assertEquals(driver.getTitle(), "Contact Us ❤ – Halo Luxe");
		return true;
	}
	
	public boolean VerifyContactUsFormBySubmittingAllDetails() throws InterruptedException {
		contactUshomePageButton.click();
		eraseAndType(nameTextBox, "Pawan");
		//Thread.sleep(10000);
		eraseAndType(emailTextBox, "pavan@aristasystems.in");
		eraseAndType(mobTextBox, "7020562184");
		eraseAndType(msgTextBox, "Message through Automation");
		submitButton.click();
		Assert.assertEquals(driver.getTitle(), "Challenge – Halo Luxe");
		return true;
	}
	
	public boolean VerifyContactUsFormByNotSubmittingAnyDetails() {
		contactUshomePageButton.click();
		eraseAndType(nameTextBox, "");
		eraseAndType(emailTextBox, "");
		eraseAndType(mobTextBox, "");
		eraseAndType(msgTextBox, "");
		submitButton.click();
		Assert.assertEquals(driver.getTitle(), "Challenge – Halo Luxe");
		return true;
	}
	
	public boolean VerifyEnteringInvalidEmailIntoContactUsForm() {
		contactUshomePageButton.click();
		eraseAndType(nameTextBox, "pawan");
		eraseAndType(emailTextBox, "pawan@");
		eraseAndType(mobTextBox, "7020562184");
		eraseAndType(msgTextBox, "");
		submitButton.click();
		Assert.assertEquals(driver.getTitle(), "Challenge – Halo Luxe");
		return true;
	}
}
