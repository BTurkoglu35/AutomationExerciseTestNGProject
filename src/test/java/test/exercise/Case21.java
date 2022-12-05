package test.exercise;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.ProducCartAutomationExercisePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class Case21 extends TestBaseRapor {
    ProducCartAutomationExercisePage autoE = new ProducCartAutomationExercisePage();

    @Test
    public void test21() {
        extentTest = extentReports.createTest("product review", "Should be able to comment product");
        Driver.getDriver().get(ConfigReader.getProperty("automationexerciseUrl"));
        extentTest.info("Goed to url");

        autoE.products.click();
        extentTest.info("products button clicked.");

        assert autoE.allProductsText.isDisplayed();
        extentTest.info("All products text visibility verified");

        ReusableMethods.jsScroll(autoE.viewProductIlkUrun);
        autoE.viewProductIlkUrun.click();
        extentTest.info("view product button clicked");

        ReusableMethods.jsScroll(autoE.writeYourReview);
        assert autoE.writeYourReview.isDisplayed();
        extentTest.info("Write your review visibility verified ");

        String name = Faker.instance().name().firstName();
        String email = Faker.instance().internet().emailAddress();
        String text = Faker.instance().name().fullName();

        Driver.actions().click(autoE.reviewNameButton).sendKeys(name, Keys.TAB).sendKeys(email, Keys.TAB).
                sendKeys(text, Keys.TAB).sendKeys(Keys.ENTER).perform();
        extentTest.info("Submitted: email, name, and comment");

        assert autoE.thankYouReviewText.isDisplayed();
        extentTest.info("Thank you for your text visibility verified");
    }
}
