import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import java.time.Duration;

public class BaseTest {

    public static WebDriver driver;
    public static String url = "https://bbb.testpro.io";
    static WebDriverWait wait;

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters({"BaseURL"})
    public void setUpBrowser() {
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(option);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get(url);
    }

    @AfterMethod
    public static void closeBrowser() {
        driver.quit();
    }

    public static void provideEmail(String email) throws InterruptedException {
//        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
//        WebElement emailElement = wait.until(ExpectedConditions.elementToBeClickable(emailField));
        WebElement emailElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='email']")));
        emailElement.click();
        emailElement.sendKeys(email);
//        Thread.sleep(2000);
    }

    public static void providePassword(String password) throws InterruptedException {
//        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
//        WebElement passwordElement = wait.until(ExpectedConditions.elementToBeClickable(passwordField));
        WebElement passwordElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='password']")));
        passwordElement.click();
        passwordElement.sendKeys(password);
//        Thread.sleep(2000);
    }

    public static void clickSubmitButton() throws InterruptedException {
//        WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
//        WebElement submitElement = wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        WebElement submitElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='submit']")));
        submitElement.click();
//        Thread.sleep(2000);
    }

    //*    public void clickPlayButton() throws InterruptedException {
//        WebElement playButton = driver.findElement(By.xpath("//*[@data-testid='play-btn']"));
//        WebElement playNextSongButton = driver.findElement(By.xpath("//*[@data-testid='play-next-btn']"));
//        playNextSongButton.click();
//        playButton.click();
//        Thread.sleep(3000);
//
//    }
//    public boolean theSongIsPlaying() {
//        WebElement soundIsPlaying = driver.findElement(By.xpath("//*[@data-testid='sound-bar-play']"));
//        return soundIsPlaying.isDisplayed();
//    }
    public static void SearchLine(String searchSong) throws InterruptedException {
//        WebElement search = driver.findElement(By.cssSelector("[type='search']"));
        WebElement searchSongElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='search']")));
        searchSongElement.sendKeys(searchSong);
//        Thread.sleep(2000);
    }

    public static void clickViewAll() throws InterruptedException {
//        WebElement openViewAll = driver.findElement(By.xpath("//*[@id='searchExcerptsWrapper']/div/div/section[1]/h1/button"));
        WebElement openViewAllElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='searchExcerptsWrapper']/div/div/section[1]/h1/button")));
        openViewAllElement.click();
//        Thread.sleep(2000);
    }

    public static void firstSongResults() throws InterruptedException {
        WebElement clickSongSearchResults = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='songResultsWrapper']/div/div/div[1]/table/tr[1]/td[2]")));
        clickSongSearchResults.click();
//        Thread.sleep(2000);
    }

    public static void clickAddToButton() throws InterruptedException {
        WebElement addToButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='songResultsWrapper']/header/div[3]/span/button[2]")));
        addToButton.click();
//        Thread.sleep(2000);
    }

    public static void createNewPlaylist() throws InterruptedException {
        WebElement newPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='songResultsWrapper']/header/div[3]/div/section[2]/form/input")));
        newPlaylist.sendKeys("Playlist1");
//        Thread.sleep(2000);
    }

    public static void clickSubmitNewPlaylistButton() throws InterruptedException {
        WebElement clickSubmitButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='songResultsWrapper']/header/div[3]/div/section[2]/form/button")));
        clickSubmitButton.click();
//        Thread.sleep(2000);
    }

    public static void getNotification() throws InterruptedException {
        WebElement notificationElement = wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath("/html/body/div[2]"))));
        notificationElement.isDisplayed();
//        Thread.sleep(2000);
    }

    public static void deletePlaylist() throws InterruptedException {
        WebElement selectedPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='playlist playlist']")));
        selectedPlaylist.click();
//        Thread.sleep(2000);
    }

    public static void clickToDeletePlaylistButton() throws InterruptedException {
        WebElement deletePlaylistButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='del btn-delete-playlist']")));
        deletePlaylistButton.click();
//        Thread.sleep(1000);
    }

    public static void deletePlaylistPopsUpWindow() throws InterruptedException {
        WebElement deletePlaylistPopsUp = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='msg']")));
        deletePlaylistPopsUp.isDisplayed();
//        Thread.sleep(1000);
    }

    public static void clickDeleteOkButton() throws InterruptedException {
        WebElement deletePlaylistOkButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='ok']")));
        deletePlaylistOkButton.click();
//        Thread.sleep(1000);
    }

    public static boolean notificationMessageDeletePlaylist() {
        WebElement notificationMsgDeletePlaylist = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='alertify-logs top right']")));
        return notificationMsgDeletePlaylist.isDisplayed();
    }
    }
