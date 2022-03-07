package saucedemotest;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.Retry;

public class ProductTest extends BaseTest {

    public static final String TEST_PRODUCT_TITLE = "Test.allTheThings() T-Shirt (Red)";
    //public static final String PRODUCT_XPATH_PATTERN = "//div[contains(text(),'%s')]";
    public static final String TEST_PRODUCT_TITLE2 = "Sauce Labs Backpack";
    public static final String ADD_TO_CART_BUTTON = "ADD TO CART";
    public static final String REMOVE_BUTTON = "REMOVE";
    public static String price = "$29.99";
    private String info = "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.";

    @BeforeMethod
    private void login() {
        loginPage.open();
        Assert.assertTrue(loginPage.isPageLoadedWait(), "Login page was not loaded");
        loginPage.login(USERNAME, PASSWORD);
        Assert.assertTrue(catalogPage.isPageLoadedWait(), "Catalog page was not loaded");
    }

    @Test
    public void checkProductElementsTest() {
        Assert.assertEquals(catalogPage.getProductTitle(TEST_PRODUCT_TITLE2), ADD_TO_CART_BUTTON, "The button ADD_TO_CART was not correct");
        Assert.assertEquals(catalogPage.productPrice(TEST_PRODUCT_TITLE2), price, "Price of the product was not correct");
        Assert.assertEquals(catalogPage.productInfo(TEST_PRODUCT_TITLE2), info, "Information of the product was not correct");
        Assert.assertTrue(catalogPage.productImg(TEST_PRODUCT_TITLE2), "Image of the product was not displayed");
    }

    @Test
    public void checkProductButtonTest() {
        Assert.assertEquals(catalogPage.getProductTitle(TEST_PRODUCT_TITLE),
                ADD_TO_CART_BUTTON, "Title of the button ADD_TO_CART is not correct");
        catalogPage.addProductToCart(TEST_PRODUCT_TITLE);
        Assert.assertEquals(catalogPage.getProductTitle(TEST_PRODUCT_TITLE), REMOVE_BUTTON,
                "Title of the button Remove is not correct");
    }

    @Test
    public void checkCartButtonTest() {
        Assert.assertTrue(catalogPage.isDisplayedCartButton(),
                "Shopping Cart button was not displayed");
    }

    @Test
    public void checkMenuButtonTest() {
        Assert.assertTrue(catalogPage.isDisplayedMenuButton(),
                "Menu button was not displayed");
    }

    @Test(retryAnalyzer = Retry.class)
    @Parameters({"title"})
    public void addRemoveProductToCartTest(@Optional("Sauce Labs Backpack") String title) {
        catalogPage.addProductToCart(title);
        cartPage.open();
        cartPage.isPageLoadedWait();
        Assert.assertEquals(cartPage.findProductByNameInCard(title), title, "Selected product is not in the cart");
        cartPage.clickRemoveProduct();
        Assert.assertTrue(cartPage.isCartEmpty(), "Product was not removed");
    }

    @Test(retryAnalyzer = Retry.class)
    public void addProductToCartTest() {
        catalogPage.addProductToCart(TEST_PRODUCT_TITLE);
        cartPage.open();
        cartPage.isPageLoadedWait();
        Assert.assertEquals(cartPage.findProductByNameInCard(TEST_PRODUCT_TITLE), TEST_PRODUCT_TITLE, "Selected product is not in the cart");
    }

    @Test(retryAnalyzer = Retry.class)
    public void removeAddedProductTest(){
        catalogPage.addProductToCart(TEST_PRODUCT_TITLE);
        cartPage.clickRemoveProduct();
        Assert.assertTrue(cartPage.isCartEmpty(), "Product was not removed");
    }

    @Test
    public void logoutTest() {
        catalogPage.logout();
        Assert.assertTrue(loginPage.isPageLoadedWait(), "User cannot logout");
    }

}
