package com.automation26.selenumframework;


	import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.CartPage;
import Pages.CheckoutPage;
import Pages.InventoryPage;
import Pages.Loginpage;
import base.Baseclass;

	public class LoginTest extends Baseclass {

	    @Test
	    public void verifyLogin() {

	        Loginpage login = new Loginpage(driver);

	        login.enterUsername("standard_user");
	        login.enterPassword("secret_sauce");
	        login.clickLogin();

	        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));
	    }
	    @Test
	    public void addToCartTest() {

	        Loginpage login = new Loginpage(driver);

	        login.enterUsername("standard_user");
	        login.enterPassword("secret_sauce");
	        login.clickLogin();

	        InventoryPage inventory = new InventoryPage(driver);

	        inventory.addProduct();
	    }
	    @Test
	    public void openCartTest() {

	        Loginpage login = new Loginpage(driver);

	        login.enterUsername("standard_user");
	        login.enterPassword("secret_sauce");
	        login.clickLogin();

	        InventoryPage inventory =
	                new InventoryPage(driver);

	        inventory.addProduct();

	        CartPage cart =
	                new CartPage(driver);

	        cart.openCart();
	        Assert.assertEquals(
	                cart.getProductName(),
	                "Sauce Labs Backpack");
	    }
	    @Test
	    public void checkoutTest()throws InterruptedException {

	        Loginpage login = new Loginpage(driver);

	        login.enterUsername("standard_user");
	        login.enterPassword("secret_sauce");
	        login.clickLogin();

	        InventoryPage inventory = new InventoryPage(driver);

	        inventory.addProduct();

	        CartPage cart = new CartPage(driver);

	        cart.openCart();
	        System.out.println(driver.getCurrentUrl());
	        Thread.sleep(2000);
	        cart.clickCheckout();

	        CheckoutPage checkout = new CheckoutPage(driver);
	        checkout.enterFirstName("Mital");

	        checkout.enterLastName("Patil");

	        checkout.enterZipCode("410206");

	        checkout.clickContinue();

	        checkout.clickFinish();
	        Assert.assertEquals(
	                checkout.getSuccessMessage(),
	                "Thank you for your order!"
	        );
	    }
	}
	

