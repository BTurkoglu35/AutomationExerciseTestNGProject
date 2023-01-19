package test.exercise;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ProducCartAutomationExercisePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class Case12 {
    @Test
    public void SepeteUrunEklemeTest() {
        SoftAssert softAssert = new SoftAssert();
        ProducCartAutomationExercisePage autoE= new ProducCartAutomationExercisePage();
        Driver.getDriver().get(ConfigReader.getProperty("automationexerciseUrl"));
        // 3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
        softAssert.assertTrue(autoE.anasayfa.isDisplayed(), "anasayfa goruntulenmedi");
        String expectedUrl = "https://www.automationexercise.com/";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(expectedUrl, actualUrl, "anasayfa goruntulenmedi");
        //   4. 'Ürünler' düğmesini tıklayın
        autoE.products.click();
        //   5. İlk ürünün üzerine gelin ve 'Sepete ekle'yi tıklayın
        ReusableMethods.jsScroll(autoE.ilkUrunIsim);
       Driver.actions().moveToElement(autoE.ilkUrunIsim).click(autoE.ilkUrunAddCart).perform();
        //   6. 'Alışverişe Devam Et' düğmesini tıklayın
        autoE.continueShoppingButton.click();
        //   7. Fareyi ikinci ürünün üzerine getirin ve 'Sepete ekle'yi tıklayın
        Driver.actions().moveToElement(autoE.ikinciUrunIsim).click(autoE.ikinciUrunAddCart).perform();
        //   8. 'Sepeti Görüntüle' düğmesini tıklayın
        autoE.viewCartButton.click();
        //   9. Her iki ürünün de Sepete eklendiğini doğrulayın
        softAssert.assertTrue(autoE.ilkUrunIsim.isDisplayed());
        softAssert.assertTrue(autoE.ikinciUrunIsim.isDisplayed());
        //   10. Fiyatlarını, miktarını ve toplam fiyatını doğrulayın



    }
}
