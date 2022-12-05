package test.exercise;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ProducCartAutomationExercisePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class Case17 {
    ProducCartAutomationExercisePage autoE = new ProducCartAutomationExercisePage();
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void testName() {
        //     1. Tarayıcıyı başlatın
        //     2. 'http://automationexercise.com' url'sine gidin
        Driver.getDriver().get(ConfigReader.getProperty("automationexerciseUrl"));
        //     3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
        softAssert.assertTrue(autoE.anasayfa.isDisplayed(), "anasayfa goruntulenmedi");
        String expectedUrl = "https://www.automationexercise.com/";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(expectedUrl, actualUrl, "anasayfa goruntulenmedi");
        //     4. Sepete ürün ekleyin
        ReusableMethods.jsScroll(autoE.ilkUrunAddCart);
        autoE.ilkUrunAddCart.click();
        //     5. 'Sepet' düğmesini tıklayın
        autoE.viewCartButton.click();
        //     6. Sepet sayfasının görüntülendiğini doğrulayın
        softAssert.assertTrue(autoE.shoppingCartText.isDisplayed());
        //     7. Belirli bir ürüne karşılık gelen 'X' düğmesini tıklayın
        int ilkSize = autoE.cartDeleteButton.size();
        autoE.cartDeleteButton.get(0).click();
        //     8. Ürünün sepetten çıkarıldığını doğrulayın
        ReusableMethods.waitFor(5);
        int sonSize = autoE.cartDeleteButton.size();
        softAssert.assertTrue((ilkSize - 1) == sonSize);
        softAssert.assertAll();
    }
}
