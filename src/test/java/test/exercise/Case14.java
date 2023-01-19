package test.exercise;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ProducCartAutomationExercisePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class Case14 extends TestBaseRapor {
    ProducCartAutomationExercisePage autoE = new ProducCartAutomationExercisePage();

    @Test
    public void siparisVerOdemeYarkenKaydolTest() throws InterruptedException {
        extentTest = extentReports.createTest("Add Products in Cart", "User should be able to add items to cart");
        SoftAssert softAssert = new SoftAssert();

        Driver.getDriver().get(ConfigReader.getProperty("automationexerciseUrl"));
        extentTest.info("Went to Url");

        softAssert.assertTrue(autoE.anasayfa.isDisplayed(), "Homepage not displayed");
        String expectedUrl = "https://www.automationexercise.com/";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(expectedUrl, actualUrl, "Homepage not displayed");

        ReusableMethods.jsScroll(autoE.ilkUrunAddCart);
        autoE.ilkUrunAddCart.click();
        extentTest.info("item added to cart");

        autoE.viewCartButton.click();
        extentTest.info("View cart button clicked");

        softAssert.assertTrue(autoE.shoppingCartText.isDisplayed());
        extentTest.info("Shopping cart text text visibilty verified");

        autoE.proceedToCheckoutButton.click();
        extentTest.info("Proceed To Checkout Button clicked");

        autoE.registerLoginButton.click();
        extentTest.info("Register/Login button clicked");

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
        String adress="Driver.faker().address().fullAddress()";
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
        extentTest.info("Information  entered to  create an account");

        softAssert.assertTrue(autoE.accountCreated.isDisplayed());
        extentTest.info("account created text visibility verified");

        autoE.continueAccountCreated.click();
        extentTest.info("continue button clicked");

        Driver.getDriver().switchTo().frame(autoE.iframeAccount);
        autoE.dismisButton.click();
        Driver.getDriver().switchTo().defaultContent();

        softAssert.assertTrue(autoE.kullaniciAdiIleGirisYapildi.isDisplayed());
        extentTest.info("Confirmed that the username is displayed");

        autoE.cart.click();
        extentTest.info("Cart button clicked");

        autoE.proceedToCheckoutButton.click();
        extentTest.info("Proceed to checkout button clicked");

        assert autoE.deliveryAdress.getText().contains(adress);
        extentTest.info("Adress verified");

        ReusableMethods.jsScroll(autoE.paymentpagecomments);
        autoE.paymentpagecomments.sendKeys(Driver.faker().toString());
        autoE.placeOrderButton.click();
        extentTest.info("Place order button clicked");

        autoE.nameOnCardButton.sendKeys(Driver.faker().name().fullName());
        Driver.actions().sendKeys(Keys.TAB).sendKeys(Driver.faker().finance().creditCard()).sendKeys(Keys.TAB).sendKeys("12").sendKeys(Keys.TAB)
                .sendKeys("1452").sendKeys(Keys.TAB).sendKeys("47").sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();


        assert autoE.orderPlacedText.isDisplayed();
        extentTest.info("Order placed text displayed verified");

        autoE.deleteAccount.click();
        extentTest.info("Account Delete button tiklandi");

        assert autoE.accountDeletedText.isDisplayed();
        extentTest.info("Account Delete Text visibility verified");

        softAssert.assertAll();

        Driver.closeDriver();

    }
}
