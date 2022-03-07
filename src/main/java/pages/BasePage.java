package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    WebDriver driver;
    WebDriverWait wait;
    protected String baseUrl;
    protected By basePageElementId;

    public BasePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public BasePage open() {
        driver.get(baseUrl);
        return this;
    }

    public boolean isPageLoaded() {
        return driver.findElement(basePageElementId).isDisplayed();
    }

    public boolean isPageLoadedWait() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(basePageElementId)).isDisplayed();
    }

}
