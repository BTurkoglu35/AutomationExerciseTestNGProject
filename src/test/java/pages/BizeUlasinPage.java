package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class BizeUlasinPage {
    public BizeUlasinPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy (xpath = "//*[@class='fa fa-envelope']")
    public WebElement contactUsButon;

    @FindBy (xpath = "(//h2[@class='title text-center'])[2]")
    public WebElement getInTouchText;

    @FindBy (xpath = "(//*[@class='form-control'])[1]")
    public WebElement name;

    @FindBy (xpath = "(//*[@class='form-control'])[2]")
    public WebElement email;

    @FindBy (xpath = "(//*[@class='form-control'])[3]")
    public WebElement subject;

    @FindBy (xpath = "(//*[@class='form-control'])[4]")
    public WebElement yourMessage;

    @FindBy (xpath = "//input[@type='file']")
    public WebElement chooseFile;

    @FindBy (xpath = "//input[@name='submit']")
    public WebElement submit;

    @FindBy (xpath = "//*[@class='status alert alert-success']")
    public WebElement successText;

    @FindBy (xpath = "//a[@class='btn btn-success']")
    public WebElement anasayfaButonSuccessFile;


}
