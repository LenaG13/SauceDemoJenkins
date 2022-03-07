package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutTwoStepPage extends BasePage {

    public static final String BASE_URL = "https://www.saucedemo.com/checkout-step-two.html";
    private static final By TITLE_LOCATOR = By.xpath("//span[@class='title' and text()='Checkout: Overview']");

    public CheckoutTwoStepPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        this.baseUrl = BASE_URL;
        this.basePageElementId = TITLE_LOCATOR;
    }

    private static final By FINISH_BUTTON = By.id("finish");

    public void clickFinishButton() {
        driver.findElement(FINISH_BUTTON).click();
    }

}
