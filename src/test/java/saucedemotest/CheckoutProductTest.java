package saucedemotest;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static saucedemotest.ProductTest.TEST_PRODUCT_TITLE2;

public class CheckoutProductTest extends BaseTest {

    @BeforeMethod
    private void login() {
        loginPage.open();
        Assert.assertTrue(loginPage.isPageLoadedWait(), "Login page was not loaded");
        loginPage.login(USERNAME, PASSWORD);
        Assert.assertTrue(catalogPage.isPageLoadedWait(), "Catalog page was not loaded");
    }

    @Test
    public void purchaseProduct() {
        catalogPage.addProductToCart(TEST_PRODUCT_TITLE2);
        cartPage.open();
        cartPage.isPageLoadedWait();
        cartPage.clickContinueShopping();
        catalogPage.addProductToCart(TEST_PRODUCT_TITLE2);
        cartPage.open();
        cartPage.isPageLoadedWait();
        cartPage.clickCheckoutButton();
        checkoutOneStepPage.fillFormCheckoutStepOne(FIRST_NAME, LAST_NAME, ZIP_CODE);
        checkoutTwoStepPage.clickFinishButton();
        checkoutCompletePage.clickBackHomeButton();
        Assert.assertTrue(catalogPage.isPageLoadedWait(), "Catalog was not loaded");
    }

}
