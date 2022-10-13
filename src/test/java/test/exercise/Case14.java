package test.exercise;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HesapBilgileriAutomationExercisePage;
import pages.ProducCartAutomationExercisePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class Case14 {
    ProducCartAutomationExercisePage productCartPage = new ProducCartAutomationExercisePage();
    HesapBilgileriAutomationExercisePage hesapBilgileriPage=new HesapBilgileriAutomationExercisePage();
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void siparisVerOdemeYarkenKaydolTest() throws InterruptedException {

        //1. Tarayıcıyı başlatın
        //2. 'http://automationexercise.com' url'sine gidin
        Driver.getDriver().get(ConfigReader.getProperty("automationexerciseUrl"));
        //3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
        softAssert.assertTrue(productCartPage.anasayfa.isDisplayed(), "anasayfa goruntulenmedi");
        String expectedUrl = "https://www.automationexercise.com/";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(expectedUrl, actualUrl, "anasayfa goruntulenmedi");
        //4. Sepete ürün ekleyin
        ReusableMethods.jsScroll(productCartPage.ilkUrunAddCart);
        productCartPage.ilkUrunAddCart.click();
        //5. 'Sepet'(viewCartButton) düğmesini tıklayın
        productCartPage.viewCartButton.click();
        //6. Sepet sayfasının(shoppingCartText) görüntülendiğini doğrulayın
        softAssert.assertTrue(productCartPage.shoppingCartText.isDisplayed());
        //7. Ödemeye Devam Et'(proceedToCheckoutButton) e tıklayın
        productCartPage.proceedToCheckoutButton.click();
        //8. 'Kaydol / Giriş Yap'(registerLoginButton) düğmesine tıklayın
        productCartPage.registerLoginButton.click();
        //9. Kayıt bölümündeki tüm ayrıntıları doldurun ve hesap oluşturun
        String email = Driver.faker().internet().emailAddress();
        String name = Driver.faker().name().fullName();
        Driver.actions().click(hesapBilgileriPage.name).sendKeys(name).sendKeys(Keys.TAB)
                .sendKeys(email).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();

        // Doldurma ayrıntıları: Unvan, Ad, E-posta, Şifre, Doğum tarihi
        Driver.actions().click(hesapBilgileriPage.mrsTitle).sendKeys(Keys.TAB)
                .sendKeys(name).sendKeys(Keys.TAB).sendKeys(email).sendKeys(Keys.TAB)
                .sendKeys(Driver.faker().internet().password()).sendKeys(Keys.TAB).perform();
        Driver.select(hesapBilgileriPage.days).selectByValue("4");
        Driver.select(hesapBilgileriPage.months).selectByVisibleText("April");
        Driver.select(hesapBilgileriPage.years).selectByVisibleText("1993");
        //10. 'Bültenimize kaydolun!' onay kutusunu seçin.
        //11. 'Ortaklarımızdan özel teklifler alın!' onay kutusunu seçin.
        //12. Doldurma ayrıntıları: Ad, Soyadı, Şirket, Adres, Adres2, Ülke, Eyalet, Şehir, Posta Kodu, Cep Numarası
        //13. 'Hesap Oluştur düğmesini' tıklayın
        Thread.sleep(2000);
        Driver.actions().click(hesapBilgileriPage.bultenimizeKaydolun).sendKeys(Keys.TAB).sendKeys(Keys.ENTER)
                .sendKeys(Driver.faker().name().firstName()).sendKeys(Keys.TAB).sendKeys(Driver.faker().name().lastName())
                .sendKeys(Keys.TAB).sendKeys("trendyol").sendKeys(Keys.TAB).sendKeys(Driver.faker().address().fullAddress())
                .sendKeys(Keys.TAB).sendKeys(Driver.faker().address().fullAddress()).sendKeys(Keys.TAB).perform();
        Driver.select(hesapBilgileriPage.country).selectByVisibleText("Singapore");
        Driver.actions().click(hesapBilgileriPage.state).sendKeys(Driver.faker().address().state()).sendKeys(Keys.TAB)
                .sendKeys(Driver.faker().address().country()).sendKeys(Keys.TAB).sendKeys(Driver.faker().address().zipCode())
                .sendKeys(Keys.TAB).sendKeys(Driver.faker().phoneNumber().phoneNumber()).sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();

        //10. 'HESAP OLUŞTURULDU!' seçeneğini doğrulayın. ve 'Devam' düğmesini tıklayın
        softAssert.assertTrue(hesapBilgileriPage.accountCreated.isDisplayed());
        hesapBilgileriPage.continueAccountCreated.click();
        //11. En üstte 'Kullanıcı adı olarak oturum açıldı' seçeneğini doğrulayın
        softAssert.assertTrue(hesapBilgileriPage.kullaniciAdiIleGirisYapildi.isDisplayed());
        //12.'Sepet' düğmesini tıklayın
        //13. 'Ödemeye Devam Et' düğmesini tıklayın
        //14. Adres Ayrıntılarını Doğrulayın ve Siparişinizi İnceleyin
        //15. Yorum metni alanına açıklama girin ve 'Sipariş Ver'i tıklayın
        //16. Ödeme ayrıntılarını girin: Karttaki Ad, Kart Numarası, CVC, Son Kullanma tarihi
        //17. 'Öde ve Siparişi Onayla' düğmesine tıklayın
        //18. Başarı mesajını doğrulayın 'Siparişiniz başarıyla verildi!'
        //19. 'Hesabı Sil' düğmesini tıklayın
        //20. 'HESAP SİLİNDİ!' seçeneğini doğrulayın. ve 'Devam' düğmesini tıklayın

    }
}
