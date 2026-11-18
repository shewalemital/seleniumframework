package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.WaitUtility;

public class CartPage {

    WebDriver driver;
    WaitUtility wait;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        wait = new WaitUtility(driver);
    }

    By cartIcon = By.className("shopping_cart_link");

    public void openCart() {
    	wait.waitForElement(cartIcon);
        driver.findElement(cartIcon).click();

    }
    By productName = By.className("inventory_item_name");
    

    public String getProductName() {

        return driver.findElement(productName).getText();

    }
    By checkoutBtn = By.id("checkout");
    public void clickCheckout() {
    	wait.waitForElement(checkoutBtn);
        driver.findElement(checkoutBtn).click();

    }
}
