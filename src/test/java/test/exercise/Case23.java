package test.exercise;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HesapBilgileriAutomationExercisePage;
import pages.ProducCartAutomationExercisePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class Case23 extends TestBaseRapor {


    @Test
    public void test01() throws InterruptedException {

        ProducCartAutomationExercisePage autoE=new ProducCartAutomationExercisePage();
        SoftAssert softAssert = new SoftAssert();
        extentTest = extentReports.createTest("Billing", "Verifying Billing Information");

        Driver.getDriver().get(ConfigReader.getProperty("automationexerciseUrl"));
        extentTest.info("Goed to url");

        softAssert.assertTrue(autoE.anasayfa.isDisplayed(), "homepage not displayed");
        String expectedUrl = "https://www.automationexercise.com/";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(expectedUrl, actualUrl, "anasayfa goruntulenmedi");
        extentTest.info("Verified that the homepage is successfully visible");

        autoE.signupLogin.click();
        extentTest.info(" went to signup page ");

        String email = Driver.faker().internet().emailAddress();
        String name = Driver.faker().name().fullName();
        Driver.actions().click(autoE.name).sendKeys(name).sendKeys(Keys.TAB)
                .sendKeys(email).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        extentTest.info("first and last name information was entered save button was pressed");

        softAssert.assertTrue(autoE.enterAccountInformation.isDisplayed());
        extentTest.info("Verified that Enter account information is visible");

        Driver.actions().click(autoE.mrsTitle).sendKeys(Keys.TAB)
                .sendKeys(name).sendKeys(Keys.TAB)
                .sendKeys(Driver.faker().internet().password()).perform();
        Driver.select(autoE.days).selectByValue("4");
        Driver.select(autoE.months).selectByVisibleText("April");
        Driver.select(autoE.years).selectByVisibleText("1993");

        Thread.sleep(2000);
        String adress=Driver.faker().address().fullAddress();
        ReusableMethods.jsScroll(autoE.bultenimizeKaydolun);
        Driver.actions().click(autoE.bultenimizeKaydolun).sendKeys(Keys.TAB).sendKeys(Keys.SPACE).sendKeys(Keys.TAB)
                .sendKeys(Driver.faker().name().firstName()).sendKeys(Keys.TAB).sendKeys(Driver.faker().name().lastName())
                .sendKeys(Keys.TAB).sendKeys("trendyol").sendKeys(Keys.TAB).sendKeys(adress)
                .sendKeys(Keys.TAB).sendKeys(Driver.faker().address().fullAddress()).perform();
        Driver.select(autoE.country).selectByVisibleText("Singapore");

        ReusableMethods.jsScroll(autoE.state);
        Driver.actions().click(autoE.state).sendKeys(Driver.faker().address().state()).sendKeys(Keys.TAB)
                .sendKeys(Driver.faker().address().country()).sendKeys(Keys.TAB).sendKeys(Driver.faker().address().zipCode())
                .sendKeys(Keys.TAB).sendKeys(Driver.faker().phoneNumber().phoneNumber()).sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();
        extentTest.info(" information were entered to create an  account");

        softAssert.assertTrue(autoE.accountCreated.isDisplayed());
        extentTest.info("account created text  visibility verified ");

        autoE.continueAccountCreated.click();
        extentTest.info("continue buton clicked");

        Driver.getDriver().switchTo().frame(autoE.iframeAccount);
        autoE.dismisButton.click();
        Driver.getDriver().switchTo().defaultContent();

        ReusableMethods.jsScroll(autoE.ilkUrunAddCart);
        autoE.ilkUrunAddCart.click();
        extentTest.info("added product in the cart");

        autoE.viewCartButton.click();
        softAssert.assertTrue(autoE.shoppingCartText.isDisplayed());
        extentTest.info("went to cart");

        autoE.proceedToCheckoutButton.click();
        extentTest.info("went to billing page");

        softAssert.assertTrue(autoE.deliveryAdress.getText().contains(adress));
        softAssert.assertTrue(autoE.billingAdress.getText().contains(adress));
        extentTest.info("adress information is  verified");

        autoE.deleteAccount.click();
        extentTest.info("account delete button clicked");

        softAssert.assertTrue(autoE.accountDeleted.isDisplayed());
        extentTest.info("account deleted text visibility verified");
        softAssert.assertAll();









    }
}
