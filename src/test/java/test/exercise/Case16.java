package test.exercise;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AccountInformationAutomationExercisePage;
import pages.ProducCartAutomationExercisePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class Case16 {
    ProducCartAutomationExercisePage autoE = new ProducCartAutomationExercisePage();
    AccountInformationAutomationExercisePage autoE2 = new AccountInformationAutomationExercisePage();
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void sipraisVer() {
        // 1. Tarayıcıyı başlatın
        // 2. 'http://automationexercise.com' url'sine gidin
        Driver.getDriver().get(ConfigReader.getProperty("automationexerciseUrl"));
        //    3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
        softAssert.assertTrue(autoE.anasayfa.isDisplayed(), "anasayfa goruntulenmedi");
        String expectedUrl = "https://www.automationexercise.com/";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(expectedUrl, actualUrl, "anasayfa goruntulenmedi");
        // 4. 'Kayıt Ol / Giriş Yap' düğmesini tıklayın
        autoE2.signupLogin.click();
        // 5. E-postayı, şifreyi doldurun ve 'Giriş' düğmesini tıklayın
        Driver.actions().click(autoE2.loginEmail).sendKeys(ConfigReader.getProperty("usermailAE"))
                .sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("userpassword"))
                .sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        // 6. En üstte 'Kullanıcı adı olarak oturum açıldı' seçeneğini doğrulayın
        softAssert.assertTrue(autoE2.kullaniciAdiIleGirisYapildi.isDisplayed());
        // 7. Sepete ürün ekleyin
        ReusableMethods.jsScroll(autoE.ilkUrunAddCart);
        autoE.ilkUrunAddCart.click();
        // 8. 'Sepet' düğmesini tıklayın
        autoE.viewCartButton.click();
        // 9. Sepet sayfasının görüntülendiğini doğrulayın
        softAssert.assertTrue(autoE.shoppingCartText.isDisplayed());
        // 10. Ödemeye Devam Et'e tıklayın;
        autoE.proceedToCheckoutButton.click();
        // 11. Adres Ayrıntılarını Doğrulayın ve Siparişinizi İnceleyin
        softAssert.assertTrue(autoE.addressDetailsText.isDisplayed());
        // 12. Açıklama metin alanına açıklama girin ve 'Sipariş Ver'i tıklayın
        ReusableMethods.jsScroll(autoE.commentButton);
        Driver.actions().click(autoE.commentButton).sendKeys("ksdgkw").sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        // 13. Ödeme ayrıntılarını girin: Karttaki Ad, Kart Numarası, CVC, Son Kullanma tarihi
        // 14. 'Öde ve Siparişi Onayla' düğmesine tıklayın
        Driver.actions().click(autoE.nameOnCardButton).sendKeys("master").sendKeys(Keys.TAB)
                .sendKeys("123654789632").sendKeys(Keys.TAB)
                .sendKeys("124").sendKeys(Keys.TAB).sendKeys("454").sendKeys(Keys.TAB).sendKeys("2020").sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        // 15. Başarı mesajını doğrulayın 'Siparişiniz başarıyla verildi!'
        softAssert.assertTrue(autoE.orderPlacedText.isDisplayed());
        softAssert.assertAll();

    }
}
