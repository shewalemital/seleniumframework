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
import org.testng.annotations.DataProvider;
import utilities.ExcelUtility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import base.Baseclass;
@Listeners(TestListener.class)
	public class LoginTest extends Baseclass {
	private static final Logger logger =
	        LogManager.getLogger(LoginTest.class);
	
		public void loginToApplication() {

	        Loginpage login = new Loginpage(driver);

	        ConfigReader config = new ConfigReader();

	        login.enterUsername(config.getUsername());
	        login.enterPassword(config.getPassword());
	        login.clickLogin();
		}
		
		@DataProvider(name = "loginData")
		public Object[][] loginData() {

		    return ExcelUtility.getLoginData();
		}
		@Test(dataProvider = "loginData")
		public void loginWithExcelData(
		        String username,
		        String password,
		        String expectedResult) {

		    Loginpage login =
		            new Loginpage(driver);

		    login.enterUsername(username);
		    login.enterPassword(password);
		    login.clickLogin();

		    if(expectedResult.equalsIgnoreCase("VALID")) {

		        Assert.assertTrue(
		                driver.getCurrentUrl()
		                        .contains("inventory"));

		        logger.info("Valid Login Passed");

		    } else {

		        Assert.assertTrue(
		                login.getErrorMessage().length() > 0);

		        logger.info("Invalid Login Passed");
		    }
		}
	    @Test
	    public void verifyLogin() {
	    	logger.info("Login Test Started");
	    	loginToApplication();
	    	logger.info("Login Successful");
	    	 ScreenshotUtility.captureScreenshot(
	    	            driver,
	    	            "LoginSuccess");

	        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));
	        //Assert.assertTrue(false);
	    }
	    @Test
	    public void addToCartTest() {

	    	loginToApplication();

	        InventoryPage inventory = new InventoryPage(driver);

	        inventory.addProduct();
	    }
	    @Test
	    public void openCartTest() {
	    	logger.info("Add To Cart Test Started");
	    	loginToApplication();
	    	logger.info("Product Added Successfully");
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
	    	logger.info("Checkout Test Started");
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
	

