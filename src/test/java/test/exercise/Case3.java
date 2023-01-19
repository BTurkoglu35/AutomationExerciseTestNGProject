package test.exercise;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AccountInformationAutomationExercisePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class Case3 extends TestBaseRapor {
    AccountInformationAutomationExercisePage autoE;
    @Test
    public void WrongLogin() throws InterruptedException {
        autoE=new AccountInformationAutomationExercisePage();
        SoftAssert softAssert = new SoftAssert();
        extentTest= extentReports.createTest("WrongLogin","Verify that login cannot be made with incorrect user information");

        Driver.getDriver().get(ConfigReader.getProperty("automationexerciseUrl"));

        softAssert.assertTrue(autoE.anasayfa.isDisplayed(), "homepage not displayed");
        String expectedUrl = "https://www.automationexercise.com/";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(expectedUrl, actualUrl, "homepage not displayed");
        extentTest.info("Homepage visibility verified");


        autoE.signupLogin.click();
        extentTest.info("Signin/LogIn button clicked");

        softAssert.assertTrue(autoE.loginAccountText.isDisplayed());
        extentTest.info("Login your account text visibilty verified");


        Driver.actions().click(autoE.loginEmail).sendKeys(ConfigReader.getProperty("wrongemail"))
                .sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("wrongPassword"))
                .sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        extentTest.info("Wrong user information was entered and the login button was pressed");

        softAssert.assertTrue(autoE.negativeLoginText.isDisplayed());
        softAssert.assertAll();
        extentTest.info("Your email or password is incorrect! text visibility confirmed");

        Driver.closeDriver();

    }
}
