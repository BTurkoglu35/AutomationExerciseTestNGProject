package test.exercise;


import pages.ProducCartAutomationExercisePage;
import utilities.ConfigReader;
import utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Case7 {

    ProducCartAutomationExercisePage autoE;

    @Test
    public void test1() {
        autoE = new ProducCartAutomationExercisePage();
        //     2. 'http://automationexercise.com' url'sine gidin
        Driver.getDriver().get(ConfigReader.getProperty("automationexerciseUrl"));
        //     3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
        String expectedUrl = "https://www.automationexercise.com/";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);
        //     4. 'Test Vakaları' düğmesine tıklayın
        autoE.testCases.click();
        //     5. Kullanıcının test senaryoları sayfasına başarıyla yönlendirildiğini doğrulayın
        Assert.assertTrue(autoE.testCasesTitle.isDisplayed());

    }
}
