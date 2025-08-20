package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import utility.ExtentManager;
import utility.ExtentManager;

public class primaryTestCase {
    protected WebDriver driver;

    @BeforeSuite
    public void initReport() {
        ExtentManager.initReport();
    }

    @BeforeClass
    public void setupBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in/");
    }

    @AfterClass
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterSuite
    public void flushReport() {
        ExtentManager.flushReport();// Finalize the report
    }
}
