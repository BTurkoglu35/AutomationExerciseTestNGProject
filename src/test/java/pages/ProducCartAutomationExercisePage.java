package pages;

import utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProducCartAutomationExercisePage extends HesapBilgileriAutomationExercisePage {
    public ProducCartAutomationExercisePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "(//html[@lang='en'])")
    public WebElement anasayfa;

    @FindBy(xpath = "//*[@href='/products']")
    public WebElement products;

    @FindBy(xpath = "//*[text()='All Products']")
    public WebElement allProductsText;

    @FindBy(xpath = "//*[@class='col-sm-9 padding-right']")
    public WebElement allProductsListesi;

    @FindBy(xpath = "(//*[text()='View Product'])[1]")
    public WebElement viewProductIlkUrun;

    @FindBy(xpath = "//*[text()='Category: Women > Tops']")
    public WebElement ilkUrunkategori;

    @FindBy(xpath = "//*[text()='Rs. 500']")
    public WebElement ilkUrunFiyat;

    @FindBy(xpath = "//*[text()='Availability:']")
    public WebElement availability;

    @FindBy(xpath = "//*[text()='Condition:']")
    public WebElement condition;

    @FindBy(xpath = "//*[text()='Brand:']")
    public WebElement brand;

    @FindBy(xpath = "//*[@id='search_product']")
    public WebElement urunAramaKutusu;

    @FindBy(xpath = "//*[@id='submit_search']")
    public WebElement aramaKutusuClick;

    @FindBy(css = ".title.text-center")
    public WebElement searchedProducts;

    @FindBy(xpath = "//*[text()='Get the most recent updates from ']")
    public WebElement altBilgi;


    @FindBy(id = "susbscribe_email")
    public WebElement subscriptionEmailBox;

    @FindBy(id = "success-subscribe")
    public WebElement successSucribe;

    @FindBy(xpath = "//*[@src='/get_product_picture/1']")
    public WebElement searchProductBlueTop;

    @FindBy(xpath = "(//i[@class='fa fa-list'])[1]")
    public WebElement testCases;

    @FindBy(xpath = "//*[@class='title text-center']")
    public WebElement testCasesTitle;

    @FindBy(xpath = "(//a[@href='/view_cart'])[1]")
    public WebElement cart;

    @FindBy(xpath = "(//*[@class='btn btn-default add-to-cart'])[1]")
    public WebElement ilkUrunAddCart;

    @FindBy(xpath = "//*[.='Continue Shopping']")
    public WebElement continueShoppingButton;

    @FindBy(xpath = "(//*[@class='btn btn-default add-to-cart'])[3]")
    public WebElement ikinciUrunAddCart;

    @FindBy(xpath = "//*[text()='View Cart']")
    public WebElement viewCartButton;

    @FindBy(xpath = "//*[text()='Blue Top']")
    public WebElement ilkUrunIsim;

    @FindBy(xpath = "//*[text()='Men Tshirt']")
    public WebElement ikinciUrunIsim;

    @FindBy(xpath = "//*[@id='quantity']")
    public WebElement urunSayisiArttirmaButton;

    @FindBy(xpath = "//*[@class='btn btn-default cart']")
    public WebElement viewProductAddCart;

    @FindBy(xpath = "//*[@class='disabled']")
    public WebElement sepetQuently;

    @FindBy(xpath = "//*[text()='Shopping Cart']")
    public WebElement shoppingCartText;

    @FindBy(xpath = "//*[text()='Proceed To Checkout']")
    public WebElement proceedToCheckoutButton;


    @FindBy(xpath = "//*[text()='Register / Login']")
    public WebElement registerLoginButton;

    @FindBy(xpath = "//*[text()='Address Details']")
    public WebElement addressDetailsText;

    @FindBy(xpath = "//*[@class='form-control']")
    public WebElement commentButton;

    @FindBy(xpath = "//*[@class='form-control']")
    public WebElement nameOnCardButton;

    @FindBy(xpath = "//*[text()='Congratulations! Your order has been confirmed!']")
    public WebElement orderPlacedText;

    @FindBy(xpath = "//*[@class='cart_quantity_delete']")
    public List<WebElement> cartDeleteButton;

    @FindBy(xpath = "//*[@id='search_product']")
    public WebElement searchProductBox;

    @FindBy(xpath = "//*[text()='Searched Products']")
    public WebElement searchProductsText;

    @FindBy(xpath = "//*[@class='productinfo text-center']")
    public List<WebElement> searchProductsList;


    @FindBy(xpath = "//*[text()='Add to cart']")
    public List<WebElement> addCartList;

    @FindBy(xpath = "//*[@class='cart_description']")
    public List<WebElement> cartList;

    @FindBy(xpath = "//*[@class='active']")
    public WebElement writeYourReview;


    @FindBy(xpath = "//*[@id='name']")
    public WebElement reviewNameButton;

    @FindBy(xpath = "(//*[@class='alert-success alert'])[1]")
    public WebElement thankYouReviewText;

    @FindBy(xpath = "//*[text()='recommended items']")
    public WebElement recommendedItemsText;

    @FindBy(xpath = "//a[@class='btn btn-default add-to-cart']")
    public List<WebElement> addCart;

    @FindBy(xpath = "//tbody//tr[1]")
    public WebElement cartTableBodyRowOne;

    @FindBy(id="address_delivery")
    public WebElement deliveryAdress;

    @FindBy(id="address_invoice")
    public WebElement billingAdress;





}