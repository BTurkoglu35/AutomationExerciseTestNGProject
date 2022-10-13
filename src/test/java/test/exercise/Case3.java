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
        // 'http://automationexercise.com' url'sine gidin
        Driver.getDriver().get(ConfigReader.getProperty("automationexerciseUrl"));
        // 3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
        softAssert.assertTrue(autoE.anasayfa.isDisplayed(), "anasayfa goruntulenmedi");
        String expectedUrl = "https://www.automationexercise.com/";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(expectedUrl, actualUrl, "anasayfa goruntulenmedi");
        extentTest.info("anasayfa gorunurlugu dogrulandi");

        //4. 'Kayıt Ol / Giriş Yap' düğmesine tıklayın
        autoE.signupLogin.click();
        extentTest.info("kayıt Ol / Giriş Yap dugmesi tiklandi");
        //5. 'Hesabınıza giriş yapın' ifadesinin görünür olduğunu doğrulayın
        softAssert.assertTrue(autoE.loginAccountText.isDisplayed());
        extentTest.info("hesabiniza girirs yapin yazisinin gorunurlugu dogrulandi");
        //6. Yanlış e-posta adresi ve şifre girin
        //7. 'Giriş' düğmesini tıklayın
        Driver.actions().click(autoE.loginEmail).sendKeys(ConfigReader.getProperty("wrongemail"))
                .sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("wrongPassword"))
                .sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        extentTest.info("yanlis kullanici bilgileri girildi ve giris yap butonuna basildi");
        // 8. 'E-postanız veya şifreniz yanlış!' hatasını doğrulayın. görünür
        softAssert.assertTrue(autoE.negativeLoginText.isDisplayed());
        softAssert.assertAll();
        extentTest.info("E-postanız veya şifreniz yanlış! yazisinin gorunurlugu dogrulandi");

    }
}
