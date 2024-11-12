package test.rapideploy.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.rapideploy.common.Base;

import java.time.Duration;


public class ShoppingCartPage extends Base {

    WebDriverWait wait;

    public ShoppingCartPage(RemoteWebDriver driver) {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @FindBy(how = How.ID, using = "add-to-cart-sauce-labs-backpack")
    public WebElement saucelabsbackpackAddToCartButton;

    @FindBy(how = How.ID, using = "shopping_cart_container")
    public WebElement shoppingCartButton;

    @FindBy(how = How.ID, using = "user-name")
    public WebElement usernameTextbox;

    @FindBy(how = How.ID, using = "first-name")
    public WebElement firstNameTextbox;

    @FindBy(how = How.ID, using = "last-name")
    public WebElement lastNameTextbox;

    @FindBy(how = How.ID, using = "postal-code")
    public WebElement postalcodeTextbox;

    @FindBy(how = How.ID, using = "password")
    public WebElement passwordTextbox;
    @FindBy(how = How.ID, using = "login-button")
    public WebElement loginButton;

    @FindBy(how = How.ID, using = "continue")
    public WebElement continueButton;

    @FindBy(how = How.ID, using = "checkout")
    public WebElement checkoutButton;

    @FindBy(how = How.ID, using = "finish")
    public WebElement finishButton;


    public void enterUsername() {
        usernameTextbox.sendKeys("standard_user");
    }

    public void enterPassword() {
        passwordTextbox.sendKeys("secret_sauce");
    }

    public void enterFirstName() {
        firstNameTextbox.sendKeys("Mogale");
    }

    public void enterLastName() {
        lastNameTextbox.sendKeys("Mapaela");
    }

    public void enterPostalCode() {
        postalcodeTextbox.sendKeys("12345");
    }

    public void clickLogin() {
        loginButton.click();
    }

    public void clickContinue() {
        continueButton.click();
    }

    public void clickFinish() {
        finishButton.click();
    }

    public void clickAddToCart() {
        saucelabsbackpackAddToCartButton.click();
    }

    public void clickShoppingCartButton() {
        shoppingCartButton.click();
    }

    public void clickCheckoutButton() {
        checkoutButton.click();
    }

    public Alert isAlertDisplayed() {
        return wait.until(ExpectedConditions.alertIsPresent());
    }
}