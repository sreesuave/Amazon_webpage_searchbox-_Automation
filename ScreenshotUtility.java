package utility;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class ScreenshotUtility {

    public static void captureAndAttachScreenshot(WebDriver driver, String fileName) {
        String path = System.getProperty("user.dir") + "/screenshots/" + fileName;
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(src, new File(path));
            ExtentManager.getTest().addScreenCaptureFromPath(path);
        } catch (IOException e) {
            ExtentManager.getTest().warning("Screenshot failed: " + e.getMessage());
        }
    }
}
