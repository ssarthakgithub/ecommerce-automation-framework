package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Sauce Labs Backpack
    private By backpack =
            By.id("add-to-cart-sauce-labs-backpack");

    // Cart icon
    private By cart =
            By.cssSelector("a.shopping_cart_link");


    public ProductsPage(WebDriver driver) {

        this.driver = driver;

        this.wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(30)
        );
    }


    // Add Backpack to Cart
    public void addProductToCart() {

        WebElement backpackButton =
                wait.until(
                        ExpectedConditions.elementToBeClickable(
                                backpack
                        )
                );

        backpackButton.click();

        // Verify cart badge shows 1
        wait.until(
                ExpectedConditions.textToBePresentInElementLocated(
                        By.className("shopping_cart_badge"),
                        "1"
                )
        );
    }


    // Open Cart
    public void openCart() {

        // Wait for cart icon
        WebElement cartButton =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                cart
                        )
                );

        // Scroll to cart
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});",
                cartButton
        );

        // Use JavaScript click
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();",
                cartButton
        );

        // Wait for Cart page
        wait.until(
                ExpectedConditions.urlContains(
                        "cart.html"
                )
        );
    }
}