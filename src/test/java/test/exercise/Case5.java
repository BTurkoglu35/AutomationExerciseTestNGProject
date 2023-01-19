package test.exercise;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AccountInformationAutomationExercisePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;


public class Case5 extends TestBaseRapor {

    @Test
    public void uniqeEmail() {
        AccountInformationAutomationExercisePage autoE=new AccountInformationAutomationExercisePage();
        SoftAssert softAssert = new SoftAssert();
        extentTest = extentReports.createTest("Register", "Register User with existing email");


        Driver.getDriver().get(ConfigReader.getProperty("automationexerciseUrl"));
        extentTest.info("Goed to url");

        softAssert.assertTrue(autoE.anasayfa.isDisplayed(), "anasayfa goruntulenmedi");
        String expectedUrl = "https://www.automationexercise.com/";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(expectedUrl, actualUrl, "anasayfa goruntulenmedi");
        extentTest.info("Verified that the homepage is successfully visible");

        autoE.signupLogin.click();
        extentTest.info("Clicked the 'Register / Login' button");

        softAssert.assertTrue(autoE.newUserLoginText.isDisplayed());
        extentTest.info("Verified that the New User Registration is visible");


        Driver.actions().click(autoE.name).sendKeys(ConfigReader.getProperty("username")).sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("usermailAE")).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        extentTest.info("Entered name and registered e-mail address, clicked 'Register' button");

        softAssert.assertTrue(autoE.ePostaAdresiZatenVarUyarisi.isDisplayed());
        extentTest.info("'Email Address already exists!' error confirmed");

        softAssert.assertAll();
        Driver.closeDriver();
    }


}
