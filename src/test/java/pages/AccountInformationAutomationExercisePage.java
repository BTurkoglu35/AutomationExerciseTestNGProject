package pages;

import utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountInformationAutomationExercisePage {
    public AccountInformationAutomationExercisePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath="(//html[@lang='en'])")
    public WebElement anasayfa;

    @FindBy(xpath="//*[.=' Signup / Login']")
    public WebElement signupLogin;

    @FindBy(xpath="//*[.='New User Signup!']")
    public WebElement newUserLoginText;

    @FindBy(xpath="//*[.='Login to your account']")
    public WebElement loginAccountText;

    @FindBy (xpath = "//*[@name='name']")
    public WebElement name;

    @FindBy (xpath = "(//*[@name='email'])[1]")
    public WebElement loginEmail;

    @FindBy (xpath = "//*[.='Your email or password is incorrect!']")
    public WebElement negativeLoginText;

    @FindBy (xpath = "//b[.='Enter Account Information']")
    public WebElement enterAccountInformation;

    @FindBy (xpath = "(//*[@class='radio-inline'])[1]")
    public WebElement mrTitle;

    @FindBy (xpath = "(//*[@class='radio-inline'])[2]")
    public WebElement mrsTitle;

    @FindBy (xpath = "//*[@id='days']")
    public WebElement days;

    @FindBy (xpath = "//*[@id='months']")
    public WebElement months;

    @FindBy (xpath = "//*[@id='years']")
    public WebElement years;

    @FindBy (xpath = "(//*[@class='checkbox'])[1]")
    public WebElement bultenimizeKaydolun;

    @FindBy (xpath = "//*[@id='country']")
    public WebElement country;

    @FindBy (xpath = "//*[.='Account Created!']")
    public WebElement accountCreated;

    @FindBy (xpath = "//*[@class='btn btn-primary']")
    public WebElement continueAccountCreated;

    @FindBy (xpath = "//*[@id='state']")
    public WebElement state;

    @FindBy (xpath = "//*[text()=' Logged in as ']")
    public WebElement kullaniciAdiIleGirisYapildi;

    @FindBy (xpath = "//*[@class='fa fa-trash-o']")
    public WebElement deleteAccount;

    @FindBy (xpath = "//h2[@class='title text-center']")
    public WebElement accountDeletedText;

    @FindBy (xpath = "//*[text()='Email Address already exist!']")
    public WebElement ePostaAdresiZatenVarUyarisi;

    @FindBy (xpath = "//*[@class='fa fa-lock']")
    public WebElement logout;

    @FindBy(xpath = "//div[@id='dismiss-button']")
    public WebElement dismisButton;
    //*[@id='dismiss-button']
    @FindBy(xpath = "//iframe[@id='aswift_2']")
    public WebElement iframeAccount;
    //*[@id='ad_iframe']

    @FindBy(xpath = " //*[@id='ad_iframe']")
    public WebElement iframeAccount2;
    ////iframe[@id='aswift_2']
    @FindBy(xpath = "//iframe[@id='aswift_5']")
    public WebElement iframeProduct;



}
