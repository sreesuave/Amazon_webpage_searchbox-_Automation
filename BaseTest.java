package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import PageObjects.LoginPage;
import utility.BrowserFactory;

public class BaseTest {
    protected WebDriver driver;
    protected LoginPage loginPage;

    @BeforeClass
    public void setUp() {
    	driver = BrowserFactory.startApplication("chrome", "https://www.amazon.com", 10);

        loginPage = new LoginPage(driver);

        loginPage.clickContinueShoppingIfPresent();
        loginPage.hoverAndClickSignInFromNavbar();
        boolean loginSuccess = loginPage.loginToAmazon("usersnamehasbeentaken@gmail.com", "KCkj7Z(7jAb:5i!");

        if (!loginSuccess) {
            throw new RuntimeException("Login failed. Cannot proceed with tests.");
        }
    }

    @AfterClass
    public void tearDown() {
        BrowserFactory.quitBrowser();
    }
}
