package test.exercise;


import pages.HesapBilgileriAutomationExercisePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Case1 extends TestBaseRapor {

    HesapBilgileriAutomationExercisePage autoE;

    @Test
    public void test01() throws InterruptedException {
        extentTest = extentReports.createTest("Hesap olustur ve hesap sil", "Hesap olusturulmali ve  basarili bir sekilde silinmeli");
        autoE = new HesapBilgileriAutomationExercisePage();
        SoftAssert softAssert = new SoftAssert();
        // 1. Tarayıcıyı başlatın
        //2. 'http://automationexercise.com' url'sine gidin
        Driver.getDriver().get(ConfigReader.getProperty("automationexerciseUrl"));
        extentTest.info("automationexercise sayfasina giris yapildi");
        //3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
        softAssert.assertTrue(autoE.anasayfa.isDisplayed(), "anasayfa goruntulenmedi");
        String expectedUrl = "https://www.automationexercise.com/";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(expectedUrl, actualUrl, "anasayfa goruntulenmedi");
        extentTest.info("anasayfa gorunurlugu dogrulandi");
        //4. 'Kayıt Ol / Giriş Yap' düğmesine tıklayın
        autoE.signupLogin.click();
        extentTest.info("kayıt Ol / Giriş Yap butonuna basildi");
        //5. 'Yeni Kullanıcı Kaydı'nı doğrulayın! görünür
        softAssert.assertTrue(autoE.newUserLoginText.isDisplayed());
        extentTest.info("Yeni Kullanıcı Kaydı dogrulandi");
        //6. Adı ve e-posta adresini girin
        //7. 'Kaydol' düğmesini tıklayın
        String email = Driver.faker().internet().emailAddress();
        String name = Driver.faker().name().fullName();
        Driver.actions().click(autoE.name).sendKeys(name).sendKeys(Keys.TAB)
                .sendKeys(email).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        extentTest.info("adi ve soyadi bilgileri girildi kaydet tusuna basildi");
        //8. 'HESAP BİLGİLERİNİ GİRİN' ifadesinin görünür olduğunu doğrulayın
        softAssert.assertTrue(autoE.enterAccountInformation.isDisplayed());
        extentTest.info("Hesap bilgilerini girin ifadesi gorunur olduğunu doğrulandi");
        //9. Doldurma ayrıntıları: Unvan, Ad, E-posta, Şifre, Doğum tarihi
        Driver.actions().click(autoE.mrsTitle).sendKeys(Keys.TAB)
                .sendKeys(name).sendKeys(Keys.TAB).sendKeys(email).sendKeys(Keys.TAB)
                .sendKeys(Driver.faker().internet().password()).perform();
        Driver.select(autoE.days).selectByValue("4");
        Driver.select(autoE.months).selectByVisibleText("April");
        Driver.select(autoE.years).selectByVisibleText("1993");
        //10. 'Bültenimize kaydolun!' onay kutusunu seçin.
        //11. 'Ortaklarımızdan özel teklifler alın!' onay kutusunu seçin.
        //12. Doldurma ayrıntıları: Ad, Soyadı, Şirket, Adres, Adres2, Ülke, Eyalet, Şehir, Posta Kodu, Cep Numarası
        //13. 'Hesap Oluştur düğmesini' tıklayın
        Thread.sleep(2000);
        Driver.actions().click(autoE.bultenimizeKaydolun).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).sendKeys(Keys.TAB)
                .sendKeys(Driver.faker().name().firstName()).sendKeys(Keys.TAB).sendKeys(Driver.faker().name().lastName())
                .sendKeys(Keys.TAB).sendKeys("trendyol").sendKeys(Keys.TAB).sendKeys(Driver.faker().address().fullAddress())
                .sendKeys(Keys.TAB).sendKeys(Driver.faker().address().fullAddress()).perform();
        Driver.select(autoE.country).selectByVisibleText("Singapore");
        Driver.actions().click(autoE.state).sendKeys(Driver.faker().address().state()).sendKeys(Keys.TAB)
                .sendKeys(Driver.faker().address().country()).sendKeys(Keys.TAB).sendKeys(Driver.faker().address().zipCode())
                .sendKeys(Keys.TAB).sendKeys(Driver.faker().phoneNumber().phoneNumber()).sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();
        extentTest.info("Hesap olusturmak icin bilgiler girildi");
        //14. 'HESAP OLUŞTURULDU!' görünür
        softAssert.assertTrue(autoE.accountCreated.isDisplayed());
        extentTest.info("hesap olusturuldu yazisi gorunurlugu dogrulandi");
        //15. 'Devam' düğmesini tıklayın
        autoE.continueAccountCreated.click();
        extentTest.info("continue butonuna basildi");
        //16. 'Kullanıcı adı olarak oturum açıldı' ifadesinin görünür olduğunu doğrulayın
        softAssert.assertTrue(autoE.kullaniciAdiIleGirisYapildi.isDisplayed());
        extentTest.info("Kullanıcı adı olarak oturum açıldı dogrulandi");
        //17. 'Hesabı Sil' düğmesini tıklayın
        autoE.deleteAccount.click();
        extentTest.info("hesabi sil butonuna basildi");
        //18. 'HESAP SİL!' görünür
        softAssert.assertTrue(autoE.deleteAccountNewWindow.isDisplayed());
        extentTest.info("hesabi sil yazisi gorunurlugu dogrulandi");
        softAssert.assertAll();


    }
}
