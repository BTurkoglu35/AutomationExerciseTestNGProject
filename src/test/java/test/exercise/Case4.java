package test.exercise;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HesapBilgileriAutomationExercisePage;
import utilities.ConfigReader;
import utilities.Driver;


public class Case4 {


    @Test
    public void test1() {
        HesapBilgileriAutomationExercisePage autoE = new HesapBilgileriAutomationExercisePage();
        SoftAssert softAssert = new SoftAssert();
        // 1. Tarayıcıyı başlatın
        // 2. 'http://automationexercise.com' url'sine gidin
        Driver.getDriver().get(ConfigReader.getProperty("automationexerciseUrl"));
        // 3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
        softAssert.assertTrue(autoE.anasayfa.isDisplayed(), "anasayfa goruntulenmedi");
        String expectedUrl = "https://www.automationexercise.com/";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(expectedUrl, actualUrl, "anasayfa goruntulenmedi");

        // 4. 'Kayıt Ol / Giriş Yap' düğmesine tıklayın
        autoE.signupLogin.click();
        // 5. 'Hesabınıza giriş yapın' ifadesinin görünür olduğunu doğrulayın
        softAssert.assertTrue(autoE.loginAccountText.isDisplayed());
        // 6. Doğru e-posta adresini ve şifreyi girin
        // 7. 'Giriş' düğmesini tıklayın
        Driver.actions().click(autoE.loginEmail).sendKeys(ConfigReader.getProperty("usermailAE"))
                .sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("userpassword"))
                .sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();

        // 8. 'Kullanıcı adı olarak oturum açıldı' ifadesinin görünür olduğunu doğrulayın
        softAssert.assertTrue(autoE.kullaniciAdiIleGirisYapildi.isDisplayed());
        // 9. 'Çıkış' düğmesini tıklayın
        autoE.logout.click();
        // 10. Kullanıcının oturum açma sayfasına yönlendirildiğini doğrulayın
        softAssert.assertTrue(autoE.loginAccountText.isDisplayed());

        softAssert.assertAll();

    }

}
