package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutOneStepPage extends BasePage {

    public static final String BASE_URL = "https://www.saucedemo.com/checkout-step-one.html";
    private static final By TITLE_LOCATOR = By.xpath("//span[@class='title' and text()='Checkout: Your Information']");

    public CheckoutOneStepPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        this.baseUrl = BASE_URL;
        this.basePageElementId = TITLE_LOCATOR;
    }

    public static final By FIRST_NAME_LOCATOR = By.id("first-name");
    public static final By LAST_NAME_LOCATOR = By.id("last-name");
    public static final By POSTAL_CODE_LOCATOR = By.id("postal-code");
    private static final By CONTINUE_BUTTON = By.id("continue");
    private static final By CANCEL_BUTTON = By.id("cancel");
    private static final By ERROR_TEXT_MESSAGE = By.tagName("h3");
    public static final String FIRSTNAME_TEXT_FIELD_PLACEHOLDER = "First Name";
    public static final String LASTNAME_TEXT_FIELD_PLACEHOLDER = "Last Name";
    public static final String POSTCODE_TEXT_FIELD_PLACEHOLDER = "Zip/Postal Code";

    public void fillFormCheckoutStepOne(String firstname, String lastname, String zipcode) {
        driver.findElement(FIRST_NAME_LOCATOR).sendKeys(firstname);
        driver.findElement(LAST_NAME_LOCATOR).sendKeys(lastname);
        driver.findElement(POSTAL_CODE_LOCATOR).sendKeys(zipcode);
        driver.findElement(CONTINUE_BUTTON).click();
    }

    public String getFirstNamePlaceholder() {
        return driver.findElement(FIRST_NAME_LOCATOR).getAttribute("placeholder");
    }

    public String getLastNamePlaceholder() {
        return driver.findElement(LAST_NAME_LOCATOR).getAttribute("placeholder");
    }

    public String getPostalCodePlaceholder() {
        return driver.findElement(POSTAL_CODE_LOCATOR).getAttribute("placeholder");
    }

    public String getErrorTextForRequiredField() {
        return driver.findElement(ERROR_TEXT_MESSAGE).getText();
    }

    public void fillFormYourInf(By fieldLocator, String fieldValue) {
        driver.findElement(fieldLocator).sendKeys(fieldValue);
    }

    public void clickContinueButton() {
        driver.findElement(CONTINUE_BUTTON).click();
    }

}
