import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseTest;
import listeners.TestListener;
import pages.LoginPage;

@Listeners(TestListener.class)
public class LoginTest extends BaseTest {

    @Test
    public void validLoginTest() {

        // Create Login Page object
        LoginPage loginPage = new LoginPage(driver);

        // Login
        loginPage.login(
                "standard_user",
                "secret_sauce"
        );

        // Verify Products page
        String heading =
                driver.findElement(
                        By.className("title")
                ).getText();

        // Temporary wrong value to test screenshot
        Assert.assertEquals(
                heading,
                "Products"
        );
    }
}