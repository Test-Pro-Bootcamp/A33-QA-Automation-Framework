import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver = null;
   WebDriverWait wait;
    public static String url = null;

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    @Parameters({"BaseURL"})
    public void openBrowser(String BaseURL) {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        driver.manage().window().maximize();
        url = BaseURL;
        driver.get(url);
    }
    public void provideEmail(String email) {
        WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='email']")));
        emailField.sendKeys(email);
    }
    public void providePassword(String password) {
        WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='password']")));
        passwordField.sendKeys(password);
    }
    public void submit () {
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit'")));
        submitButton.click();
    }
    public void findSong(String songName) {
        WebElement findSong = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='search']")));
       findSong.sendKeys(songName);
    }
    public void clickViewAllButton() {
        WebElement clickViewAllButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[data-test='view-all-songs-btn']")));
        clickViewAllButton.click();
    }
    public void selectFirstSong() {
        WebElement firstSong = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("section#songResultsWrapper tr.song-item td.title")));
        firstSong.click();
    }
    public void clickAddToButton() {
        WebElement clickAddToButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class = 'btn-add-to']")));
        clickAddToButton.click();
    }
    public void selectPlaylist() {
//        created playlists Piano Music and Pi
        WebElement selectPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(), 'Piano Music')]")));
        selectPlaylist.click();
    }
    public void usePlayerControls() {
        WebElement playNext = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[data-testid='play-next-btn']")));
        playNext.click();
        WebElement clickPlayButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("span[class='play']")));
        clickPlayButton.click();
    }
    public void selectEmptyPlaylist() {
//        created playlist 'Piano Music' and 'Pi'
        WebElement selectEmptyPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='playlists']/ul/li[3]/a")));
        selectEmptyPlaylist.click();
    }
    public void deletePlaylist() {
        WebElement deletePlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class='del btn-delete-playlist']")));
        deletePlaylist.click();
    }
    public String getNotificationMessage() {
        WebElement notificationMessage = new WebDriverWait(driver, Duration.ofSeconds(4)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notificationMessage.getText();
}
    public static boolean songIsPlaying() {
        WebElement songIsPlaying = driver.findElement(By.cssSelector("div[class='bars']"));
        return songIsPlaying.isDisplayed();
    }
    public static boolean getDeletePlaylistMessage() {
        WebElement deletePlaylistMessage = new WebDriverWait(driver, Duration.ofSeconds(4)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return deletePlaylistMessage.isDisplayed();
    }
    @AfterMethod
    public static void closeBrowser() {
        driver.quit();
    }
}
