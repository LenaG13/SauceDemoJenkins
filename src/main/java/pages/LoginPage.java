package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    public static final String BASE_URL = "https://www.saucedemo.com/";

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        this.baseUrl = BASE_URL;
        this.basePageElementId = LOGIN_BUTTON;
    }

    private static final By USERNAME_TEXT_FIELD = By.id("user-name");
    private static final By PASSWORD_TEXT_FIELD = By.id("password");
    private static final By LOGIN_BUTTON = By.id("login-button");
    //private static final By ERROR_MESSAGE_CONTAINER = By.tagName("h3");
    private static final By ERROR_MESSAGE_CONTAINER = By.cssSelector("div.error-message-container.error");

    public static final String USERNAME_TEXT_FIELD_PLACEHOLDER = "Username";
    public static final String PASSWORD_TEXT_FIELD_PLACEHOLDER = "Password";

    public static final String USERNAME_INVALID = "fhksy";
    public static final String PASSWORD_INVALID = "uiot";

    public static final String ERROR_MESSAGE = "Epic sadface: Username and password do not match any user in this service";
    public static final String ERROR_MESSAGE_USERNAME = "Epic sadface: Username is required";
    public static final String ERROR_MESSAGE_PASSWORD = "Epic sadface: Password is required";

    public void login(String username, String password) {
        driver.findElement(USERNAME_TEXT_FIELD).sendKeys(username);
        driver.findElement(PASSWORD_TEXT_FIELD).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
    }

    public String getUsernamePlaceholder() {
        return driver.findElement(USERNAME_TEXT_FIELD).getAttribute("placeholder");
    }

    public String getPasswordPlaceholder() {
        return driver.findElement(PASSWORD_TEXT_FIELD).getAttribute("placeholder");
    }

    public String getErrorMessage() {
        return driver.findElement(ERROR_MESSAGE_CONTAINER).getText();
    }

    public void loginEmptyUsername(String password) {
        driver.findElement(PASSWORD_TEXT_FIELD).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
    }

    public void loginEmptyPassword(String username) {
        driver.findElement(USERNAME_TEXT_FIELD).sendKeys(username);
        driver.findElement(LOGIN_BUTTON).click();
    }

}
