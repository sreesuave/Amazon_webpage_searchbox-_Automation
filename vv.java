package tests;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import org.testng.annotations.*;

public class vv {

    ExtentReports extent;
    ExtentTest test;

    @BeforeSuite
    public void setupReport() {
        String reportPath = System.getProperty("user.dir") + "/reports/ExtentReport.html";
        ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
        spark.config().setDocumentTitle("Demo Report");
        spark.config().setReportName("ExtentReport Test");
        spark.config().setTheme(Theme.STANDARD);

        extent = new ExtentReports();
        extent.attachReporter(spark);
        extent.setSystemInfo("Tester", "You");
    }

    @Test
    public void demoTest() {
        test = extent.createTest("Simple Demo Test");
        test.log(Status.INFO, "This is a demo log");
        test.pass("Test passed successfully");
    }

    @AfterSuite
    public void flushReport() {
        extent.flush();
    }
}
