import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;


public class BaseTest {
    public static WebDriver driver = null;
    public static String url = "https://bbb.testpro.io/";

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    public static void launchBrowser() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }
    public static void openLoginUrl() throws InterruptedException {
        String url = "https://bbb.testpro.io/";
        driver.get(url);
        Thread.sleep(2000);
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
    public static void accessMediaPlayerControls() throws InterruptedException {
        WebElement clickPlayNextSongControl = driver.findElement(By.cssSelector("i[title='Play next song']"));
        clickPlayNextSongControl.click();
        Thread.sleep(4000);
        WebElement clickPlayButton = driver.findElement(By.cssSelector("span[title='Play or resume']"));
        clickPlayButton.click();
        Thread.sleep(9000);
        Actions actions = new Actions(driver);
        actions.click(clickPlayButton).perform();
        Thread.sleep(3000);
    }
    public static boolean playingSongIsDisplayed(){
        WebElement songIsPlaying = driver.findElement(By.xpath("//progress[@class='plyr__progress--played']"));
        return songIsPlaying.isDisplayed();
    }
    @AfterMethod
    public static void closeBrowser(){
        driver.quit();
    }

}
