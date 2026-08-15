import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductsPage;

public class CheckoutTest extends BaseTest {

    @Test
    public void completeCheckoutTest() {

        // 1. Login
        LoginPage loginPage =
                new LoginPage(driver);

        loginPage.login(
                "standard_user",
                "secret_sauce"
        );


        // 2. Products Page
        ProductsPage productsPage =
                new ProductsPage(driver);

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


        // 6. Go to Checkout
        cartPage.clickCheckout();


        // 7. Checkout Page
        CheckoutPage checkoutPage =
                new CheckoutPage(driver);


        // 8. Enter Customer Details
        checkoutPage.enterCustomerDetails(
                "Sarthak",
                "Saxena",
                "201301"
        );


        // 9. Continue
        checkoutPage.clickContinue();


        // 10. Finish
        checkoutPage.clickFinish();


        // 11. Verify Order Confirmation
        String confirmation =
                checkoutPage.getConfirmationMessage();

        Assert.assertEquals(
                confirmation,
                "Thank you for your order!"
        );
    }
}