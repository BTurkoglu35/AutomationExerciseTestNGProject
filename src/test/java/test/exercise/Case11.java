package test.exercise;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProducCartAutomationExercisePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class Case11 {
    ProducCartAutomationExercisePage autoE;

    @Test
    public void sepetSayfasindaAbonelikDogrulama() {
        autoE = new ProducCartAutomationExercisePage();
        // 1. Tarayıcıyı başlatın
        // 2. 'http://automationexercise.com' url'sine gidin
        Driver.getDriver().get(ConfigReader.getProperty("automationexerciseUrl"));
        // 3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
        String actuaUrl = Driver.getDriver().getCurrentUrl();
        String expectedUrl = "https://www.automationexercise.com/";
        Assert.assertEquals(expectedUrl, actuaUrl);
        // 4. 'Sepet' düğmesini tıklayın
        autoE.cart.click();
        // 5. Altbilgiye ilerleyin
        ReusableMethods.jsScroll(autoE.altBilgi);
        // 6. 'ABONELİK' metnini doğrulayın
        Assert.assertTrue(autoE.altBilgi.isDisplayed());
        // 7. Girişe e-posta adresini girin ve ok düğmesine tıklayın
        autoE.subscriptionEmailBox.sendKeys("test@gmail.com", Keys.ENTER);
        // 8. Başarı mesajını doğrulayın 'Başarıyla abone oldunuz!' görünür
        Assert.assertTrue(autoE.successSucribe.isDisplayed());
    }
}
