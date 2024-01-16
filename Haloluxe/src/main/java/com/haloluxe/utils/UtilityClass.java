package com.haloluxe.utils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UtilityClass {

	WebDriver driver;
	

	@FindBy(xpath = "//a[@class='promo-pop__close js-promo-pop-close icon-fallback']")
	WebElement adblock;

	public void handle_Alert() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
		System.out.println(alert.getText());
	}

	public void eraseAndType(WebElement ele, String str) {
		try {
			ele.clear();
		} catch (Exception e) {
			ele.sendKeys(str);
		}
	}


	public void alertHandle() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
			System.out.println("Alert dismissed successfully.");
		} catch (Exception e) {
			System.out.println("No alert found. Continue with the test.");
		}
	}

	public void close_popup(WebElement ele) throws InterruptedException {
		//Thread.sleep(10000);
		try{
			Thread.sleep(10000);
		ele.click();
		System.out.println("Dynamic popup handled");
	}catch(Exception e) {
		System.out.println("Dynamic Popup not found");
		e.printStackTrace();
	}
	}
}
