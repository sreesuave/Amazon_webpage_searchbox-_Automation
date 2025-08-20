package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonHomePage {
    WebDriver driver;

    // Constructor
    public AmazonHomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Locator
    By continueShoppingBtn = By.id("continueShopping");

    // Global handler
    public void handleContinueShoppingPopup() {
        try {
            if (driver.findElements(continueShoppingBtn).size() > 0) {
                driver.findElement(continueShoppingBtn).click();
                System.out.println("✅ 'Continue Shopping' popup handled.");
            }
        } catch (Exception e) {
            System.out.println("⚠️ 'Continue Shopping' popup not present or not clickable.");
        }
    }
}
