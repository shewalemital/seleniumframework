package com.automation26.selenumframework;


	import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.CartPage;
import Pages.CheckoutPage;
import Pages.InventoryPage;
import Pages.Loginpage;
import utilities.ScreenshotUtility;
import org.testng.annotations.Listeners;
import listeners.TestListener;
import utilities.ConfigReader;
import base.Baseclass;
@Listeners(TestListener.class)
	public class LoginTest extends Baseclass {
		public void loginToApplication() {

	        Loginpage login = new Loginpage(driver);

	        ConfigReader config = new ConfigReader();

	        login.enterUsername(config.getUsername());
	        login.enterPassword(config.getPassword());
	        login.clickLogin();
		}
	    @Test
	    public void verifyLogin() {

	    	loginToApplication();
	    	 ScreenshotUtility.captureScreenshot(
	    	            driver,
	    	            "LoginSuccess");

	        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));
	    }
	    @Test
	    public void addToCartTest() {

	    	loginToApplication();

	        InventoryPage inventory = new InventoryPage(driver);

	        inventory.addProduct();
	    }
	    @Test
	    public void openCartTest() {

	    	loginToApplication();

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
	    public void checkoutTest() {

	    	loginToApplication();

	        InventoryPage inventory = new InventoryPage(driver);

	        inventory.addProduct();

	        CartPage cart = new CartPage(driver);

	        cart.openCart();
	        System.out.println(driver.getCurrentUrl());
	        //Thread.sleep(2000);
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
	

