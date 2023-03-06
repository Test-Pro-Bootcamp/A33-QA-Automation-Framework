import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import java.security.PublicKey;
import java.time.Duration;

public class BaseTest {

    protected static WebDriver driver  = null;
    protected static WebDriverWait wait;
    private static int smallWait = 1500;

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
        wait = new WebDriverWait(driver, Duration.ofSeconds(1));
    }

    public static void navigateToPage(String url) {
        driver.get(url);
    }

    @DataProvider (name = "Credentials")
    protected static Object [][] getDataFromDataProvider () {
        return new Object [][]{
                {"me@elevchenko.com", "$student1111"},
        };
    }

    public static void loginWithValidCredentials (String email, String password) throws InterruptedException {
        System.out.println(email);
        System.out.println(password);
        WebElement emailEl = driver.findElement(By.cssSelector("[type = 'email']"));
        emailEl.sendKeys(email);
        WebElement passwdEl = driver.findElement(By.cssSelector("[type = 'password']"));
        passwdEl.sendKeys(password);
        driver.findElement(By.cssSelector("button[type = 'submit']")).click();
    }

    protected static void searchSong (String song) throws InterruptedException {
        WebElement songEl = driver.findElement(By.cssSelector("[type = 'search']"));
        songEl.clear();
        songEl.sendKeys(song);
        String url = driver.getCurrentUrl();
        System.out.println("searchng for " + song + " in " + url);
        Thread.sleep(2000);
    }

    protected static void viewAllSongs () throws InterruptedException {
        //view all results for songs
        WebElement searchResult = driver.findElement(By.cssSelector("section.songs h1 button"));
        searchResult.click();
        String url = driver.getCurrentUrl();
        System.out.println("searchng for in " + url);
        Thread.sleep(1000);
    }

    protected static void selectFirstSong () throws InterruptedException {
        WebElement songEl = driver.findElement(By.cssSelector("#songResultsWrapper  tr > td.title"));
        songEl.click();
        Thread.sleep(1000);
    }

    protected String clickAddToPls (String playlist) throws InterruptedException{
        driver.findElement(By.cssSelector("#songResultsWrapper button.btn-add-to")).click();
        Thread.sleep(2000);
        String xpathSelector = "//section[@id='songResultsWrapper']//li[contains(text(),'" + playlist + "')]";
        WebElement ourPlaylist = driver.findElement(By.xpath(xpathSelector));
        ourPlaylist.click();
        /*WebElement playlistEl = driver.findElement(By.cssSelector("#songResultsWrapper section.new-playlist input[type='text']"));
        playlistEl.sendKeys(playlist + "1");
        Thread.sleep(500);
        driver.findElement(By.cssSelector("#songResultsWrapper section.new-playlist button[type='submit']")).click();
        String msg1 = driver.findElement(By.cssSelector("div.success.show")).getText();
        Thread.sleep(500);
        System.out.println(msg1);*/
        String msg = driver.findElement(By.cssSelector("div.success.show")).getText();
        System.out.println(msg);
        Thread.sleep(2000);
        return msg;
    }

    public static void playNextSong () throws  InterruptedException{
        driver.findElement(By.cssSelector("i[title = 'Play next song']")).click();
        driver.findElement(By.cssSelector("span.play>i")).click();
        Thread.sleep(2000);
    }

    public Boolean isPlaying () throws InterruptedException {  //verifying by checking whether the sound bar is displayed
        Boolean isPlayingFlag = driver.findElement(By.cssSelector("img[alt = 'Sound bars']")).isDisplayed();
        return isPlayingFlag;
    }

    public static void selectPlaylist (String playlist) throws InterruptedException{
            String xpathSelector = "//section[@id='playlists']//a[contains(text(),'" + playlist + "')]";
            WebElement selPlaylist = driver.findElement(By.xpath(xpathSelector));
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

    public static String deleteSelectedPlaylist(String playlist) throws InterruptedException {
        driver.findElement(By.cssSelector("#playlistWrapper  button.del.btn-delete-playlist")).click();
        Thread.sleep(smallWait);
        String msg = driver.findElement(By.cssSelector("div.success.show")).getText();
        System.out.println("Message is: " + msg);
        return msg;
    }

    @AfterMethod
    public void closeBrowser () {
        driver.quit();
    }
}
