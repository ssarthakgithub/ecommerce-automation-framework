import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.ProductsPage;

public class ProductTest extends BaseTest {

    @Test
    public void addProductToCartTest() {

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

        // 3. Add Backpack to cart
        productsPage.addProductToCart();

        // 4. Verify cart badge
        String cartCount =
                driver.findElement(
                        org.openqa.selenium.By.className("shopping_cart_badge")
                ).getText();

        Assert.assertEquals(
                cartCount,
                "1"
        );
    }
}