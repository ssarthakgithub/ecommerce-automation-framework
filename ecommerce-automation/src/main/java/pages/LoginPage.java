package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    // Username
    By username =
            By.id("user-name");

    // Password
    By password =
            By.id("password");

    // Login button
    By loginButton =
            By.id("login-button");

    // Error message
    By errorMessage =
            By.cssSelector("h3[data-test='error']");


    public LoginPage(WebDriver driver) {

        this.driver = driver;

        wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(10)
        );
    }


    // Valid login
    public void login(String usernameText,
                      String passwordText) {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        username
                )
        ).sendKeys(usernameText);

        driver.findElement(password)
                .sendKeys(passwordText);

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        loginButton
                )
        ).click();
    }


    // Get error message for invalid login
    public String getErrorMessage() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        errorMessage
                )
        ).getText();
    }
}