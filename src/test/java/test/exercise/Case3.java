package test.exercise;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HesapBilgileriAutomationExercisePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class Case3 extends TestBaseRapor {
    HesapBilgileriAutomationExercisePage autoE;
    @Test
    public void negativeLogin() throws InterruptedException {
        autoE=new HesapBilgileriAutomationExercisePage();
        SoftAssert softAssert = new SoftAssert();
        extentTest= extentReports.createTest("negativeLogin","yanlis kullanici bilgileri ile giris yapilamadigini dogrulama");

        Driver.getDriver().get(ConfigReader.getProperty("automationexerciseUrl"));

        softAssert.assertTrue(autoE.anasayfa.isDisplayed(), "anasayfa goruntulenmedi");
        String expectedUrl = "https://www.automationexercise.com/";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(expectedUrl, actualUrl, "anasayfa goruntulenmedi");
        extentTest.info("anasayfa gorunurlugu dogrulandi");


        autoE.signupLogin.click();
        extentTest.info("kayıt Ol / Giriş Yap dugmesi tiklandi");

        softAssert.assertTrue(autoE.loginAccountText.isDisplayed());
        extentTest.info("hesabiniza girirs yapin yazisinin gorunurlugu dogrulandi");


        Driver.actions().click(autoE.loginEmail).sendKeys(ConfigReader.getProperty("wrongemail"))
                .sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("wrongPassword"))
                .sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        extentTest.info("yanlis kullanici bilgileri girildi ve giris yap butonuna basildi");

        softAssert.assertTrue(autoE.negativeLoginText.isDisplayed());
        softAssert.assertAll();
        extentTest.info("E-postanız veya şifreniz yanlış! yazisinin gorunurlugu dogrulandi");

    }
}
