package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class CategoryAutomationExercisePage {


    public CategoryAutomationExercisePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[text()='Category']")
    public WebElement category;

    @FindBy (xpath = "(//*[@class='badge pull-right'])[1]")
    public WebElement women;

   @FindBy (xpath = "(//*[text()='Dress '])[1]")
    public WebElement womenDress;

   @FindBy (xpath = "//*[@class='title text-center']")
    public WebElement womenDressProductstText;

    @FindBy (xpath = "(//*[@class='badge pull-right'])[2]")
    public WebElement man;

    @FindBy (xpath = "//*[text()='Tshirts ']")
    public WebElement manTshirts;

    @FindBy (xpath = "//*[@class='title text-center']")
    public WebElement manTshirtsProductsText;

    @FindBy(xpath="//*[@href='/products']")
    public WebElement products;

    @FindBy (xpath = "//*[text()='Brands']")
    public WebElement brands;

    @FindBy (xpath = "//*[text()='H&M']")
    public WebElement HM;

    @FindBy (xpath = "//*[@class='title text-center']")
    public WebElement hmProductsText;

    @FindBy (xpath = "//*[text()='Madame']")
    public WebElement madame;

    @FindBy (xpath = "//*[text()='Brand - Madame Products']")
    public WebElement mademeProductsText;

    @FindBy (xpath = "//*[@class='product-image-wrapper']")
    public List<WebElement> productsList;
}
