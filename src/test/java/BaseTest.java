import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.BeforeSuite;
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
    @Parameters({"baseUrl"})
    public static void launchBrowser(String baseUrl) {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        url = baseUrl;
        driver.get(url);
    }
       public static void provideEmail(String email) throws InterruptedException {
        WebElement emailField = driver.findElement(By.cssSelector("[type = 'email']"));
        emailField.click();
        emailField.clear();
        emailField.sendKeys(email);
        Thread.sleep(2000);
    }
    public static void providePassword(String password) throws InterruptedException {
        WebElement passwordField = driver.findElement(By.cssSelector("[type = 'password']"));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys(password);
        Thread.sleep(2000);
    }
    public static void clickSubmit() throws InterruptedException {
        WebElement submitButton = driver.findElement(By.cssSelector("button[type = 'submit']"));
        submitButton.click();
        Thread.sleep(2000);
    }
    public static void login() throws InterruptedException {
        provideEmail("nelena35@yahoo.com");
        providePassword("te$t$tudent");
        clickSubmit();
    }
    public static void clickExistingPlaylist() throws InterruptedException {
        WebElement clickPlaylist = driver.findElement(By.xpath("//a[contains(text(), 'Sleepy Songs')]"));
        clickPlaylist.click();
        Thread.sleep(2000);
    }
    public static void deleteExistingPlaylist() throws InterruptedException {
        WebElement clickXPlaylistButton = driver.findElement(By.cssSelector("button[title='Delete this playlist']"));
        clickXPlaylistButton.click();
        Thread.sleep(2000);
    }
    public static boolean getNotificationMessage(){
        WebElement notificationMessage = driver.findElement(By.cssSelector("div.success.show"));
        return notificationMessage.isDisplayed();
    }
    @AfterMethod
    public static void closeBrowser(){
        driver.quit();
    }

}
