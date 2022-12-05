package test.exercise;


import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProducCartAutomationExercisePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import static utilities.ReusableMethods.jsScroll;


public class Case20 extends TestBaseRapor {

    ProducCartAutomationExercisePage autoE = new ProducCartAutomationExercisePage();

    @Test
    public void test01() {
        extentTest = extentReports.createTest("product, cart", " Search Products and Verify Cart After Login");

        Driver.getDriver().get(ConfigReader.getProperty("automationexerciseUrl"));
        extentTest.info("Goed to url");


        autoE.products.click();
        extentTest.info("'Products' button clicked");

        assert autoE.allProductsText.isDisplayed();
        extentTest.info("Verified that the user successfully navigated to the ALL PRODUCTS page");

        Driver.actions().click(autoE.searchProductBox).sendKeys("Tshirt").sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        extentTest.info("The product name is entered in the search input and the search button is clicked");

        assert autoE.searchProductsText.isDisplayed();
        extentTest.info("Confirmed that 'INCREDIBLE PRODUCTS' is visible");

        autoE.searchProductsList.stream().forEach(t -> t.isDisplayed());
        extentTest.info("Verified that all search-related products are visible");

        jsScroll(autoE.addCartList.get(0));
        autoE.addCartList.get(0).click();
        for (int i = 2; i < autoE.addCartList.size(); i += 2) {
            autoE.continueShoppingButton.click();
            jsScroll(autoE.addCartList.get(i));
            autoE.addCartList.get(i).click();
        }
        extentTest.info("Products added to cart");

        autoE.viewCartButton.click();
        extentTest.info("'Cart' button clicked");


        Assert.assertTrue(!autoE.cartList.isEmpty());
        extentTest.info("Verified that products appear in the cart");


        autoE.signupLogin.click();
        Driver.actions().click(autoE.loginEmail).sendKeys(ConfigReader.getProperty("usermailAE")).sendKeys(Keys.TAB).
                sendKeys(ConfigReader.getProperty("userpassword")).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        extentTest.info("Clicked 'Register/Login' button and submitted login information");

        autoE.cart.click();
        extentTest.info("Back to Cart page");


        Assert.assertTrue(!autoE.cartList.isEmpty());
        extentTest.info("Confirmed that these products also appear in the cart after logging in");

    }
}

