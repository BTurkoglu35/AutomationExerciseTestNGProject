package test.exercise;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AccountInformationAutomationExercisePage;
import pages.ProducCartAutomationExercisePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class Case16 extends TestBaseRapor {
    ProducCartAutomationExercisePage autoE = new ProducCartAutomationExercisePage();
    AccountInformationAutomationExercisePage autoE2 = new AccountInformationAutomationExercisePage();
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void placeOrder() {
        extentTest = extentReports.createTest(" Place Order: Login before Checkout", "User must be a member without paying");

        Driver.getDriver().get(ConfigReader.getProperty("automationexerciseUrl"));
        extentTest.info("Goed to url");

        softAssert.assertTrue(autoE.anasayfa.isDisplayed(), "anasayfa goruntulenmedi");
        String expectedUrl = "https://www.automationexercise.com/";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(expectedUrl, actualUrl, "anasayfa goruntulenmedi");
        extentTest.info("Homepage is displayed");

        autoE2.signupLogin.click();

        Driver.actions().click(autoE2.loginEmail).sendKeys(ConfigReader.getProperty("usermailAE"))
                .sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("userpassword"))
                .sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();

        softAssert.assertTrue(autoE2.kullaniciAdiIleGirisYapildi.isDisplayed());
        extentTest.info("User name verified");

        ReusableMethods.jsScroll(autoE.ilkUrunAddCart);
        autoE.ilkUrunAddCart.click();
        extentTest.info("Item added to cart");

        autoE.viewCartButton.click();
        softAssert.assertTrue(autoE.shoppingCartText.isDisplayed());
        extentTest.info("Cart page is displayed");


        autoE.proceedToCheckoutButton.click();

        softAssert.assertTrue(autoE.addressDetailsText.isDisplayed());
        extentTest.info("Adress detail is verified");

        ReusableMethods.jsScroll(autoE.commentButton);
        Driver.actions().click(autoE.commentButton).sendKeys("ksdgkw").sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();

        Driver.actions().click(autoE.nameOnCardButton).sendKeys("master").sendKeys(Keys.TAB)
                .sendKeys("123654789632").sendKeys(Keys.TAB)
                .sendKeys("124").sendKeys(Keys.TAB).sendKeys("454").sendKeys(Keys.TAB).sendKeys("2020").sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();

        softAssert.assertTrue(autoE.orderPlacedText.isDisplayed());
        extentTest.info("'Your order has been successfully placed' text is verified");
        softAssert.assertAll();

    }
}
