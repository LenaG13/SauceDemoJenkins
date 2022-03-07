package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutCompletePage extends BasePage{

    public static final String BASE_URL = "https://www.saucedemo.com/checkout-complete.html";
    private static final By TITLE_LOCATOR = By.xpath("//span[@class='title' and text()='Checkout: Complete!']");

    public CheckoutCompletePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        this.baseUrl = BASE_URL;
        this.basePageElementId = TITLE_LOCATOR;
    }

    private static final By BACK_HOME_BUTTON = By.id("back-to-products");

    public void clickBackHomeButton() {
        driver.findElement(BACK_HOME_BUTTON).click();
    }

}
