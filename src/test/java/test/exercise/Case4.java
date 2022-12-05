package test.exercise;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HesapBilgileriAutomationExercisePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;


public class Case4 extends TestBaseRapor {


    @Test
    public void test1() {

        HesapBilgileriAutomationExercisePage autoE = new HesapBilgileriAutomationExercisePage();
        SoftAssert softAssert = new SoftAssert();
        extentTest = extentReports.createTest("Logout", "Logout User");

        Driver.getDriver().get(ConfigReader.getProperty("automationexerciseUrl"));
        extentTest.info("Goed to url");

        softAssert.assertTrue(autoE.anasayfa.isDisplayed(), "anasayfa goruntulenmedi");
        String expectedUrl = "https://www.automationexercise.com/";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(expectedUrl, actualUrl, "anasayfa goruntulenmedi");
        extentTest.info("Verified that the homepage is successfully visible");


        autoE.signupLogin.click();
        extentTest.info("Clicked the 'Register / Login' button");

        softAssert.assertTrue(autoE.loginAccountText.isDisplayed());
        extentTest.info("Verified that 'Sign in to your account' is visible");

        Driver.actions().click(autoE.loginEmail).sendKeys(ConfigReader.getProperty("usermailAE"))
                .sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("userpassword"))
                .sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        extentTest.info("Correct email address and password entered,'Login' button clicked");

        softAssert.assertTrue(autoE.kullaniciAdiIleGirisYapildi.isDisplayed());
        extentTest.info("Kullanıcı adı olarak oturum açıldı' ifadesinin görünür olduğu doğrulandi");

        autoE.logout.click();
        extentTest.info("Clicked the 'Exit' button");

        softAssert.assertTrue(autoE.loginAccountText.isDisplayed());
        extentTest.info("Verified that the user was redirected to the login page");

        softAssert.assertAll();

    }

}
