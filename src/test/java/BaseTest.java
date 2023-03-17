import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

import static org.testng.Assert.*;


public class BaseTest {
    WebDriver driver;
    WebDriverWait wait;
    String url;

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
        wait = new WebDriverWait(driver,Duration.ofSeconds(20));

        url = BaseURL;
        driver.manage().window().maximize();
        driver.get(url);


    }



    public void provideEmail() {

        WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type ='email']")));
        emailField.sendKeys("guadalupe.medina@testpro.io");

    }

    public void providePassword() {
        WebElement providePassword = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type ='password']")));
        providePassword.sendKeys("DoingitBig23!");
    }


    public void submitButton(){
        WebElement submitButtonElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type ='submit']")));
        submitButtonElement.click();

    }
    public void findSong(){
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
    public String getNotificationMessage(){
        WebElement NotificationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return NotificationMessage.getText ();
    }
    public boolean songIsPlaying(){
        WebElement songIsPlaying = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='bars']")));
        return songIsPlaying.isDisplayed();
    }
    public boolean isDeletedPlaylistMsgDisplayed() {
        WebElement deletedPlaylistMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return deletedPlaylistMsg.isDisplayed();

    }
    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
}




