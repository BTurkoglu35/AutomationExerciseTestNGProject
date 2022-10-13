package test.exercise;


import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BizeUlasinPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseBeforeAfter;

public class Case6 extends TestBaseBeforeAfter {


    @Test
    public void test() throws InterruptedException {
        BizeUlasinPage bizeUlasinPage = new BizeUlasinPage();
        // 1. Tarayıcıyı başlatın
        // 2. 'http://automationexercise.com' url'sine gidin
        Driver.getDriver().get(ConfigReader.getProperty("automationexerciseUrl"));
        // 3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
        String expectedUrl = "https://www.automationexercise.com/";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);
        // 4. 'Bize Ulaşın' düğmesine tıklayın
        bizeUlasinPage.contactUsButon.click();
        // 5. 'GET IN TOUCH'un görünür olduğunu doğrulayın
        Assert.assertTrue(bizeUlasinPage.getInTouchText.isDisplayed());
        // 6. Adı, e-posta adresini, konuyu ve mesajı girin
        bizeUlasinPage.name.sendKeys("lale");
        bizeUlasinPage.email.sendKeys("bjh@gmail.com");
        bizeUlasinPage.subject.sendKeys("selenium");
        bizeUlasinPage.yourMessage.sendKeys("kolay");
        // 7. Dosya yükle
        String farkliKisim = System.getProperty("user.home");
        String ortakKisim = "\\Desktop\\New Microsoft Excel Çalışma Sayfası.xlsx";
        String yuklenecekDosya = farkliKisim + ortakKisim;
        bizeUlasinPage.chooseFile.sendKeys(yuklenecekDosya);
        Thread.sleep(6000);
        // 8. 'Gönder' düğmesini tıklayın
        bizeUlasinPage.submit.click();
        // 9. Tamam düğmesine tıklayın
        Driver.getDriver().switchTo().alert().accept();
        // 10. Başarı mesajını doğrulayın 'Success! Bilgileriniz başarıyla gönderildi.' görünür
        Assert.assertTrue(bizeUlasinPage.successText.isDisplayed());

        // 11. 'Ana Sayfa' düğmesini tıklayın ve ana sayfaya başarıyla indiğini doğrulayın
        bizeUlasinPage.anasayfaButonSuccessFile.click();
        String expectedUrlSon = "https://www.automationexercise.com/";
        String actualUrlSon = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedUrlSon, actualUrlSon);

    }
}