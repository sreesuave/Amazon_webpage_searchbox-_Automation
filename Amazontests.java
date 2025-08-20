package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import PageObjects.LoginPage;
import utility.ScreenshotUtil;

public class Amazontests extends BaseTest {

    @Test
    public void validateURLContainsAmazon() {
        try {
            Assert.assertTrue(driver.getCurrentUrl().contains("amazon"), "URL does not contain 'amazon'.");
            System.out.println("✅ URL validation passed.");
        } catch (AssertionError e) {
            ScreenshotUtil.captureScreenshot(driver, "URLValidationFailed");
            throw e;
        }
    }

    @Test
    public void validateLoginFlow() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.clickContinueShoppingIfPresent();

        if (loginPage.hoverAndClickSignInFromNavbar()) {
            boolean success = loginPage.loginToAmazon("usersnamehasbeentaken@gmail.com", "KCkj7Z(7jAb:5i!");
            if (!success) {
                ScreenshotUtil.captureScreenshot(driver, "LoginFailed");
                Assert.fail("Login failed due to missing elements.");
            } else {
                System.out.println("✅ Login flow executed successfully.");
            }
        } else {
            ScreenshotUtil.captureScreenshot(driver, "SignInNavigationFailed");
            Assert.fail("Could not navigate to sign-in page.");
        }
    }
}
