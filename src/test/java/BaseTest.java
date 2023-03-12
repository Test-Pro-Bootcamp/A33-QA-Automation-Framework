import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.time.Duration;


public class BaseTest {
    public static WebDriver driver = null;
    public static String url = null;

    //Actions action = new Actions(driver);

    static WebDriverWait wait;
    By inputselector = By.cssSelector("input[name='name']");
    String newplaylistname = "Test PRO";

    @BeforeSuite
    static void setupClass() {

        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters({"BaseURL"})
    public static void openBrowser(String BaseURL) {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        url = BaseURL;
        driver.get(url);
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
    }

    public void setUpBrowser() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void closeBrowser() {
        driver.quit();
    }

    public void getBrowser() {
        String url = "https://bbb.testpro.io/";
        driver.get(url);
    }

    public void emailField(String email) {
        WebElement enterEmailFinder = driver.findElement(By.cssSelector("[type='email']"));
        enterEmailFinder.click();
        enterEmailFinder.sendKeys(email);
    }

    public void passwordFinder(String password) {
        WebElement thePasswordFinder = driver.findElement(By.cssSelector("[type='password']"));
        thePasswordFinder.click();
        thePasswordFinder.sendKeys(password);
    }

    public void logIn() {
        //WebElement logInAccount = driver.findElement(By.cssSelector("[type='submit']"));
        WebElement logInButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
        logInButton.click();
    }

    public void searchSongs(String songTitle) {
        WebElement searchTheSongs = driver.findElement(By.cssSelector("[type='search']"));
        searchTheSongs.click();
        searchTheSongs.sendKeys(songTitle);
    }

    public void viewAll() {
        WebElement viewAllOptions = driver.findElement(By.xpath("//*[@data-test='view-all-songs-btn']"));
        viewAllOptions.click();
    }

    public void clickFirstSong() {
        WebElement FirstSong = driver.findElement(By.xpath("/html/body/div/div/div/section[1]/section[11]/div/div/div[1]/table/tr[1]/td[2]"));
        FirstSong.click();
    }

    // public String notificationDisplayed() {
    //  WebElement notificationIsShown = driver.findElement(By.xpath("//div[@class='success show']"));
    // return notificationIsShown.getText();
    // }
    public void addToPlaylist() {
        WebElement addTo = driver.findElement(By.xpath("//*[@data-test='add-to-btn']"));
        addTo.click();
    }

    public void newPlaylist(String playlistName) {
        WebElement newPlaylist = driver.findElement(By.xpath("//*[@id=\"songResultsWrapper\"]/header/div[3]/div/section[2]/form/input"));
        newPlaylist.click();
        newPlaylist.sendKeys(playlistName);
        WebElement newPlaylistEnter = driver.findElement(By.xpath("//*[@id=\"songResultsWrapper\"]/header/div[3]/div/section[2]/form/button"));
        newPlaylistEnter.click();
    }

    public void play() {
        //WebElement pressPlay = driver.findElement(By.xpath("//span[@data-testid='play-btn']"));
        WebElement pressPlay = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@data-testid='play-btn']")));
        pressPlay.click();
    }

    public void hoverOnPlay() {
        //WebElement pressHoverOnPlay = driver.findElement(By.xpath("//i[@data-testid='play-next-btn']"));
        WebElement pressHoverOnPlay = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@data-testid='play-next-btn']")));
        pressHoverOnPlay.click();
    }

    public void soundBar() {
        //WebElement soundBarDisplayed = driver.findElement(By.xpath("//div[@class='side player-controls']"));
        WebElement soundBarDisplay = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='side player-controls']")));
        soundBarDisplay.click();
    }

    public void rewind() {
        WebElement pressRewind = driver.findElement(By.xpath("//span[@data-testid='play-prev-btn']"));
        pressRewind.click();
    }

    public void pause() {
        WebElement pressPause = driver.findElement(By.xpath("//span[@data-testid='pause-btn']"));
        pressPause.click();
    }

    public void opePlaylist() {
        WebElement clickOpePlaylist = driver.findElement(By.xpath("//*[@href='#!/playlist/48047']"));
        clickOpePlaylist.click();
    }

    public void editPlaylist() {
        Actions action = new Actions(driver);
        WebElement firstPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[class='playlist playlist']")));
        action.doubleClick(firstPlaylist).perform();
        WebElement inputNewPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[name='name']")));
        inputNewPlaylist.sendKeys(Keys.chord(Keys.COMMAND, "a", Keys.DELETE));
        inputNewPlaylist.sendKeys("OpeNewPlaylist");
        inputNewPlaylist.sendKeys(Keys.ENTER);
    }

    public void deletePlaylist() {
        WebElement clickDeletePlaylist = driver.findElement(By.xpath("//button[@class='del btn-delete-playlist']"));
        clickDeletePlaylist.click();
        WebElement clickOkay = driver.findElement(By.xpath("//button[@class='ok']"));
        clickOkay.click();
    }

    public boolean verifySoundBar() {
        WebElement soundBarDisplayed = driver.findElement(By.xpath("//div[@class='side player-controls']"));
        return soundBarDisplayed.isDisplayed();
    }

    public String notificationIcon() {
        WebElement newNotificationIcon = driver.findElement(By.xpath("//div[@class='success show']"));
        return newNotificationIcon.getText();
    }

    public boolean notificationVerification() {
        WebElement notificationVerified = driver.findElement(By.xpath("//div[@class='success show']"));
        return notificationVerified.isDisplayed();
    }

    @AfterMethod
    public static void closeChromeBrowser() {
        driver.quit();

    }
}