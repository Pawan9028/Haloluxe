package com.haloluxe.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.haloluxe.base.BaseClass;
import com.haloluxe.pages.AddToCartPage;

public class AddToCartTest extends BaseClass {
	
	AddToCartPage atc;
	
	@BeforeMethod
	public void loadObject() {
		atc=new AddToCartPage(driver);
	}
	@Test
	public void verifyAddToCartItem() throws InterruptedException {
		Assert.assertTrue(atc.verifyAddingProductToCart());
	}
	@Test
	public void verifyAddingMoreThan1QuantityToCart() throws InterruptedException {
		Assert.assertTrue(atc.verifyAddingMoreThan1QuantityToCart());
	}
	@Test
	public void VerifyTotalPriceOfTheItem() throws InterruptedException {
		Assert.assertTrue(atc.VerifyTotalPriceOfTheItem());
	}
	@Test
	public void VerifyContinueShoppingAfterAddingAnItemToCart() throws InterruptedException {
		Assert.assertTrue(atc.VerifyContinueShoppingAfterAddingAnItemToCart());
	}


}
