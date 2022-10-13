package test.exercise;

import pages.ProducCartAutomationExercisePage;
import utilities.ConfigReader;
import utilities.Driver;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
;

public class Case8 {
    @Test
    public void test01() throws InterruptedException {
        ProducCartAutomationExercisePage autoE = new ProducCartAutomationExercisePage();
        SoftAssert softAssert = new SoftAssert();
        //   1. Tarayıcıyı başlatın
        //  2. 'http://automationexercise.com' url'sine gidin
        Driver.getDriver().get(ConfigReader.getProperty("automationexerciseUrl"));
        //  3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
        softAssert.assertTrue(autoE.anasayfa.isDisplayed(), "anasayfa goruntulenmedi");
        //  4. 'Ürünler' düğmesine tıklayın
        autoE.products.click();
        //  5. Kullanıcının TÜM ÜRÜNLER sayfasına başarıyla gittiğini doğrulayın
        softAssert.assertTrue(autoE.allProductsText.isDisplayed(), "tum urunler ssayfasina gidilemedi");
        //  6. Ürün listesi görünür
        softAssert.assertTrue(autoE.allProductsListesi.isDisplayed(), "urun listesi goruntulenemedi");
        Thread.sleep(1000);
        //  7. İlk ürünün 'Ürünü Görüntüle'ye tıklayın
        Driver.actions().sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(1000);
        autoE.viewProductIlkUrun.click();
        //  8. Kullanıcı, ürün detay sayfasına yönlendirilir
        //  9. Ayrıntıların görünür olduğunu doğrulayın: ürün adı, kategori, fiyat, bulunabilirlik, durum, marka
        softAssert.assertTrue(autoE.ilkUrunIsim.isDisplayed(), "urun isim goruntulenmiyor");
        softAssert.assertTrue(autoE.ilkUrunkategori.isDisplayed(), "urun kategori goruntulenmiyor");
        softAssert.assertTrue(autoE.ilkUrunFiyat.isDisplayed(), "urun fiyat goruntulenmiyor");
        softAssert.assertTrue(autoE.availability.isDisplayed(), "urun stok goruntulenmiyor");
        softAssert.assertTrue(autoE.condition.isDisplayed(), "urun condition goruntulenmiyor");
        softAssert.assertTrue(autoE.brand.isDisplayed(), "urun brand goruntulenmiyor");
        softAssert.assertAll();


    }
}
