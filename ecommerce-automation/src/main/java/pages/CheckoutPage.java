package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By firstName =
            By.id("first-name");

    private By lastName =
            By.id("last-name");

    private By postalCode =
            By.id("postal-code");

    private By continueButton =
            By.id("continue");

    private By finishButton =
            By.id("finish");

    private By confirmationMessage =
            By.className("complete-header");


    public CheckoutPage(WebDriver driver) {

        this.driver = driver;

        this.wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(30)
        );
    }


    public void enterCustomerDetails(
            String firstNameValue,
            String lastNameValue,
            String postalCodeValue) {

        wait.until(
                ExpectedConditions.urlContains(
                        "checkout-step-one.html"
                )
        );


        // First Name
        WebElement firstNameField =
                wait.until(
                        ExpectedConditions.elementToBeClickable(
                                firstName
                        )
                );

        firstNameField.clear();
        firstNameField.sendKeys(firstNameValue);


        // Last Name
        WebElement lastNameField =
                wait.until(
                        ExpectedConditions.elementToBeClickable(
                                lastName
                        )
                );

        lastNameField.clear();
        lastNameField.sendKeys(lastNameValue);


        // Postal Code
        WebElement postalCodeField =
                wait.until(
                        ExpectedConditions.elementToBeClickable(
                                postalCode
                        )
                );

        postalCodeField.clear();
        postalCodeField.sendKeys(postalCodeValue);
    }


    public void clickContinue() {

        WebElement continueBtn =
                wait.until(
                        ExpectedConditions.elementToBeClickable(
                                continueButton
                        )
                );

        continueBtn.click();

        wait.until(
                ExpectedConditions.urlContains(
                        "checkout-step-two.html"
                )
        );
    }


    public void clickFinish() {

        WebElement finishBtn =
                wait.until(
                        ExpectedConditions.elementToBeClickable(
                                finishButton
                        )
                );

        finishBtn.click();

        wait.until(
                ExpectedConditions.urlContains(
                        "checkout-complete.html"
                )
        );
    }


    public String getConfirmationMessage() {

        WebElement message =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                confirmationMessage
                        )
                );

        return message.getText();
    }
}