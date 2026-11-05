package com.automation26.selenumframework;


	import org.testng.annotations.Test;

import Pages.Loginpage;
import base.Baseclass;
import org.testng.Assert;

	public class LoginTest extends Baseclass {

	    @Test
	    public void verifyLogin() {

	        Loginpage login = new Loginpage(driver);

	        login.enterUsername("standard_user");
	        login.enterPassword("secret_sauce");
	        login.clickLogin();

	        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));
	    }
	}

