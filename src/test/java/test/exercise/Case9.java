package test.exercise;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ProducCartAutomationExercisePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class Case9 extends TestBaseRapor {
    @Test
    public void testName() {
        SoftAssert softAssert = new SoftAssert();
        ProducCartAutomationExercisePage autoE = new ProducCartAutomationExercisePage();
        extentTest = extentReports.createTest("Search Product", "Search Product");


        Driver.getDriver().get(ConfigReader.getProperty("automationexerciseUrl"));
        extentTest.info("Goed to url");

        softAssert.assertTrue(autoE.anasayfa.isDisplayed(), "anasayfa goruntulenmedi");
        extentTest.info("Verified that the homepage is successfully visible");

        autoE.products.click();
        extentTest.info(" Products button clicked");

        softAssert.assertTrue(autoE.allProductsText.isDisplayed(), "tum urunler ssayfasina gidilemedi");
        extentTest.info("Verified that user successfully navigated to ALL PRODUCTS page");

        Driver.actions().click(autoE.urunAramaKutusu).sendKeys("Blue Top").click(autoE.aramaKutusuClick).perform();
        extentTest.info("Entered the product name in the search input and clicked the search button");


        softAssert.assertTrue(autoE.searchedProducts.isDisplayed(), "aranan urunler bolumu gorunur");
        extentTest.info("Confirmed that 'SEARCHING PRODUCTS' is visible");

        ReusableMethods.jsScroll(autoE.viewProductIlkUrun);
        autoE.viewProductIlkUrun.click();
        softAssert.assertTrue(autoE.ilkUrunIsim.isDisplayed());
        extentTest.info("Verified that all search-related products are visible");

        softAssert.assertAll();
    }
}