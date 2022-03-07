package saucedemotest;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static saucedemotest.ProductTest.TEST_PRODUCT_TITLE2;

public class CheckoutInfoTest extends BaseTest{

    @BeforeMethod
    private void login() {
        loginPage.open();
        Assert.assertTrue(loginPage.isPageLoadedWait(), "Login page was not loaded");
        loginPage.login(USERNAME, PASSWORD);
        Assert.assertTrue(catalogPage.isPageLoadedWait(), "Catalog page was not loaded");
        catalogPage.addProductToCart(TEST_PRODUCT_TITLE2);
        cartPage.open();
        cartPage.isPageLoadedWait();
        cartPage.clickContinueShopping();
        catalogPage.addProductToCart(TEST_PRODUCT_TITLE2);
        cartPage.open();
        cartPage.isPageLoadedWait();
        cartPage.clickCheckoutButton();
    }

    @Test
    public void firstnamePlaceholderTest() {
        Assert.assertEquals(
                checkoutOneStepPage.getFirstNamePlaceholder(),
                checkoutOneStepPage.FIRSTNAME_TEXT_FIELD_PLACEHOLDER,
                "Firstname placeholder is not valid"
        );
    }

    @Test
    public void lastnamePlaceholderTest() {
        Assert.assertEquals(
                checkoutOneStepPage.getLastNamePlaceholder(),
                checkoutOneStepPage.LASTNAME_TEXT_FIELD_PLACEHOLDER,
                "Lastname placeholder is not valid"
        );
    }

    @Test
    public void zipcodePlaceholderTest() {
        Assert.assertEquals(
                checkoutOneStepPage.getPostalCodePlaceholder(),
                checkoutOneStepPage.POSTCODE_TEXT_FIELD_PLACEHOLDER,
                "PostCode placeholder is not valid"
        );
    }

}
