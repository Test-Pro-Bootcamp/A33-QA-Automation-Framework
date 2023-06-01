import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.time.Duration;


public class BaseTest {
    static WebDriver driver;
    static WebDriverWait wait;
    String url;


    public Actions actions = null;


    @BeforeSuite
    public void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser(String BaseURL) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        url = BaseURL;
        driver.manage().window().maximize();
        driver.get(url);
        actions = new Actions(driver);

    }

    @AfterMethod
    public void closeBrowser() {
        LoginTests.driver.quit();
    }


    public void submitButton() {
        WebElement submitButtonElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type ='submit']")));
        submitButtonElement.click();

    }

    public static void provideEmail(String email) {

        WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type ='email']")));
        emailField.sendKeys(email);

    }

    public static void providePassword(String password) {
        WebElement provideField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type ='password']")));
        provideField.sendKeys(password);
    }

    public void findSong() {
        WebElement findSong = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='submit'")));
        findSong.sendKeys();
    }

    public void clickViewAllButton() {
        WebElement clickViewAllButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[data-test='view-all-songs-btn']")));
        clickViewAllButton.click();

    }

    public void selectFirstSong() {
        WebElement selectFirstSong = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("section#songResultsWrapper tr.song-item td.title")));
        selectFirstSong.click();

    }

    public void openPlaylist() {
        WebElement emptyPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".playlist:nth-child(3)")));
        emptyPlaylist.click();
    }

    public void deletePlaylist() throws InterruptedException {
        WebElement deletePlaylistButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn-delete-playlist")));
        deletePlaylistButton.click();
    }

    public String getNotificationMessage() {
        WebElement NotificationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return NotificationMessage.getText();
    }

    public boolean songIsPlaying() {
        WebElement songIsPlaying = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='bars']")));
        return songIsPlaying.isDisplayed();
    }

    public boolean isDeletedPlaylistMsgDisplayed() {
        WebElement deletedPlaylistMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return deletedPlaylistMsg.isDisplayed();

    }

}




