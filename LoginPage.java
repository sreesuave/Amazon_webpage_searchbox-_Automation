package PageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private static final By CONTINUE_SHOPPING_BUTTON = By.xpath("//input[@value='Continue shopping']");
    private static final By NAV_ACCOUNT_LIST = By.id("nav-link-accountList");
    private static final By SIGNIN_LINK = By.xpath("//div[@id='nav-flyout-ya-signin']//a[contains(@href, 'signin')]");
    private static final By EMAIL_INPUT = By.xpath("//*[@id=\"ap_email_login\"]");

    private static final By CONTINUE_BUTTON = By.id("continue");
    private static final By PASSWORD_INPUT = By.xpath("//*[@id=\"ap_password\"]");
    private static final By SIGNIN_SUBMIT = By.id("signInSubmit");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickContinueShoppingIfPresent() {
    	try {
    	    WebElement continueBtn = wait.until(ExpectedConditions.presenceOfElementLocated(
    	        By.xpath("/html/body/div/div[1]/div[3]/div/div/form/div/div/span/span/button")));
    	    
    	    if (continueBtn.isDisplayed()) {
    	        continueBtn.click();
    	        System.out.println("Clicked 'Continue Shopping' button.");
    	    }
    	} catch (TimeoutException | NoSuchElementException e) {
    	    System.out.println("'Continue Shopping' button not found. Skipping...");
    	}
    }

    public boolean hoverAndClickSignInFromNavbar() {
        try {
            WebElement accountList = wait.until(ExpectedConditions.presenceOfElementLocated(NAV_ACCOUNT_LIST));
            new Actions(driver).moveToElement(accountList).perform();

            WebElement signInLink = wait.until(ExpectedConditions.elementToBeClickable(SIGNIN_LINK));
            signInLink.click();

            wait.until(ExpectedConditions.urlContains("signin"));
            wait.until(ExpectedConditions.visibilityOfElementLocated(EMAIL_INPUT));

            System.out.println("Navigated to login page.");
            return true;
        } catch (Exception e) {
            System.out.println("Failed to click Sign In from navbar: " + e.getMessage());
            return false;
        }
    }

    public boolean loginToAmazon(String email, String password) {
        try {
            WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(EMAIL_INPUT));
            emailField.sendKeys(email);

            wait.until(ExpectedConditions.elementToBeClickable(CONTINUE_BUTTON)).click();

            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(PASSWORD_INPUT));
            passwordField.sendKeys(password);

            wait.until(ExpectedConditions.elementToBeClickable(SIGNIN_SUBMIT)).click();

            System.out.println("Login submitted.");
            return true;
        } catch (TimeoutException e) {
            System.out.println("Login elements not found in time: " + e.getMessage());
            return false;
        }
    }
}
