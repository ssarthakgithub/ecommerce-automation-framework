package listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import base.BaseTest;
import utils.ScreenshotUtility;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {

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

            ScreenshotUtility.captureScreenshot(
                    driver,
                    result.getMethod().getMethodName()
            );

        } catch (Exception e) {

            // Screenshot failure should never fail the test
            System.out.println(
                    "Screenshot listener error: "
                    + e.getMessage()
            );
        }
    }
}