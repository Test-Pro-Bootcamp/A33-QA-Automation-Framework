import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

import java.time.Duration;

public class BaseTest {

    protected static WebDriver driver  = null;
    protected static WebDriverWait wait;
    protected  static Actions action;
    private static final int time = 6; //time in seconds for timeout wait
    private static Boolean playlistExists = Boolean.FALSE;



    @BeforeSuite
    protected static void setUpClass () {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUpBrowser () {
        ChromeOptions options  = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver,Duration.ofSeconds(time));
        action = new Actions(driver);

    }

    public static void navigateToPage(String url) {
        driver.get(url);
    }

    public static void loginWithValidCredentials (String email, String password){
        System.out.println(email);
        System.out.println(password);
        WebElement emailEl = wait.until(ExpectedConditions.elementToBeClickable((By.cssSelector("[type = 'email']"))));
        emailEl.sendKeys(email);
        WebElement passwdEl = wait.until((ExpectedConditions.elementToBeClickable(By.cssSelector("[type = 'password']"))));
        passwdEl.sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type = 'submit']"))).click();
    }

    protected static void searchSong (String song){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.main-scroll-wrap")));
        WebElement songEl = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type = 'search']")));
        songEl.clear();
        String url = driver.getCurrentUrl();
        System.out.println("searching for " + song + " in " + url);
        songEl.sendKeys(song);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.results")));
    }

    protected static void viewAllSongs () {
        //view all results for songs
        WebElement searchResult = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("section.songs h1 button")
        ));
        searchResult.click();
        String url = driver.getCurrentUrl();
        System.out.println("searching for in " + url);
    }

    protected static void selectFirstSong () {
        WebElement songEl = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("#songResultsWrapper  tr > td.title")
        ));
        songEl.click();
    }

    protected String clickAddToPls (String playlist) {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#songResultsWrapper button.btn-add-to"))).click();
        String xpathSelector = "//section[@id='songResultsWrapper']//li[contains(text(),'" + playlist + "')]";
        WebElement ourPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathSelector)));
        ourPlaylist.click();
        String msg = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("div.success.show")
        )).getText();
        System.out.println(msg);
        return msg;
    }

    public static void playNextSong () {
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.cssSelector("i[title = 'Play next song']")
        )).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span.play>i"))).click();
    }

    public Boolean isPlaying () {  //verifying by checking whether the sound bar is displayed
        return wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("img[alt = 'Sound bars']")
        )).isDisplayed();
    }

    public static void selectPlaylist (String playlist){
        try {
            String xpathSelector = "//section[@id='playlists']//a[contains(text(),'" + playlist + "')]";
            WebElement selPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathSelector)));
            selPlaylist.click();
            playlistExists = Boolean.TRUE;
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#playlistWrapper")));
            System.out.println("Playlist " + playlist + " has been selected");
        } catch (Exception e) {
            //if there is no playlist with the given name then we create a new playlist with that name
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#homeWrapper")));
            WebElement el = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#sidebar a.songs")));
            el.click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#songsWrapper")));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(
                    "#songsWrapper  tr > td.title"
            ))).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(
                    "div.song-list-controls button.btn-add-to"
            ))).click();
            //type in the name of a new playlist and create it
            WebElement newPlaylist = driver.findElement(By.cssSelector("section.new-playlist input"));
            newPlaylist.sendKeys(playlist);
            newPlaylist.sendKeys(Keys.ENTER);
            System.out.println("Playlist " + playlist + " has been created and selected");
        }
    }

    public static String deleteSelectedPlaylist(){
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(
                "#playlistWrapper  button.del.btn-delete-playlist"
        ))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.alertify button.ok"))).click();
        String msg;
        if (playlistExists) {
            msg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show"))).getText();
        } else {
            msg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show:nth-child(2)"))).getText();
        }
        System.out.println("Message is: " + msg);
        return msg;
    }

    public static String updatePlaylist (String playlistToChange, String newPlaylistName) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#playlists")));
        String xpathSelector = "//section[@id='playlists']//a[contains(text(),'" + playlistToChange + "')]";
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathSelector)));
        WebElement selPlaylist = driver.findElement(By.xpath(xpathSelector));
        action.click(selPlaylist).perform();
        action.contextClick(selPlaylist).perform();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("nav.menu.playlist-item-menu")));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(
                "li[data-testid *= 'playlist-context-menu-edit']"
        ))).click();
        WebElement newPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
                "li.playlist.playlist.editing input"
        )));
        newPlaylist.sendKeys(Keys.CONTROL + "a");
        newPlaylist.sendKeys(Keys.DELETE);
        newPlaylist.sendKeys(newPlaylistName);
        newPlaylist.sendKeys(Keys.ENTER);
        String msg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show"))).getText();
        System.out.println(msg);
        return msg;
    }

    @AfterMethod
    public void closeBrowser () {
        driver.quit();
    }
}
