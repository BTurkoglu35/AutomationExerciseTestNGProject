package test.exercise;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ProducCartAutomationExercisePage;
import utilities.ConfigReader;
import utilities.Driver;

public class Case16 {
    ProducCartAutomationExercisePage autoE= new ProducCartAutomationExercisePage();
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

        // 5. E-postayı, şifreyi doldurun ve 'Giriş' düğmesini tıklayın
        // 6. En üstte 'Kullanıcı adı olarak oturum açıldı' seçeneğini doğrulayın
        // 7. Sepete ürün ekleyin
        // 8. 'Sepet' düğmesini tıklayın
        // 9. Sepet sayfasının görüntülendiğini doğrulayın
        // 10. Ödemeye Devam Et'e tıklayın
        // 11. Adres Ayrıntılarını Doğrulayın ve Siparişinizi İnceleyin
        // 12. Açıklama metin alanına açıklama girin ve 'Sipariş Ver'i tıklayın
        // 13. Ödeme ayrıntılarını girin: Karttaki Ad, Kart Numarası, CVC, Son Kullanma tarihi
        // 14. 'Öde ve Siparişi Onayla' düğmesine tıklayın
        // 15. Başarı mesajını doğrulayın 'Siparişiniz başarıyla verildi!'
        // 16. 'Hesabı Sil' düğmesini tıklayın
        // 17. 'HESAP SİLİNDİ!' seçeneğini doğrulayın. ve 'Devam' düğmesini tıklayın

    }
}
