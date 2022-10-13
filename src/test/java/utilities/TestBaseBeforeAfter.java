package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public abstract  class TestBaseBeforeAfter {
    protected WebDriver driver;
    protected static Actions actions;
    protected String tarih;
    //TestNG framework'unda @Before ve @After notasyonlari yerine @BeforeMethod ve @AfterMethod kullanilir
    //Calisma prensibi JUnit'deki Before,After ile aynidir
    @BeforeMethod(groups = "gp1")
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        actions=new Actions(driver);
    }
    @AfterMethod(groups = "gp1")
    public void tearDown() {
       // driver.close();

    }

}
