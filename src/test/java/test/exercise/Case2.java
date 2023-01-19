package test.exercise;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AccountInformationAutomationExercisePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class Case2 extends TestBaseRapor {
    AccountInformationAutomationExercisePage autoE;

     static String email=Driver.faker().internet().emailAddress();
   static String name ;
   static String  password=Driver.faker().internet().password();
    @Test
    public void accountCreated() throws InterruptedException {
        extentTest = extentReports.createTest("Create account and delete account", "Account must be created and deleted successfully");
        autoE = new AccountInformationAutomationExercisePage();
        SoftAssert softAssert = new SoftAssert();

        Driver.getDriver().get(ConfigReader.getProperty("automationexerciseUrl"));
        extentTest.info("went to  automationexercise url ");

        softAssert.assertTrue(autoE.anasayfa.isDisplayed(), "homepage not displayed");
        String expectedUrl = "https://www.automationexercise.com/";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(expectedUrl, actualUrl, "homepage not displayed");
        extentTest.info("homepage visibility verified");

        autoE.signupLogin.click();
        extentTest.info("signin /login button clicked");

        softAssert.assertTrue(autoE.newUserLoginText.isDisplayed());
        extentTest.info("New user record verified");
         name = Driver.faker().name().fullName();
        Driver.actions().click(autoE.name).sendKeys(name).sendKeys(Keys.TAB)
                .sendKeys(email).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        extentTest.info("Firstname and lastname information was entered , save button clicked");

        softAssert.assertTrue(autoE.enterAccountInformation.isDisplayed());
        extentTest.info("Verified that Enter account information is visible ");


        Driver.actions().click(autoE.mrsTitle).sendKeys(Keys.TAB)
                .sendKeys(name).sendKeys(Keys.TAB)
                .sendKeys(password).perform();
        Driver.select(autoE.days).selectByValue("4");
        Driver.select(autoE.months).selectByVisibleText("April");
        Driver.select(autoE.years).selectByVisibleText("1993");

        Thread.sleep(2000);
        ReusableMethods.jsScroll(autoE.bultenimizeKaydolun);
        Driver.actions().click(autoE.bultenimizeKaydolun).sendKeys(Keys.TAB).sendKeys(Keys.SPACE).sendKeys(Keys.TAB)
                .sendKeys(Driver.faker().name().firstName()).sendKeys(Keys.TAB).sendKeys(Driver.faker().name().lastName())
                .sendKeys(Keys.TAB).sendKeys("trendyol").sendKeys(Keys.TAB).sendKeys(Driver.faker().address().fullAddress())
                .sendKeys(Keys.TAB).sendKeys(Driver.faker().address().fullAddress()).perform();
        Driver.select(autoE.country).selectByVisibleText("Singapore");

        ReusableMethods.jsScroll(autoE.state);
        Driver.actions().click(autoE.state).sendKeys(Driver.faker().address().state()).sendKeys(Keys.TAB)
                .sendKeys(Driver.faker().address().country()).sendKeys(Keys.TAB).sendKeys(Driver.faker().address().zipCode())
                .sendKeys(Keys.TAB).sendKeys(Driver.faker().phoneNumber().phoneNumber()).sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();
        extentTest.info("Information  entered to  create an account");


        softAssert.assertTrue(autoE.accountCreated.isDisplayed());
        extentTest.info("account created text visibility verified");

        softAssert.assertAll();

        Driver.closeDriver();
    }

    @Test (dependsOnMethods ="accountCreated" )
    public void kayitliHesabiSilme() {
        autoE = new AccountInformationAutomationExercisePage();
        SoftAssert softAssert = new SoftAssert();
        extentTest = extentReports.createTest("Deleting a registered Account", "Registered account must be deleted");

        Driver.getDriver().get(ConfigReader.getProperty("automationexerciseUrl"));
        extentTest.info("the page has been successfully entered");

        softAssert.assertTrue(autoE.anasayfa.isDisplayed(), "homepage not displayed");
        String expectedUrl = "https://www.automationexercise.com/";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(expectedUrl, actualUrl, "homepage not displayed");
        extentTest.info("homepage visibility verified");


        autoE.signupLogin.click();
        softAssert.assertTrue(autoE.loginAccountText.isDisplayed());
        extentTest.info("Verified that login to your account is visible");

        Driver.actions().click(autoE.loginEmail).sendKeys(email)
                .sendKeys(Keys.TAB).sendKeys(password)
                .sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        extentTest.info("Login by entering account information");

        softAssert.assertTrue(autoE.kullaniciAdiIleGirisYapildi.isDisplayed());
        extentTest.info("Verified visibility of \"Logged in as username\"");

        autoE.deleteAccount.click();
        extentTest.info("Delete account button pressed");

        softAssert.assertTrue(autoE.accountDeleted.isDisplayed());
        extentTest.info("account deleted text is displayed");
        softAssert.assertAll();

        Driver.closeDriver();

    }

}
