import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;


public class BaseTest {

    public static WebDriver driver = null;
    public static WebDriverWait wait;

    public static Actions actions = null;
    public static By emailField = By.cssSelector("[type='email']");
    public static By passwordField = By.cssSelector("[type='password']");
    public static By submitButton = By.cssSelector("[type='submit']");



    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters({"BaseURL"})
    public static void launchBrowser(String BaseURL) {
        driver = new ChromeDriver();
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(BaseURL);
        driver.manage().window().maximize();
    }

//    @AfterClass
//    public static void closeBrowser(){
//        driver.quit();
//    }

    @Test
    public static void navigateToPage() {
        String url = "https://bbb.testpro.io/";
        driver.get(url);

    }

    public static void provideEmail(String email) {
        WebElement emailElement = wait.until(ExpectedConditions.elementToBeClickable(emailField));
        emailElement.clear();
        emailElement.sendKeys(email);
    }

    public static void providePassword(String password) {
        WebElement passwordElement = wait.until(ExpectedConditions.elementToBeClickable(passwordField));
        passwordElement.click();
        passwordElement.sendKeys(password);
    }

    public static void clickSubmit()  {
        WebElement submitButtonElement = wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        submitButtonElement.click();




    }

}