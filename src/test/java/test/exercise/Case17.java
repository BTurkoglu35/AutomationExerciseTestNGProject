package test.exercise;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ProducCartAutomationExercisePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class Case17 extends TestBaseRapor {
    ProducCartAutomationExercisePage autoE = new ProducCartAutomationExercisePage();
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void testName() {
        extentTest = extentReports.createTest(" Cart", "Verify that the product has been removed from the cart");

        Driver.getDriver().get(ConfigReader.getProperty("automationexerciseUrl"));
        extentTest.info("goed to url");

        softAssert.assertTrue(autoE.anasayfa.isDisplayed(), "anasayfa goruntulenmedi");
        String expectedUrl = "https://www.automationexercise.com/";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(expectedUrl, actualUrl, "anasayfa goruntulenmedi");


        ReusableMethods.jsScroll(autoE.ilkUrunAddCart);
        autoE.ilkUrunAddCart.click();
        extentTest.info("Item added to cart");


        autoE.viewCartButton.click();
        extentTest.info("Clicked cart button");

        softAssert.assertTrue(autoE.shoppingCartText.isDisplayed());
        extentTest.info("Cart page is displayed");

        int ilkSize = autoE.cartDeleteButton.size();
        autoE.cartDeleteButton.get(0).click();
        extentTest.info("Clicked delete button");

        ReusableMethods.waitFor(5);
        int sonSize = autoE.cartDeleteButton.size();
        softAssert.assertTrue((ilkSize - 1) == sonSize);
        extentTest.info("Verified that the product has been removed from the cart");
        softAssert.assertAll();
    }
}
