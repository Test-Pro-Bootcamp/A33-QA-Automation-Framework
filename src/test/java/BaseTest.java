import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;


public class BaseTest {
    public static WebDriver driver = null;
    public static WebDriverWait wait = null;

    @BeforeSuite
    static void setupClass() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterMethod
    public void closeBrowser(){ driver.quit(); }


    public void navigate(String setURL) {
        driver.get(setURL);
    }

    public void provideEmail(String email) {
        WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='email']")));
        emailField.sendKeys(email);
    }
    public void providePassword(String password) {
        WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='password']")));
        passwordField.sendKeys(password);
    }
    public void playNextSong(){
        WebElement playNxtSongBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@data-testid='play-next-btn']")));
        WebElement platNxtBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-testid='play-btn']")));

        playNxtSongBtn.click();
        platNxtBtn.click();
    }
    public void submitLogin() {
        WebElement submitLogin = driver.findElement(By.cssSelector("[type='submit']"));
        submitLogin.click();
    }

    public boolean isSongPlaying() {
        WebElement Equalizer = driver.findElement(By.cssSelector("[data-testid='sound-bar-play']"));
        return Equalizer.isDisplayed();
    }










}
