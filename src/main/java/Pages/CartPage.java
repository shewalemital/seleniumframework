package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    By cartIcon = By.className("shopping_cart_link");

    public void openCart() {

        driver.findElement(cartIcon).click();

    }
    By productName = By.className("inventory_item_name");
    

    public String getProductName() {

        return driver.findElement(productName).getText();

    }
    By checkoutBtn = By.id("checkout");
    public void clickCheckout() {

        driver.findElement(checkoutBtn).click();

    }
}
