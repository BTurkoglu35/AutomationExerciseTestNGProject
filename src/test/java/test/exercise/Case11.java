package test.exercise;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProducCartAutomationExercisePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class Case11 extends TestBaseRapor {
    ProducCartAutomationExercisePage autoE;

    @Test
    public void sepetSayfasindaAbonelikDogrulama() {
        autoE = new ProducCartAutomationExercisePage();
        extentTest = extentReports.createTest("subscription", "You have successfully subscribed");

        Driver.getDriver().get(ConfigReader.getProperty("automationexerciseUrl"));
        extentTest.info("Goed to Url");


        String actuaUrl = Driver.getDriver().getCurrentUrl();
        String expectedUrl = "https://www.automationexercise.com/";
        Assert.assertEquals(expectedUrl, actuaUrl);
        extentTest.info("Homepage displayed verified");

        autoE.cart.click();
        extentTest.info("cart button clicked");


        ReusableMethods.jsScroll(autoE.altBilgi);


        Assert.assertTrue(autoE.altBilgi.isDisplayed());
        extentTest.info("subscription text verified");

        autoE.subscriptionEmailBox.sendKeys("test@gmail.com", Keys.ENTER);

        Assert.assertTrue(autoE.successSucribe.isDisplayed());
        extentTest.info("You have successfully subscribed text displayed verified");

        Driver.closeDriver();
    }
}
