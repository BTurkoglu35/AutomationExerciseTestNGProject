package test.exercise;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CategoryAutomationExercisePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class Case18 {
    CategoryAutomationExercisePage categoryPage = new CategoryAutomationExercisePage();

    @Test
    public void test01() {
        //    1. Tarayıcıyı başlatın
        //    2. 'http://automationexercise.com' url'sine gidin
        Driver.getDriver().get(ConfigReader.getProperty("automationexerciseUrl"));
        //    3. Sol taraftaki çubukta kategorilerin görünür olduğunu doğrulayın
        assert categoryPage.category.isDisplayed();
        //    4. 'Kadınlar' kategorisine tıklayın
        ReusableMethods.jsScroll(categoryPage.category);
        categoryPage.women.click();
        //    5. 'Kadınlar' kategorisi altındaki herhangi bir kategori bağlantısına tıklayın, örneğin: Elbise
        categoryPage.womenDress.click();
        //    6. Kategori sayfasının görüntülendiğini doğrulayın ve 'KADIN - ÜST ÜRÜNLER' metnini onaylayın
        categoryPage.womenDressProductstText.isDisplayed();
        //    7. Sol taraftaki çubukta, 'Erkekler' kategorisinin herhangi bir alt kategori bağlantısına tıklayın
        categoryPage.men.click();
        categoryPage.menTshirts.click();
        //    8. Kullanıcının o kategori sayfasına yönlendirildiğini doğrulayın
        Assert.assertTrue(categoryPage.menTshirtsProductsText.isDisplayed());
    }
}
