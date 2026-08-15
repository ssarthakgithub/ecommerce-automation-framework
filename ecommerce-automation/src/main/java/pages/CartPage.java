package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Product name in cart
    private By productName =
            By.className("inventory_item_name");

    // Checkout button
    private By checkoutButton =
            By.id("checkout");


    public CartPage(WebDriver driver) {

        this.driver = driver;

        this.wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(30)
        );
    }


    // Get product name
    public String getProductName() {

        WebElement product =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                productName
                        )
                );

        return product.getText();
    }


    // Click Checkout
    public void clickCheckout() {

        // Make sure we are on cart page
        wait.until(
                ExpectedConditions.urlContains("cart.html")
        );

        // Wait for checkout button
        WebElement checkout =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                checkoutButton
                        )
                );

        // Try clicking up to 3 times
        boolean checkoutOpened = false;

        for (int attempt = 1; attempt <= 3; attempt++) {

            try {

                // Wait until clickable
                wait.until(
                        ExpectedConditions.elementToBeClickable(
                                checkoutButton
                        )
                );

                checkout.click();

                // Wait for checkout page
                wait.until(
                        ExpectedConditions.urlContains(
                                "checkout-step-one.html"
                        )
                );

                checkoutOpened = true;

                System.out.println(
                        "Checkout page opened successfully on attempt "
                        + attempt
                );

                break;

            } catch (Exception e) {

                System.out.println(
                        "Checkout click attempt "
                        + attempt
                        + " failed."
                );

                // Re-find element in case DOM changed
                try {

                    checkout =
                            wait.until(
                                    ExpectedConditions.visibilityOfElementLocated(
                                            checkoutButton
                                    )
                            );

                } catch (Exception ignored) {
                }
            }
        }


        // If checkout did not open after 3 attempts
        if (!checkoutOpened) {

            throw new RuntimeException(
                    "Checkout page could not be opened after 3 attempts."
            );
        }
    }
}