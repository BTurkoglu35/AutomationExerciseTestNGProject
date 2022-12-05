package test.exercise;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HesapBilgileriAutomationExercisePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class Case2 extends TestBaseRapor {
    HesapBilgileriAutomationExercisePage kayitliHesap;

    @Test
    public void kayitliHesabiSilme() {
        kayitliHesap = new HesapBilgileriAutomationExercisePage();
        SoftAssert softAssert = new SoftAssert();
        extentTest = extentReports.createTest("kayitliHesabiSilme", "Kayitli hesap silinmeli");

        Driver.getDriver().get(ConfigReader.getProperty("automationexerciseUrl"));
        extentTest.info("sayfaya basarili bir sekilde girildir");

        softAssert.assertTrue(kayitliHesap.anasayfa.isDisplayed(), "anasayfa goruntulenmedi");
        String expectedUrl = "https://www.automationexercise.com/";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(expectedUrl, actualUrl, "anasayfa goruntulenmedi");
        extentTest.info("anasayfa gorunurlugu dogrulandi");


        kayitliHesap.signupLogin.click();
        softAssert.assertTrue(kayitliHesap.loginAccountText.isDisplayed());
        extentTest.info("hesabiniza giris yapin ifadesinin görünür olduğu dogrulandi");

        Driver.actions().click(kayitliHesap.loginEmail).sendKeys(ConfigReader.getProperty("usermailAE"))
                .sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("userpassword"))
                .sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        extentTest.info("Hesap bilgileri girilerek giris yapildi");

        softAssert.assertTrue(kayitliHesap.kullaniciAdiIleGirisYapildi.isDisplayed());
        extentTest.info("Kullanıcı adı olarak oturum açıldı yazisinin gorunurlugu dogrulandi");

        kayitliHesap.deleteAccount.click();
        extentTest.info("hesabi sil butonuna basildi");

        softAssert.assertTrue(kayitliHesap.deleteAccountNewWindow.isDisplayed());
        extentTest.info("hesabi sil yazisi gorunurlugu dogrulandi");
        softAssert.assertAll();


    }

}
