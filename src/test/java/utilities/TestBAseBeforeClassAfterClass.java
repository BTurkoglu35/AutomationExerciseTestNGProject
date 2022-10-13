package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public abstract class TestBAseBeforeClassAfterClass {
    protected  WebDriver driver;
    protected  Actions actions;

    //@BeforeClass ve @AfterClass notasyonlarini kullanirken TestNG de kulllanirken JUnit'teki gibi static yapmaya gerek yoktur.
    @BeforeClass(groups = "gp1")
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @AfterClass(groups = "gp1")
    public   void tearDown() {
        // driver.close();

    }

}
