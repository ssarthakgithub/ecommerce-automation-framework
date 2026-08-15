package base;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utils.ConfigReader;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {

        ConfigReader.loadProperties();

        String browser = ConfigReader.getProperty("browser");
        String url = ConfigReader.getProperty("url");

        int timeout = Integer.parseInt(
                ConfigReader.getProperty("timeout")
        );

        if (browser.equalsIgnoreCase("chrome")) {

            ChromeOptions options = new ChromeOptions();

            // Disable Chrome password manager
            Map<String, Object> prefs = new HashMap<>();

            prefs.put(
                    "credentials_enable_service",
                    false
            );

            prefs.put(
                    "profile.password_manager_enabled",
                    false
            );

            // Disable password leak detection
            prefs.put(
                    "profile.password_manager_leak_detection",
                    false
            );

            options.setExperimentalOption(
                    "prefs",
                    prefs
            );

            driver = new ChromeDriver(options);

        } else {

            throw new RuntimeException(
                    "Unsupported browser: " + browser
            );
        }

        driver.manage().window().maximize();

        // Use explicit waits in Page Objects
        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(0));

        driver.get(url);
    }


    @AfterMethod
    public void tearDown() {

        if (driver != null) {

            try {

                driver.quit();

            } catch (Exception e) {

                System.out.println(
                        "Browser could not be closed: "
                        + e.getMessage()
                );

            } finally {

                driver = null;
            }
        }
    }


    // Used by TestListener
    public WebDriver getDriver() {

        return driver;
    }
}