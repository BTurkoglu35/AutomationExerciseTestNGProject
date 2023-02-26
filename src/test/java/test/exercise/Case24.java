package test.exercise;

import org.apache.poi.hssf.record.DrawingRecord;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProducCartAutomationExercisePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class Case24 extends TestBaseRapor {


    ProducCartAutomationExercisePage autoE=new ProducCartAutomationExercisePage();

    @Test
    public void InvoiceDownload() throws InterruptedException {
        extentTest = extentReports.createTest("Invvoice Download", "Download Invoice after purchase order");

        Driver.getDriver().get(ConfigReader.getProperty("automationexerciseUrl"));
        extentTest.info("goed to url");

        String expectedUrl="https://www.automationexercise.com/";
        String actualUrl=Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
        extentTest.info("homepage is displayed");

        ReusableMethods.jsScroll(autoE.ilkUrunAddCart);
        autoE.ilkUrunAddCart.click();
        extentTest.info("item added to cart");

        autoE.viewCartButton.click();
        extentTest.info("Goed to cart");

        assert autoE.shoppingCartText.isDisplayed();
        extentTest.info("Cart page is displayed ");

        autoE.proceedToCheckoutButton.click();

        autoE.checkoutRegisterLogin.click();

        String email = Driver.faker().internet().emailAddress();
        String name = Driver.faker().name().fullName();
        Driver.actions().click(autoE.name).sendKeys(name).sendKeys(Keys.TAB)
                .sendKeys(email).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        extentTest.info("Firstname and lastname information was entered , save button clicked");

        Assert.assertTrue(autoE.enterAccountInformation.isDisplayed());
        extentTest.info("Verified that Enter account information is visible ");


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
        extentTest.info("Information  entered to  create an account");


        Assert.assertTrue(autoE.accountCreated.isDisplayed());
        extentTest.info("account created text visibility verified");

        autoE.continueAccountCreated.click();
        extentTest.info("continue button clicked");

        Driver.getDriver().switchTo().frame(autoE.iframeAccount);
        Driver.getDriver().switchTo().frame(autoE.iframeAccount2);
        autoE.dismisButton.click();
        Driver.getDriver().switchTo().defaultContent();

        Assert.assertTrue(autoE.kullaniciAdiIleGirisYapildi.isDisplayed());
        extentTest.info("Signed in as username verified");

        autoE.cart.click();
        autoE.proceedToCheckoutButton.click();

        Assert.assertTrue(autoE.billingAdress.getText().contains(adress));

        ReusableMethods.jsScroll(autoE.orderPlacedText);

        autoE.orderPlacedText.sendKeys("asdfgrr");

        autoE.placeOrderButton.click();


        autoE.cardNameBox.sendKeys(Driver.faker().name().fullName());

        autoE.cardNumberBox.sendKeys(Driver.faker().finance().creditCard());

        autoE.cvcBox.sendKeys("145");

        autoE.expirationBox.sendKeys("10");

        autoE.cardYearsBox.sendKeys("1995");

        autoE.playAndConfirmOrderButton.click();
        extentTest.info("ordered ");

        assert autoE.orderPlacedSuccesfullText.isDisplayed();

        autoE.downloadInvoiceButton.click();
        extentTest.info("Invoice  downloaded");

        autoE.continueButtonInvoicePage.click();
        extentTest.info("Continue button clicked");

        Driver.closeDriver();





    }



}
