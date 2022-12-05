package test.exercise;


import pages.ProducCartAutomationExercisePage;
import utilities.ConfigReader;
import utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBaseRapor;


public class Case7 extends TestBaseRapor {

    ProducCartAutomationExercisePage autoE;

    @Test
    public void test1() {
        autoE = new ProducCartAutomationExercisePage();
        extentTest = extentReports.createTest("Verify Test Cases Page", "Verify Test Cases Page");

        Driver.getDriver().get(ConfigReader.getProperty("automationexerciseUrl"));
        extentTest.info("Goed to url");

        String expectedUrl = "https://www.automationexercise.com/";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);
        extentTest.info("Verified that the homepage is successfully visible");

        autoE.testCases.click();
        extentTest.info("'Test Cases' button clicked");

        Assert.assertTrue(autoE.testCasesTitle.isDisplayed());
        extentTest.info("Verified that the user was successfully redirected to the test cases page");

    }
}
