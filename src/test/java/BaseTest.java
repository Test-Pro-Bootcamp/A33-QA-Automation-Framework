import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver = null;
    public static String url = null;
    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    @Parameters({"BaseURL"})
    public static void openBrowser(String BaseURL) {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        url = BaseURL;
        driver.get(url);
    }
    public static void enterEmail(String email) throws InterruptedException {
        WebElement emailField = driver.findElement(By.cssSelector("[type = 'email']"));
        emailField.click();
        emailField.clear();
        emailField.sendKeys(email);
        Thread.sleep(2000);
    }
    public static void enterPassword(String password) throws InterruptedException {
        WebElement passwordField = driver.findElement(By.cssSelector("[type = 'password']"));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys(password);
        Thread.sleep(2000);
    }
    public static void clickSubmit() throws InterruptedException {
        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitButton.click();
        Thread.sleep(2000);
    }
    public static void selectEmptyPlaylist() throws InterruptedException {
//        created playlist 'Piano Music' and 'Pi'
        WebElement selectPlaylist = driver.findElement(By.xpath("//*[@id='playlists']/ul/li[3]/a"));
        selectPlaylist.click();
        Thread.sleep(2000);
    }
    public static void deletePlaylist() throws InterruptedException {
        WebElement deletePlaylistbutton = driver.findElement(By.cssSelector("[class='del btn-delete-playlist']"));
        deletePlaylistbutton.click();
        Thread.sleep(2000);
    }
    public static boolean getDeletePlaylistMessage() {
        WebElement deletePlaylistMessage = driver.findElement(By.cssSelector("div.success.show"));
        return deletePlaylistMessage.isDisplayed();
    }
    @AfterMethod
    public static void closeBrowser() {
        driver.quit();
    }
}