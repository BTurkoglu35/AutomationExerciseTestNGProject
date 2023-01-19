package test.exercise;

import pages.ProducCartAutomationExercisePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBaseRapor;


public class Case10 extends TestBaseRapor {


    @Test
    public void test01() {
        SoftAssert softAssert = new SoftAssert();
        ProducCartAutomationExercisePage autoE= new ProducCartAutomationExercisePage();
        extentTest = extentReports.createTest("Verify Subscription in home page", "Verify Subscription in home page");

        Driver.getDriver().get(ConfigReader.getProperty("automationexerciseUrl"));
        extentTest.info("Goed to url");

        softAssert.assertTrue(autoE.anasayfa.isDisplayed(),"homepage not displayed");
        extentTest.info("Verified that the homepage is successfully visible");

        ReusableMethods.jsScroll(autoE.altBilgi);
        extentTest.info("Moved to footer");

        softAssert.assertTrue(autoE.altBilgi.isDisplayed(),"Subscription text  not displayed");
        extentTest.info("'SUBSCRIPTION' text verified");

        Driver.actions().click(autoE.subscriptionEmailBox).sendKeys("ertk@gmail.com",Keys.ENTER).perform();
        extentTest.info("Entered the e-mail address and clicked the ok button.");

        softAssert.assertTrue(autoE.successSucribe.isDisplayed(),"SuccessSucribe text  not displayed");
        extentTest.info("Success message confirmed'");

        softAssert.assertAll();

        Driver.closeDriver();
    }
}
