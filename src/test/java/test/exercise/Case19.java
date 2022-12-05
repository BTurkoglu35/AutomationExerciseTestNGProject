package test.exercise;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.CategoryAutomationExercisePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class Case19 {
    CategoryAutomationExercisePage category = new CategoryAutomationExercisePage();

    @Test
    public void test01() {
        //   1. Tarayıcıyı başlatın
        //   2. 'http://automationexercise.com' url'sine gidin
        Driver.getDriver().get(ConfigReader.getProperty("automationexerciseUrl"));
        //   3. 'Ürünler' düğmesine tıklayın
        category.products.click();
        //   4. Markaların sol taraftaki çubukta göründüğünü doğrulayın
        ReusableMethods.jsScroll(category.brands);
        assert category.brands.isDisplayed();
        //   5. Herhangi bir marka adına tıklayın
        category.HM.click();
        //   6. Kullanıcının marka sayfasına yönlendirildiğini ve marka ürünlerinin görüntülendiğini doğrulayın
        assert category.hmProductsText.isDisplayed();
        for (WebElement each:category.productsList) {
            assert each.isDisplayed();
        }
        //   7. Sol taraftaki çubukta başka bir marka bağlantısına tıklayın
        ReusableMethods.jsScroll(category.madame);
        category.madame.click();
        //   8. Kullanıcının o marka sayfasına gittiğini ve ürünleri görebildiğini doğrulayın
        assert category.mademeProductsText.isDisplayed();
        for (WebElement each:category.productsList) {
            assert each.isDisplayed();
        }
    }
}
