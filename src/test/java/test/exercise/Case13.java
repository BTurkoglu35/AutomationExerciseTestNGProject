package test.exercise;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ProducCartAutomationExercisePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class Case13 extends TestBaseRapor {

    @Test
    public void sepettekiUrunMiktariniDogrulama() {
        ProducCartAutomationExercisePage autoE = new ProducCartAutomationExercisePage();
        extentTest = extentReports.createTest(" Cart", "Verify Product quantity in Cart");
        SoftAssert softAssert = new SoftAssert();

        Driver.getDriver().get(ConfigReader.getProperty("automationexerciseUrl"));
        extentTest.info("Went to url");

        softAssert.assertTrue(autoE.anasayfa.isDisplayed(), "Homepage not displayed");
        String expectedUrl = "https://www.automationexercise.com/";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(expectedUrl, actualUrl, "Homepage not displayed");

        ReusableMethods.jsScroll(autoE.viewProductIlkUrun);
        autoE.viewProductIlkUrun.click();
        extentTest.info("clicked to view product");

        softAssert.assertTrue(autoE.ilkUrunkategori.isDisplayed());
        extentTest.info("Confirmed that the product detail is opened");


        autoE.urunSayisiArttirmaButton.clear();
        autoE.urunSayisiArttirmaButton.sendKeys("4");

        autoE.viewProductAddCart.click();
        extentTest.info("View product add cart clicked");

        autoE.viewCartButton.click();
        extentTest.info("View cart button clicked");

        softAssert.assertTrue(autoE.sepetQuently.getText().equals("4"));
        extentTest.info("Verified that the product is displayed in full quantity on the cart page");
        softAssert.assertAll();

        Driver.closeDriver();
    }
}
