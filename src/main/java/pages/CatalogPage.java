package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CatalogPage extends BasePage {

    public static final String BASE_URL = "https://www.saucedemo.com/inventory.html";
    private static final By TITLE_LOCATOR = By.xpath("//span[@class='title' and text()='Products']");

    public CatalogPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        this.baseUrl = BASE_URL;
        this.basePageElementId = TITLE_LOCATOR;
    }

    private static final By BURGER_MENU_ICON = By.id("react-burger-menu-btn");
    private static final By CLOSES_MENU_BUTTON = By.id("react-burger-cross-btn");
    private static final By LOGOUT_BUTTON = By.id("logout_sidebar_link");
    private static final By SHOPPING_CART_BUTTON = By.id("shopping_cart_container");

    public static final String PRODUCT_XPATH_PATTERN =
            "//div[contains(text(),'%s')]/ancestor::div[@class='inventory_item']//button";
    private static final String PRODUCT_XPATH_PATTERN_LINK =
            "//div[contains(text(),'%s')]/ancestor::div[@class='inventory_item_label']//a";
    private static final String PRODUCT_XPATH_PATTERN_INFO =
            "//div[contains(text(),'%s')]/ancestor::div[@class='inventory_item']//div[@class='inventory_item_desc']";
    private static final String PRODUCT_XPATH_PATTERN_PRICE =
            "//div[contains(text(),'%s')]/ancestor::div[@class='inventory_item']//div[@class='inventory_item_price']";
    private static final String PRODUCT_XPATH_PATTERN_IMG =
            "//div[contains(text(),'%s')]/ancestor::div[@class='inventory_item']//img";

    public void addProductToCart(String partialProductTitle) {
        driver.findElement(By.xpath(String.format(PRODUCT_XPATH_PATTERN, partialProductTitle))).click();
    }

    public void clickCartButton() {
        driver.findElement(SHOPPING_CART_BUTTON).click();
    }

    public boolean isDisplayedCartButton() {
        return driver.findElement(SHOPPING_CART_BUTTON).isDisplayed();
    }

    public boolean isDisplayedMenuButton() {
        return driver.findElement(BURGER_MENU_ICON).isDisplayed();
    }

    public void logout() {
        driver.findElement(BURGER_MENU_ICON).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(LOGOUT_BUTTON)).click();
    }

    public String productInfo(String partialProductTitle) {
        return driver.findElement(By.xpath(String.format(PRODUCT_XPATH_PATTERN_INFO, partialProductTitle))).getText();
    }

    public String productPrice(String partialProductTitle) {
        return driver.findElement(By.xpath(String.format(PRODUCT_XPATH_PATTERN_PRICE, partialProductTitle))).getText();
    }

    public boolean findProductInCart(String pattern, String partialProductTitle) {
        return driver.findElement(By.xpath(String.format(pattern, partialProductTitle))).isDisplayed();
    }

    public String getProductTitle(String partialProductTitle) {
        return driver.findElement(By.xpath(String.format(PRODUCT_XPATH_PATTERN, partialProductTitle))).getText();
    }

    public boolean productImg(String partialProductTitle) {
        return driver.findElement(By.xpath(String.format(PRODUCT_XPATH_PATTERN_IMG, partialProductTitle))).isDisplayed();
    }

}
