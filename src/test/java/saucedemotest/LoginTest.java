package saucedemotest;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.TestListener;

/*@Listeners({TestListener.class})*/
public class LoginTest extends BaseTest {

    @BeforeMethod
    public void openLoginPage() {
        loginPage.open();
        Assert.assertTrue(loginPage.isPageLoadedWait(), "Login page was not loaded");
    }

    @Test
    public void validCredentialsLoginTest() {
        loginPage.login(USERNAME,
                PASSWORD);
        Assert.assertTrue(catalogPage.isPageLoadedWait(), "Catalog page was not loaded");
    }

    @Test
    public void usernamePlaceholderTest() {
        Assert.assertEquals(
                loginPage.getUsernamePlaceholder(),
                LoginPage.USERNAME_TEXT_FIELD_PLACEHOLDER,
                "Username placeholder is not valid"
        );
    }

    @Test
    public void passwordPlaceholderTest() {
        Assert.assertEquals(loginPage.getPasswordPlaceholder(),
                LoginPage.PASSWORD_TEXT_FIELD_PLACEHOLDER,
                "Password placeholder is not valid"
        );
    }

    @Test
    public void emptyUsernameLoginTest() {
        loginPage.loginEmptyUsername(PASSWORD);
        Assert.assertEquals(loginPage.getErrorMessage(),
                loginPage.ERROR_MESSAGE_USERNAME,
                "The message emptyUsernameLoginTest is not correct");
    }

    @Test
    public void emptyPasswordLoginTest() {
        loginPage.loginEmptyPassword(USERNAME);
        Assert.assertEquals(loginPage.getErrorMessage(),
                loginPage.ERROR_MESSAGE_PASSWORD,
                "The message emptyPasswordLoginTest is not correct");
    }

    @Test
    public void invalidCredentialsLoginTest() {
        loginPage.login(loginPage.USERNAME_INVALID, loginPage.PASSWORD_INVALID);
        Assert.assertEquals(loginPage.getErrorMessage(), loginPage.ERROR_MESSAGE,
                "The message invalidCredentialsLoginTest is not correct");
    }

}
