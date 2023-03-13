import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.time.Duration;


public class BaseTest {

    public static WebDriver driver;
    public static WebDriverWait wait;



    @BeforeSuite
    @Parameters({"BaseURL"})
    public static void setupClass(String BaseURL) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
       // String baseURL = "https://bbb.testpro.io/";
        String url = BaseURL;
        driver.get(url);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterMethod
    static void close() { driver.quit();}

    public static void login(String email, String password){
        WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='email']")));
        emailField.sendKeys(email);
        WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='password']")));
        passwordField.sendKeys(password);
        WebElement submitBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='submit']")));
        submitBtn.click();
    }

    public void playlistRemoval(String playlistName) throws InterruptedException {
        WebElement playlistlink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[containts(text() = ' " + playlistName + "')]")));
        playlistlink.click();

    }

}
