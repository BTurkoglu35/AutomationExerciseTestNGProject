package test.exercise;


import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BizeUlasinPage;
import utilities.*;

public class Case6 extends TestBaseRapor {


    @Test
    public void test() throws InterruptedException {
        BizeUlasinPage bizeUlasinPage = new BizeUlasinPage();
        extentTest = extentReports.createTest("Contact Us Form", "Contact Us Form");

        Driver.getDriver().get(ConfigReader.getProperty("automationexerciseUrl"));
        extentTest.info("Goed to url");


        String expectedUrl = "https://www.automationexercise.com/";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);
        extentTest.info("Verified that the homepage is successfully visible");


        bizeUlasinPage.contactUsButon.click();
        extentTest.info("Contact Us' button clicked");

        Assert.assertTrue(bizeUlasinPage.getInTouchText.isDisplayed());
        extentTest.info("Confirmed that 'GET IN TOUCH' is visible");


        bizeUlasinPage.name.sendKeys("lale");
        bizeUlasinPage.email.sendKeys("bjh@gmail.com");
        bizeUlasinPage.subject.sendKeys("selenium");
        bizeUlasinPage.yourMessage.sendKeys("kolay");
        extentTest.info("Name, email address, subject and message entered");

        String farkliKisim = System.getProperty("user.home");
        String ortakKisim = "\\Desktop\\New Microsoft Excel Çalışma Sayfası.xlsx";
        String yuklenecekDosya = farkliKisim + ortakKisim;
        bizeUlasinPage.chooseFile.sendKeys(yuklenecekDosya);
        ReusableMethods.waitFor(5);
        extentTest.info("File uploaded");

        bizeUlasinPage.submit.click();
        extentTest.info("'Submit' button clicked");

        Driver.getDriver().switchTo().alert().accept();
        extentTest.info("OK button clicked");

        Assert.assertTrue(bizeUlasinPage.successText.isDisplayed());
        extentTest.info("Success! Your information has been sent successfully.' Confirmed that your message is visible");


        bizeUlasinPage.anasayfaButonSuccessFile.click();
        String expectedUrlSon = "https://www.automationexercise.com/";
        String actualUrlSon = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedUrlSon, actualUrlSon);
        extentTest.info("The 'Home' button has been clicked and it has been verified that it has successfully landed on the homepage");

    }
}