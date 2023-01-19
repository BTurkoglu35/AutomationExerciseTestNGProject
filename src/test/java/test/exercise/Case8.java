package test.exercise;

import pages.ProducCartAutomationExercisePage;
import utilities.ConfigReader;
import utilities.Driver;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBaseRapor;


public class Case8 extends TestBaseRapor {
    @Test
    public void test01() throws InterruptedException {
        ProducCartAutomationExercisePage autoE = new ProducCartAutomationExercisePage();
        SoftAssert softAssert = new SoftAssert();
        extentTest = extentReports.createTest("Verify All Products and product detail page", "Verify All Products and product detail page");

        Driver.getDriver().get(ConfigReader.getProperty("automationexerciseUrl"));
        extentTest.info("Goed to url");

        softAssert.assertTrue(autoE.anasayfa.isDisplayed(), "anasayfa goruntulenmedi");
        extentTest.info("Verified that the homepage is successfully visible");

        autoE.products.click();
        extentTest.info("'Products' button clicked");

        Driver.getDriver().switchTo().frame(autoE.iframeProduct);
        autoE.dismisButton.click();
        Driver.getDriver().switchTo().defaultContent();

        softAssert.assertTrue(autoE.allProductsText.isDisplayed(), "tum urunler ssayfasina gidilemedi");
        extentTest.info("Verified that user successfully navigated to ALL PRODUCTS page");

        softAssert.assertTrue(autoE.allProductsListesi.isDisplayed(), "urun listesi goruntulenemedi");
        Thread.sleep(1000);
        extentTest.info("Verified that the product list is visible");

        Driver.actions().sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(1000);
        autoE.viewProductIlkUrun.click();
        extentTest.info("Clicking 'View Product' of the first product");

        softAssert.assertTrue(autoE.ilkUrunIsim.isDisplayed(), "urun isim goruntulenmiyor");
        softAssert.assertTrue(autoE.ilkUrunkategori.isDisplayed(), "urun kategori goruntulenmiyor");
        softAssert.assertTrue(autoE.ilkUrunFiyat.isDisplayed(), "urun fiyat goruntulenmiyor");
        softAssert.assertTrue(autoE.availability.isDisplayed(), "urun stok goruntulenmiyor");
        softAssert.assertTrue(autoE.condition.isDisplayed(), "urun condition goruntulenmiyor");
        softAssert.assertTrue(autoE.brand.isDisplayed(), "urun brand goruntulenmiyor");
        extentTest.info("Verified that details are visible");

        softAssert.assertAll();

        Driver.closeDriver();

    }
}
