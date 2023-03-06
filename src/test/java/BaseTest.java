import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Parameters;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;


public class BaseTest {
    WebDriver driver;
    Actions actions;
    WebDriverWait wait;
    String currentUrl = "";
    String testUrl = "";
    String password = "";
    String email = "";
    String workingPlaylist = "";
    String koelStart = "https://bbb.testpro.io/";
    String koelHome = "https://bbb.testpro.io/#!/home";
    String koelSongs = "https://bbb.testpro.io/#!/songs";
    String koelRecentlyPlayed = "https://bbb.testpro.io/#!/recently-played";



    @BeforeSuite
    public void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters({"baseURL"})
    public void setupBrowser(String baseUrl) {
        ChromeOptions options= new ChromeOptions(); options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        //actions = new Actions(driver);
        //wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(baseUrl);
    }

    @BeforeMethod
    @Parameters({"email", "password"})
    public void setLogEmail(String mail, String pass) {
        password = pass;
        email = mail;
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

    public void setUrl(String url) {
        testUrl = url;
    }

    public void setPassword(String pass) {
        password = pass;
    }

    public void setEmail(String mail) {
        email = mail;
    }

    public void openUrl(String url) {
        driver.get(url);
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
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        loginButton.click();
    }

    public void loginValidAccount(String email, String password) {
        openLoginURL();
        inputEmail(email);
        inputPassword(password);
        clickLogin();
    }

    public void logIn() {
        inputEmail(email);
        inputPassword(password);
        clickLogin();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe(koelHome));
    }

    public void clickViewAll() {
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //wait.until(ExpectedConditions.elementToBeClickable(By.id("button[data-testid='home-view-all-recently-played-btn']")));
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
        actions = new Actions(driver);
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

    public WebElement getDeletedPlaylistmsg(){
        return driver.findElement(By.cssSelector("div.success.show"));
    }

    public WebElement getSuccessPopup(){
        return driver.findElement(By.cssSelector("[class='success show']"));
    }

    public WebElement getPauseButton(){
        return driver.findElement(By.cssSelector("span[class='pause']"));
    }

    public void deleteAddedSongPlaylist(String searchText){
        //WebElement testPlaylist = driver.findElement(By.xpath("//*[@id='playlists']  //li[@class='playlist playlist']  //a[contains(text(),'" + searchText + "')]"));
        //testPlaylist.click();
        actions = new Actions(driver);
        openPlaylist(searchText);
        WebElement song_to_select = driver.findElement(By.cssSelector("#playlistWrapper [class='song-item']:nth-child(1)"));
        song_to_select.click();
        WebElement song_to_delete = driver.findElement(By.cssSelector("#playlistWrapper [class='song-item selected']:nth-child(1)"));
        song_to_delete.click();
        actions.sendKeys(Keys.DELETE).perform();
    }

    public void openPlaylist(String searchText) {
        WebElement testPlaylist = driver.findElement(By.xpath("//*[@id='playlists']  //li[@class='playlist playlist']  //a[contains(text(),'" + searchText + "')]"));
        //WebElement testPlaylist = driver.findElement(By.cssSelector("#playlists li[class='playlist playlist'] a"));
        testPlaylist.click();
        //WebElement namePlaylist = driver.findElement(By.xpath("//section[@id='playlistWrapper'] //h1[contains(text(),'" + searchText + "')]"));
        //wait.until(ExpectedConditions.visibilityOf(namePlaylist));
    }

    public void createPlaylist(String name) {
        WebElement plusButton = driver.findElement(By.cssSelector("i[class='fa fa-plus-circle create']"));
        plusButton.click();
        WebElement simplePlaylist = driver.findElement(By.cssSelector("[data-testid='playlist-context-menu-create-simple']"));
        simplePlaylist.click();
        WebElement playlistTxtbox = driver.findElement(By.cssSelector("input[name='name']"));
        playlistTxtbox.sendKeys(name);
        playlistTxtbox.sendKeys(Keys.ENTER);
    }

    public void deleteEmptyPlaylist() {
        WebElement button = driver.findElement(By.cssSelector("[class='del btn-delete-playlist']"));
        button.click();
    }

    public void deleteFullPlaylist() {
        WebElement button = driver.findElement(By.cssSelector("[class='del btn-delete-playlist']"));
        button.click();
        WebElement okbutton = driver.findElement(By.cssSelector("button[class='ok']"));
        okbutton.click();
    }



    public boolean isPlaylistvisible(String searchText) {
        try {
            WebElement testPlaylist = driver.findElement(By.xpath("//*[@id='playlists']  //li[@class='playlist playlist']  //a[contains(text(),'" + searchText + "')]"));
            return testPlaylist.isDisplayed();
        }
        catch (NoSuchElementException e) {
            return false;
        }
    }
}
