package test.exercise;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ProducCartAutomationExercisePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class Case12 extends TestBaseRapor {
    @Test
    public void SepeteUrunEklemeTest() {
        SoftAssert softAssert = new SoftAssert();
        ProducCartAutomationExercisePage autoE= new ProducCartAutomationExercisePage();
        extentTest = extentReports.createTest("Add Products in Cart", "User should be able to add items to cart");

        Driver.getDriver().get(ConfigReader.getProperty("automationexerciseUrl"));
        extentTest.info("went to url");

        softAssert.assertTrue(autoE.anasayfa.isDisplayed(), "homepage not displayed");
        String expectedUrl = "https://www.automationexercise.com/";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(expectedUrl, actualUrl, "homepage not displayed");

        autoE.products.click();
        extentTest.info("Products button clicked");


        ReusableMethods.jsScroll(autoE.ilkUrunIsim);
       Driver.actions().moveToElement(autoE.ilkUrunIsim).click(autoE.ilkUrunAddCart).perform();
       extentTest.info("first item added to cart");

        autoE.continueShoppingButton.click();
        extentTest.info("Continue Shopping Button clicked");

        Driver.actions().moveToElement(autoE.ikinciUrunIsim).click(autoE.ikinciUrunAddCart).perform();
        extentTest.info("second item added to cart");

        autoE.viewCartButton.click();
        extentTest.info("View cart button clicked ");

        softAssert.assertTrue(autoE.ilkUrunIsim.isDisplayed());
        softAssert.assertTrue(autoE.ikinciUrunIsim.isDisplayed());
        extentTest.info("Confirmed that both items have been added to cart");

        softAssert.assertAll();



    }
}
