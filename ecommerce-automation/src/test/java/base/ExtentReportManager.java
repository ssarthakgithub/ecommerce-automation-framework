package base;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

    private static ExtentReports extent;
    private static ExtentTest test;

    public static ExtentReports getExtentReports() {

        if (extent == null) {

            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss")
                    .format(new Date());

            String reportPath = System.getProperty("user.dir")
                    + "/test-output/ExtentReport_"
                    + timestamp
                    + ".html";

            ExtentSparkReporter sparkReporter =
                    new ExtentSparkReporter(reportPath);

            sparkReporter.config().setDocumentTitle("E-Commerce Automation Report");
            sparkReporter.config().setReportName("Selenium TestNG Automation Report");

            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);

            extent.setSystemInfo("Project", "E-Commerce Automation");
            extent.setSystemInfo("Framework", "Selenium + TestNG");
            extent.setSystemInfo("Language", "Java");
            extent.setSystemInfo("Build Tool", "Maven");
        }

        return extent;
    }

    public static ExtentTest createTest(String testName) {

        test = getExtentReports().createTest(testName);

        return test;
    }

    public static ExtentTest getTest() {
        return test;
    }

    public static void flushReport() {

        if (extent != null) {
            extent.flush();
        }
    }
}