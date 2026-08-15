import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;

public class CartTest extends BaseTest {

    @Test
    public void verifyProductInCartTest() {

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

        // 5. Cart Page
        CartPage cartPage =
                new CartPage(driver);

        // 6. Get product name
        String productName =
                cartPage.getProductName();

        // 7. Verify product
        Assert.assertEquals(
                productName,
                "Sauce Labs Backpack"
        );
    }
}