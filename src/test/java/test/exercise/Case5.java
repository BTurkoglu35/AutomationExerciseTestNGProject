package test.exercise;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HesapBilgileriAutomationExercisePage;
import utilities.ConfigReader;
import utilities.Driver;



public class Case5 {

    @Test
    public void uniueEmail() {
        HesapBilgileriAutomationExercisePage autoE=new HesapBilgileriAutomationExercisePage();
        SoftAssert softAssert = new SoftAssert();
        //   1. Tarayıcıyı başlatın
        //   2. 'http://automationexercise.com' url'sine gidin
        Driver.getDriver().get(ConfigReader.getProperty("automationexerciseUrl"));
        //   3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
        softAssert.assertTrue(autoE.anasayfa.isDisplayed(), "anasayfa goruntulenmedi");
        String expectedUrl = "https://www.automationexercise.com/";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(expectedUrl, actualUrl, "anasayfa goruntulenmedi");
        //   4. 'Kayıt Ol / Giriş Yap' düğmesine tıklayın
        autoE.signupLogin.click();
        //   5. 'Yeni Kullanıcı Kaydı'nı doğrulayın! görünür
        softAssert.assertTrue(autoE.newUserLoginText.isDisplayed());
        //   6. Adı ve kayıtlı e-posta adresini girin
        //   7. 'Kaydol' düğmesini tıklayın
        Driver.actions().click(autoE.name).sendKeys(ConfigReader.getProperty("username")).sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("usermailAE")).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();

        //   8. 'E-posta Adresi zaten var!' hatasını doğrulayın. görünür
        softAssert.assertTrue(autoE.ePostaAdresiZatenVarUyarisi.isDisplayed());
        softAssert.assertAll();
    }


}
