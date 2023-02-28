import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.time.Duration;


public class BaseTest {
     WebDriver driver;
    String currentUrl = "";
    String koelStart = "https://bbb.testpro.io/";
    String koelHome = "https://bbb.testpro.io/#!/home";
    String koelSongs = "https://bbb.testpro.io/#!/songs";
    String koelRecentlyPlayed = "https://bbb.testpro.io/#!/recently-played";


    @BeforeSuite
    public void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setupBrowser() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
    }

    @AfterMethod
    public void exitBrowser() {
        driver.quit();
    }

    public void openLoginURL() {
        driver.get(koelStart);
    }

    public void openAllSongs() {
        driver.get(koelSongs);
    }

    public void inputEmail(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.sendKeys(email);
    }

    public void inputPassword(String pass) {
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.sendKeys(pass);
    }

    public void clickLogin() {
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();
    }

    public void loginValidAccount(String email, String password) {
        openLoginURL();
        inputEmail(email);
        inputPassword(password);
        clickLogin();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe(koelHome));
    }

    public void clickViewAll() {
        WebElement viewallButton = driver.findElement(By.cssSelector("button[data-testid='home-view-all-recently-played-btn']"));
        viewallButton.click();
    }

    public void clickFirstSong() {
        currentUrl = driver.getCurrentUrl();
        WebElement firstSong = null;
        if (currentUrl.equals(koelSongs)) {
            firstSong = driver.findElement(By.cssSelector("#songsWrapper [class='song-item']:nth-child(1)"));
        }
        else if (currentUrl.equals(koelRecentlyPlayed)) {
            firstSong = driver.findElement(By.cssSelector("#recentlyPlayedWrapper [class='song-item']:nth-child(1)"));
        }
        firstSong.click();
    }

    public void playFirstSong() {
        Actions actions = new Actions(driver);
        currentUrl = driver.getCurrentUrl();
        WebElement firstSong = null;
        if (currentUrl.equals(koelSongs)) {
            firstSong = driver.findElement(By.cssSelector("#songsWrapper [class='song-item']:nth-child(1)"));
        }
        else if (currentUrl.equals(koelRecentlyPlayed)) {
            firstSong = driver.findElement(By.cssSelector("#recentlyPlayedWrapper [class='song-item']:nth-child(1)"));
        }
        actions.doubleClick(firstSong).perform();
    }

    public void clickAddto() {
        WebElement Addto = driver.findElement(By.cssSelector("button[class='btn-add-to']"));
        Addto.click();
    }

    public void clickPlaylistfromAddto(String searchText) {
        WebElement playlistAddto = driver.findElement(By.xpath("//*[@id='recentlyPlayedWrapper'] //li[contains(text(),'" + searchText + "')]"));
        //WebElement playlistAddto = driver.findElement(By.cssSelector("#recentlyPlayedWrapper [class='existing-playlists'] [class='playlist']"));
        playlistAddto.click();
    }

    public String getSuccessNotif(){
        return driver.findElement(By.cssSelector("[class='success show']")).getText();
    }

    public WebElement getSuccessPopup(){
        return driver.findElement(By.cssSelector("[class='success show']"));
    }

    public WebElement getPauseButton(){
        return driver.findElement(By.cssSelector("span[class='pause']"));
    }


    public void deleteAddedSongPlaylist(String searchText){
        WebElement testPlaylist = driver.findElement(By.xpath("//*[@id='playlists']  //li[@class='playlist playlist']  //a[contains(text(),'" + searchText + "')]"));
        //WebElement testPlaylist = driver.findElement(By.cssSelector("#playlists li[class='playlist playlist'] a"));
        testPlaylist.click();
        WebElement song_to_select = driver.findElement(By.cssSelector("#playlistWrapper [class='song-item']:nth-child(1)"));
        song_to_select.click();
        WebElement song_to_delete = driver.findElement(By.cssSelector("#playlistWrapper [class='song-item selected']:nth-child(1)"));
        //song_to_delete.sendKeys(Keys.BACK_SPACE);
        Actions actions = new Actions(driver);
        actions.moveToElement(song_to_delete).click().sendKeys(Keys.DELETE).perform();
    }
}
