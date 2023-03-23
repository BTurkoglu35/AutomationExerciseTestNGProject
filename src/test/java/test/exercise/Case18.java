package test.exercise;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CategoryAutomationExercisePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class Case18 extends TestBaseRapor {
    CategoryAutomationExercisePage categoryPage = new CategoryAutomationExercisePage();

    @Test
    public void test01() {
        extentTest = extentReports.createTest(" Cart", "Verify that the product has been removed from the cart");

        Driver.getDriver().get(ConfigReader.getProperty("automationexerciseUrl"));
        extentTest.info("Goed to URL");

        assert categoryPage.category.isDisplayed();
        extentTest.info("Confirmed that categories are displayed");

        ReusableMethods.jsScroll(categoryPage.category);
        categoryPage.women.click();
        extentTest.info("Clicked on the women category");

        categoryPage.womenDress.click();
        extentTest.info("Clicked on any category link");

        categoryPage.womenDressProductstText.isDisplayed();
        extentTest.info("Confirmed that the clicked category is displayed");

        categoryPage.man.click();
        extentTest.info("Clicked on the man category");
        categoryPage.manTshirts.click();
        extentTest.info("Clicked on any category link");

        Assert.assertTrue(categoryPage.manTshirtsProductsText.isDisplayed());
        extentTest.info("\n" +
                "Verified that the redirected page has been navigated to");
    }
}

