package test.rapideploy.tests;

import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.rapideploy.common.Base;
import test.rapideploy.pages.ShoppingCartPage;

import java.io.IOException;


@Test
public class CheckoutTest extends Base {

    @BeforeMethod
    public void setup() throws IOException {
        super.setup();
    }

    @Description("As a user, I would like to successfully add items and checkout my cart")
    public void checkoutCart() {
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(getDriver());
        shoppingCartPage.enterUsername();
        shoppingCartPage.enterPassword();
        shoppingCartPage.clickLogin();
        shoppingCartPage.clickAddToCart();
        shoppingCartPage.clickShoppingCartButton();
        shoppingCartPage.clickCheckoutButton();
        shoppingCartPage.enterFirstName();
        shoppingCartPage.enterLastName();
        shoppingCartPage.enterPostalCode();
        shoppingCartPage.clickContinue();
        shoppingCartPage.clickFinish();
        Assert.assertTrue(getDriver().getCurrentUrl().contains("checkout-complete.html"));
    }
}