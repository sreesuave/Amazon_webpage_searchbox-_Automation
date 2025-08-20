package tests;

import org.testng.annotations.Test;
import PageObjects.SearchPage;
import utility.ExtentManager;
import utility.ScreenshotUtility;

public class Amazontestvalidations extends primaryTestCase {

    @Test(priority = 1)
    public void validateSearchWithValidInput() {
        runValidation("Search with Valid Input", "laptop");
    }

    @Test(priority = 2)
    public void validateSearchWithEmptyInput() {
        runValidation("Search with Empty Input", "");
    }

    @Test(priority = 3)
    public void validateSearchWithSpecialCharacters() {
        runValidation("Search with Special Characters", "@#$%^&*");
    }

    @Test(priority = 4)
    public void validateSearchWithNumbersOnly() {
        runValidation("Search with Numbers Only", "123456");
    }

    @Test(priority = 5)
    public void validateSearchWithLongText() {
        runValidation("Search with Long Text", "This is a very long search query to test the input box behavior");
    }

    @Test(priority = 6)
    public void validateSearchWithSingleCharacter() {
        runValidation("Search with Single Character", "a");
    }

    @Test(priority = 7)
    public void validateSearchWithMixedCase() {
        runValidation("Search with Mixed Case", "LaPToP");
    }

    @Test(priority = 8)
    public void validateSearchWithWhitespaceOnly() {
        runValidation("Search with Whitespace Only", "     ");
    }

    @Test(priority = 9)
    public void validateSearchWithUnicodeCharacters() {
        runValidation("Search with Unicode Characters", "こんにちは");
    }

    @Test(priority = 10)
    public void validateSearchWithHTMLTags() {
        runValidation("Search with HTML Tags", "<script>alert('test')</script>");
    }

    // 🔁 Centralized validation runner
    private void runValidation(String testName, String searchTerm) {
        ExtentManager.createTest(testName);
        SearchPage searchPage = new SearchPage(driver);
        try {
            ExtentManager.logInfo("Executing: " + testName);
            searchPage.search(searchTerm);
            ScreenshotUtility.captureAndAttachScreenshot(driver, testName.replace(" ", "_") + ".png");
            ExtentManager.logPass("Validation passed");
        } catch (Exception e) {
            ExtentManager.logFail("Validation failed: " + e.getMessage());
            ScreenshotUtility.captureAndAttachScreenshot(driver, testName.replace(" ", "_") + "_Error.png");
        } finally {
            // 🧹 Always clear the search bar after each test
            try {
                searchPage.clearSearchBar();
            } catch (Exception clearEx) {
                ExtentManager.logInfo("Search bar could not be cleared: " + clearEx.getMessage());
            }
        }
    }
}
