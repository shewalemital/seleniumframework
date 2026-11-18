package base;

//package com.automation26.seleniumframework.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ConfigReader;

public class Baseclass {

    public WebDriver driver;

    @BeforeMethod
    public void setup() {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();

        options.addArguments("--disable-notifications");
        options.addArguments("--disable-save-password-bubble");

        driver = new ChromeDriver(options);

    

        //driver.get("https://www.saucedemo.com/");
        ConfigReader config = new ConfigReader();
        driver.get(config.getUrl());
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
    	//Thread.sleep(5000);
       // driver.quit();
    }
}
