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

    @BeforeSuite
    protected static void setUpClass () {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUpBrowser () {
        ChromeOptions options  = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
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
        System.out.println("searchng for " + song + " in " + url);
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
        System.out.println("searchng for in " + url);
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
        /*WebElement playlistEl = driver.findElement(By.cssSelector("#songResultsWrapper section.new-playlist input[type='text']"));
        playlistEl.sendKeys(playlist + "1");
        Thread.sleep(500);
        driver.findElement(By.cssSelector("#songResultsWrapper section.new-playlist button[type='submit']")).click();
        String msg1 = driver.findElement(By.cssSelector("div.success.show")).getText();
        Thread.sleep(500);
        System.out.println(msg1);*/
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
            String xpathSelector = "//section[@id='playlists']//a[contains(text(),'" + playlist + "')]";
            WebElement selPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathSelector)));
            selPlaylist.click();
            System.out.println("Playlist " + playlist + " has been selected");
        /*} catch (Exception e) {
            //if there is no playlist with the given name then we create a new playlist with that name
            //click "+" (add new Playlist)
            WebElement createNewPls = driver.findElement(By.cssSelector("#mainWrapper i[title = 'Create a new playlist']"));
            // it doesn't work! ?? how to get to ::before pseudo-element?
            createNewPls.click();
            //select "New Playlist"
//            driver.findElement(By.cssSelector("#playlists > nav > ul > li:nth-child(1)")).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#playlists > nav > ul > li:nth-child(1)"))).click();

            //type in the name of a new playlist and create it
            WebElement newPlaylist = driver.findElement(By.cssSelector("form.create input[placeholder = '↵ to save']"));
            newPlaylist.clear();
            newPlaylist.sendKeys(playlist);
            newPlaylist.click();
            System.out.println("Playlist " + playlist + " has been created and selected");
        }*/
    }

    public static String deleteSelectedPlaylist(){
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(
                "#playlistWrapper  button.del.btn-delete-playlist"
        ))).click();
        String msg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show"))).getText();
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
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("nav.menu.playlist-item-menu")));
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
        System.out.println("Message is: " + msg);
        return msg;
    }

    @AfterMethod
    public void closeBrowser () {
        driver.quit();
    }
}
