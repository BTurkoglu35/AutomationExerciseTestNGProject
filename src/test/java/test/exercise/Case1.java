package test.exercise;


import pages.HesapBilgileriAutomationExercisePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Case1 extends TestBaseRapor {

    HesapBilgileriAutomationExercisePage autoE;

    @Test
    public void test01() throws InterruptedException {
        extentTest = extentReports.createTest("Hesap olustur ve hesap sil", "Hesap olusturulmali ve  basarili bir sekilde silinmeli");
        autoE = new HesapBilgileriAutomationExercisePage();
        SoftAssert softAssert = new SoftAssert();

        Driver.getDriver().get(ConfigReader.getProperty("automationexerciseUrl"));
        extentTest.info("automationexercise sayfasina giris yapildi");

        softAssert.assertTrue(autoE.anasayfa.isDisplayed(), "anasayfa goruntulenmedi");
        String expectedUrl = "https://www.automationexercise.com/";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(expectedUrl, actualUrl, "anasayfa goruntulenmedi");
        extentTest.info("anasayfa gorunurlugu dogrulandi");

        autoE.signupLogin.click();
        extentTest.info("kayıt Ol / Giriş Yap butonuna basildi");

        softAssert.assertTrue(autoE.newUserLoginText.isDisplayed());
        extentTest.info("Yeni Kullanıcı Kaydı dogrulandi");
        String email = Driver.faker().internet().emailAddress();
        String name = Driver.faker().name().fullName();
        Driver.actions().click(autoE.name).sendKeys(name).sendKeys(Keys.TAB)
                .sendKeys(email).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        extentTest.info("adi ve soyadi bilgileri girildi kaydet tusuna basildi");

        softAssert.assertTrue(autoE.enterAccountInformation.isDisplayed());
        extentTest.info("Hesap bilgilerini girin ifadesi gorunur olduğunu doğrulandi");


        Driver.actions().click(autoE.mrsTitle).sendKeys(Keys.TAB)
                .sendKeys(name).sendKeys(Keys.TAB)
                .sendKeys(Driver.faker().internet().password()).perform();
        Driver.select(autoE.days).selectByValue("4");
        Driver.select(autoE.months).selectByVisibleText("April");
        Driver.select(autoE.years).selectByVisibleText("1993");

        Thread.sleep(2000);
        ReusableMethods.jsScroll(autoE.bultenimizeKaydolun);
        Driver.actions().click(autoE.bultenimizeKaydolun).sendKeys(Keys.TAB).sendKeys(Keys.SPACE).sendKeys(Keys.TAB)
                .sendKeys(Driver.faker().name().firstName()).sendKeys(Keys.TAB).sendKeys(Driver.faker().name().lastName())
                .sendKeys(Keys.TAB).sendKeys("trendyol").sendKeys(Keys.TAB).sendKeys(Driver.faker().address().fullAddress())
                .sendKeys(Keys.TAB).sendKeys(Driver.faker().address().fullAddress()).perform();
        Driver.select(autoE.country).selectByVisibleText("Singapore");

        ReusableMethods.jsScroll(autoE.state);
        Driver.actions().click(autoE.state).sendKeys(Driver.faker().address().state()).sendKeys(Keys.TAB)
                .sendKeys(Driver.faker().address().country()).sendKeys(Keys.TAB).sendKeys(Driver.faker().address().zipCode())
                .sendKeys(Keys.TAB).sendKeys(Driver.faker().phoneNumber().phoneNumber()).sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();
        extentTest.info("Hesap olusturmak icin bilgiler girildi");


        softAssert.assertTrue(autoE.accountCreated.isDisplayed());
        extentTest.info("hesap olusturuldu yazisi gorunurlugu dogrulandi");

        autoE.continueAccountCreated.click();
        extentTest.info("continue butonuna basildi");

        Driver.getDriver().switchTo().frame(autoE.iframeAccount);
        autoE.dismisButton.click();
        Driver.getDriver().switchTo().defaultContent();


        softAssert.assertTrue(autoE.kullaniciAdiIleGirisYapildi.isDisplayed());
        extentTest.info("Kullanıcı adı olarak oturum açıldı dogrulandi");

        autoE.deleteAccount.click();
        extentTest.info("account delete button clicked");

        softAssert.assertTrue(autoE.accountDeleted.isDisplayed());
        extentTest.info("account deleted text visibility verified");
        softAssert.assertAll();


    }
}
