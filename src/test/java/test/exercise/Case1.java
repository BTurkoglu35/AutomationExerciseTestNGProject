package test.exercise;


import pages.AccountInformationAutomationExercisePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Case1 extends TestBaseRapor {

    AccountInformationAutomationExercisePage autoE;

    @Test
    public void test01() throws InterruptedException {
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
        String email = Driver.faker().internet().emailAddress();
        String name = Driver.faker().name().fullName();
        Driver.actions().click(autoE.name).sendKeys(name).sendKeys(Keys.TAB)
                .sendKeys(email).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        extentTest.info("Firstname and lastname information was entered , save button clicked");

        softAssert.assertTrue(autoE.enterAccountInformation.isDisplayed());
        extentTest.info("Verified that Enter account information is visible ");


        Driver.actions().click(autoE.mrsTitle).sendKeys(Keys.TAB)
                .sendKeys(name).sendKeys(Keys.TAB)
                .sendKeys(Driver.faker().internet().password()).perform();
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

        autoE.continueAccountCreated.click();
        extentTest.info("continue button clicked");

        Driver.getDriver().switchTo().frame(autoE.iframeAccount);
        autoE.dismisButton.click();
        Driver.getDriver().switchTo().defaultContent();


        softAssert.assertTrue(autoE.kullaniciAdiIleGirisYapildi.isDisplayed());
        extentTest.info("Signed in as username verified");

        autoE.deleteAccount.click();
        extentTest.info("account delete button clicked");

        softAssert.assertTrue(autoE.accountDeleted.isDisplayed());
        extentTest.info("account deleted text visibility verified");
        softAssert.assertAll();

        Driver.closeDriver();

    }
}
