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
        // 1. Tarayıcıyı başlatın
        //2. 'http://automationexercise.com' url'sine gidin
        Driver.getDriver().get(ConfigReader.getProperty("automationexerciseUrl"));
        extentTest.info("sayfaya basarili bir sekilde girildir");
        //3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
        softAssert.assertTrue(kayitliHesap.anasayfa.isDisplayed(), "anasayfa goruntulenmedi");
        String expectedUrl = "https://www.automationexercise.com/";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(expectedUrl, actualUrl, "anasayfa goruntulenmedi");
        extentTest.info("anasayfa gorunurlugu dogrulandi");

        //4. 'Kayıt Ol / Giriş Yap' düğmesine tıklayın
        kayitliHesap.signupLogin.click();
        //5. 'Hesabınıza giriş yapın' ifadesinin görünür olduğunu doğrulayın
        softAssert.assertTrue(kayitliHesap.loginAccountText.isDisplayed());
        extentTest.info("hesabiniza giris yapin ifadesinin görünür olduğu dogrulandi");
        //6. Doğru e-posta adresini ve şifreyi girin
        //7. 'Giriş' düğmesini tıklayın
        Driver.actions().click(kayitliHesap.loginEmail).sendKeys(ConfigReader.getProperty("usermailAE"))
                .sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("userpassword"))
                .sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        extentTest.info("Hesap bilgileri girilerek giris yapildi");
        //8. 'Kullanıcı adı olarak oturum açıldı' ifadesinin görünür olduğunu doğrulayın
        softAssert.assertTrue(kayitliHesap.kullaniciAdiIleGirisYapildi.isDisplayed());
        extentTest.info("Kullanıcı adı olarak oturum açıldı yazisinin gorunurlugu dogrulandi");
        //9. 'Hesabı Sil' düğmesini tıklayın
        kayitliHesap.deleteAccount.click();
        extentTest.info("hesabi sil butonuna basildi");
        //10. 'HESAP SİL!' görünür
        softAssert.assertTrue(kayitliHesap.deleteAccountNewWindow.isDisplayed());
        extentTest.info("hesabi sil yazisi gorunurlugu dogrulandi");
        softAssert.assertAll();


    }

}
