package test.exercise;

import pages.ProducCartAutomationExercisePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class Case10 {


    @Test
    public void test01() {
        SoftAssert softAssert = new SoftAssert();
        ProducCartAutomationExercisePage autoE= new ProducCartAutomationExercisePage();
        // 'http://automationexercise.com' url'sine gidin
        Driver.getDriver().get(ConfigReader.getProperty("automationexerciseUrl"));
        // Ana sayfanın başarıyla görünür olduğunu doğrulayın
        softAssert.assertTrue(autoE.anasayfa.isDisplayed(),"anasayfa goruntulenmedi");
        // Altbilgiye ilerleyin
        ReusableMethods.jsScroll(autoE.altBilgi);
        // 'ABONELİK' metnini doğrulayın
        softAssert.assertTrue(autoE.altBilgi.isDisplayed(),"Subscription yazisi gorunur degil");
        // Girişe e-posta adresini girin ve ok düğmesine tıklayın
        Driver.actions().click(autoE.subscriptionEmailBox).sendKeys("ertk@gmail.com",Keys.ENTER).perform();
        // Başarı mesajını doğrulayın 'Başarıyla abone oldunuz!' görünür
        softAssert.assertTrue(autoE.successSucribe.isDisplayed(),"SuccessSucribe yazisi gorunur degil");
        softAssert.assertAll();
    }
}
