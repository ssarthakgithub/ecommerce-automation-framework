import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseTest;
import listeners.TestListener;
import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductsPage;

@Listeners(TestListener.class)
public class EcommerceTest extends BaseTest {

    @Test
    public void completePurchaseTest() {

        // 1. Login
        LoginPage loginPage =
                new LoginPage(driver);

        loginPage.login(
                "standard_user",
                "secret_sauce"
        );


        // 2. Verify Products page
        ProductsPage productsPage =
                new ProductsPage(driver);

        String heading =
                driver.findElement(
                        By.className("title")
                ).getText();

        Assert.assertEquals(
                heading,
                "Products"
        );


        // 3. Add Backpack
        productsPage.addProductToCart();


        // 4. Open Cart
        productsPage.openCart();


        // 5. Verify Cart
        CartPage cartPage =
                new CartPage(driver);

        String productName =
                cartPage.getProductName();

        Assert.assertEquals(
                productName,
                "Sauce Labs Backpack"
        );


        // 6. Checkout
        cartPage.clickCheckout();


        // 7. Enter Customer Details
        CheckoutPage checkoutPage =
                new CheckoutPage(driver);

        checkoutPage.enterCustomerDetails(
                "Sarthak",
                "Saxena",
                "201301"
        );


        // 8. Continue
        checkoutPage.clickContinue();


        // 9. Finish
        checkoutPage.clickFinish();


        // 10. Verify Order
        String confirmation =
                checkoutPage.getConfirmationMessage();

        Assert.assertEquals(
                confirmation,
                "Thank you for your order!"
        );
    }
}