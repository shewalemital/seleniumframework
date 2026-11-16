package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {

    WebDriver driver;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    By backpack = By.id("add-to-cart-sauce-labs-backpack");

    public void addProduct() {
        driver.findElement(backpack).click();
    }
}
