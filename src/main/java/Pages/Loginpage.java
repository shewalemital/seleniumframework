package Pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Loginpage {

    WebDriver driver;

    // Constructor
    public Loginpage(WebDriver driver) {

        this.driver = driver;
    }

    // Locators
    By username = By.id("user-name");
    By password = By.id("password");
    By loginButton = By.id("login-button");
    By errorMessage =
            By.cssSelector("h3[data-test='error']");

    // Actions

    public void enterUsername(String uname) {

        driver.findElement(username).sendKeys(uname);
    }

    public void enterPassword(String pwd) {

        driver.findElement(password).sendKeys(pwd);
    }

    public void clickLogin() {

        driver.findElement(loginButton).click();
    }
    public String getErrorMessage() {

        return driver.findElement(errorMessage)
                     .getText();
    }
}
