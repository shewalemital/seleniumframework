package base;

//package com.automation26.seleniumframework.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ConfigReader;

public class Baseclass {

    public WebDriver driver;

    @BeforeMethod
    public void setup() {

        ConfigReader config = new ConfigReader();

        String browser = config.getBrowser();

        if(browser.equalsIgnoreCase("chrome")) {

            WebDriverManager.chromedriver().setup();

            ChromeOptions options =
                    new ChromeOptions();

            options.addArguments("--disable-notifications");
            options.addArguments("--disable-save-password-bubble");

            driver = new ChromeDriver(options);
        }

        else if(browser.equalsIgnoreCase("edge")) {

            WebDriverManager.edgedriver().setup();

            driver = new EdgeDriver();
        }

        else if(browser.equalsIgnoreCase("firefox")) {

            WebDriverManager.firefoxdriver().setup();

            driver = new FirefoxDriver();
        }

        else {

            throw new RuntimeException(
                    "Unsupported Browser : " + browser);
        }

        driver.get(config.getUrl());

        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
    	//Thread.sleep(5000);
       // driver.quit();
    }
}
