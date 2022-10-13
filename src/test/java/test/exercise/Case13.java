package test.exercise;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ProducCartAutomationExercisePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class Case13 {

    @Test
    public void sepettekiUrunMiktariniDogrulama() {
        ProducCartAutomationExercisePage autoE = new ProducCartAutomationExercisePage();
        SoftAssert softAssert = new SoftAssert();
        //    1. Tarayıcıyı başlatın
        //    2. 'http://automationexercise.com' url'sine gidin
        Driver.getDriver().get(ConfigReader.getProperty("automationexerciseUrl"));
        //    3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
        softAssert.assertTrue(autoE.anasayfa.isDisplayed(), "anasayfa goruntulenmedi");
        String expectedUrl = "https://www.automationexercise.com/";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(expectedUrl, actualUrl, "anasayfa goruntulenmedi");
        //    4. Ana sayfadaki herhangi bir ürün için 'Ürünü Görüntüle'yi tıklayın
        ReusableMethods.jsScroll(autoE.viewProductIlkUrun);
        autoE.viewProductIlkUrun.click();
        //    5. Ürün detayının açıldığını doğrulayın
        softAssert.assertTrue(autoE.ilkUrunkategori.isDisplayed());
        //    6. Miktarı 4'e yükseltin
        autoE.urunSayisiArttirmaButton.clear();
        autoE.urunSayisiArttirmaButton.sendKeys("4");
        //    7. 'Sepete ekle' düğmesini tıklayın
        autoE.viewProductAddCart.click();
        //    8. 'Sepeti Görüntüle' düğmesini tıklayın
        autoE.viewCartButton.click();
        //    9. Ürünün sepet sayfasında tam miktarıyla görüntülendiğini doğrulayın
        softAssert.assertTrue(autoE.sepetQuently.getText().equals("4"));
        softAssert.assertAll();
    }
}
