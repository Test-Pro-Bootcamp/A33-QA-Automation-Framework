import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Parameters;

import java.time.Duration;


public class BaseTest {
    public static WebDriver driver = null;

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters ({"BaseUrl"})
    public void launchBrowser(String BaseUrl) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications","--remote-allow-origins=*", "--incognito","--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(BaseUrl);
    }

    @AfterMethod
    public static void closeDownBrowser() {
        driver.quit();
    }

   /* public void openLoginUrl() {
        String url = "https://bbb.testpro.io/";
        driver.get(url);
    }*/

    public static void provideEmail(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        emailField.click();
        emailField.sendKeys(email);
    }

    public static void enterPassword(String password) {
        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        passwordField.click();
        passwordField.sendKeys(password);
    }

    public static void clickSubmit() throws InterruptedException {
        WebElement loginButton = driver.findElement(By.cssSelector("[type='submit']"));
        loginButton.click();
        Thread.sleep(2000);
    }
    
    public boolean isDisplayedDeletedPlaylist() {
        WebElement playlistIsDeleted = driver.findElement(By.cssSelector("[class='success show']"));
        return playlistIsDeleted.isDisplayed();
    }
}
