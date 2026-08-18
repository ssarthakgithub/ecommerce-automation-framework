package listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import base.BaseTest;
import base.ExtentReportManager;
import utils.ScreenshotUtility;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {

        ExtentReportManager.createTest(
                result.getMethod().getMethodName()
        );

        ExtentReportManager.getTest().log(
                Status.INFO,
                "Test Started: " + result.getMethod().getMethodName()
        );
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        ExtentReportManager.getTest().log(
                Status.PASS,
                "Test Passed"
        );
    }

    @Override
    public void onTestFailure(ITestResult result) {

        ExtentReportManager.getTest().log(
                Status.FAIL,
                "Test Failed: " + result.getThrowable()
        );

        Object testClass = result.getInstance();

        if (!(testClass instanceof BaseTest)) {
            return;
        }

        BaseTest baseTest = (BaseTest) testClass;

        WebDriver driver = baseTest.getDriver();

        if (driver == null) {
            System.out.println(
                    "Screenshot skipped: driver is null."
            );
            return;
        }

        try {

            String screenshotPath =
                    ScreenshotUtility.captureScreenshot(
                            driver,
                            result.getMethod().getMethodName()
                    );

            ExtentReportManager.getTest().addScreenCaptureFromPath(
                    screenshotPath
            );

        } catch (Exception e) {

            System.out.println(
                    "Screenshot listener error: "
                    + e.getMessage()
            );
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        ExtentReportManager.getTest().log(
                Status.SKIP,
                "Test Skipped"
        );
    }

    @Override
    public void onFinish(org.testng.ITestContext context) {

        ExtentReportManager.flushReport();
    }
}