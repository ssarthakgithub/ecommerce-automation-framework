package utils;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtility {

    public static void captureScreenshot(
            WebDriver driver,
            String testName) {

        if (driver == null) {
            System.out.println(
                    "Screenshot skipped: WebDriver is null."
            );
            return;
        }

        try {

            // Check whether browser session is still alive
            driver.getWindowHandles();

            // Take screenshot
            File source =
                    ((TakesScreenshot) driver)
                            .getScreenshotAs(OutputType.FILE);

            // Create screenshots folder
            File folder = new File("screenshots");

            if (!folder.exists()) {
                folder.mkdirs();
            }

            // Create screenshot file
            File destination =
                    new File(
                            folder,
                            testName + ".png"
                    );

            // Copy screenshot
            Files.copy(
                    source.toPath(),
                    destination.toPath(),
                    StandardCopyOption.REPLACE_EXISTING
            );

            System.out.println(
                    "Screenshot saved at: "
                    + destination.getAbsolutePath()
            );

        } catch (Exception e) {

            // Don't let screenshot failure break TestNG
            System.out.println(
                    "Screenshot skipped: "
                    + e.getMessage()
            );
        }
    }
}