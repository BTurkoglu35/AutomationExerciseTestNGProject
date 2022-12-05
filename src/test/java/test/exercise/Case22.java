package test.exercise;

import org.testng.annotations.Test;
import pages.ProducCartAutomationExercisePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class Case22 extends TestBaseRapor {

    ProducCartAutomationExercisePage autoE = new ProducCartAutomationExercisePage();

    @Test
    public void test22() {
        extentTest = extentReports.createTest("Add to cart from suggested item  ", "Should be able to Add to cart from suggested item ");

        Driver.getDriver().get(ConfigReader.getProperty("automationexerciseUrl"));
        extentTest.info("Goed to url");

        ReusableMethods.jsScroll(autoE.recommendedItemsText);
        extentTest.info("Moved to bottom of page ");

        assert autoE.recommendedItemsText.isDisplayed();
        extentTest.info("Recommend item confirmed that  visible");

        autoE.addCart.get(68).click();
        extentTest.info("Clicked on 'Add to Cart' on the recommended product");

        autoE.viewCartButton.click();
        extentTest.info("'View Cart' button clicked");


        assert autoE.cartTableBodyRowOne.isDisplayed();
        extentTest.info("Verified that the product is displayed on the cart page");


    }


}