package pages;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.time.Duration;

import static pages.LoginPage.*;


public class BasePage {


    public static WebDriver driver = null;


    public static String url = null;

    String playlistName = ":)";

    public BasePage(WebDriver givenDriver) {
        driver = givenDriver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Actions actions = new Actions(driver);
    }


    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();

    }

    @BeforeMethod

    @Parameters({"BaseURL"})


    public void launchBrowser(String BaseURL) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        url = BaseURL;
        driver.get(url);


    }

    public void logIn() {
        provideEmail("janezelenova@gmail.com");
        providePassword("Floridaliving2023$");

        //AND user clicks a submit button

        clickSubmit();
    }


    @AfterMethod
    public static void closeBrowser() {
        driver.quit();
    }
}
