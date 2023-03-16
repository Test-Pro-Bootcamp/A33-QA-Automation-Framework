import com.beust.jcommander.Parameter;
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
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.openqa.selenium.interactions.Actions;
import java.time.Duration;


public class BaseTest {

    public static WebDriver driver = null;
     WebDriverWait wait;
     //this line here breaks my code
   //Actions actions = new Actions(driver);
    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
public static Actions actions = null;

    @BeforeMethod
    @Parameters("BaseUrl")
    public void setUpBrowser(String BaseUrl) {
       // driver = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications","--remote-allow-origins=*", "--incognito","--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //driver.manage().window().maximize();
        driver.get(BaseUrl);
        wait = new WebDriverWait(driver,Duration.ofSeconds(5));
         actions = new Actions(driver);
    }

   protected void openBrowser() {String url = "https://bbb.testpro.io/";
       driver.get(url);
   }

    public void closeBrowser() {
        driver.quit();
    }

    public void enterEmail() {
        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        emailField.click();
        emailField.sendKeys("rfkayoub12@gmail.com");
    }

    public void enterPassword() {
        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        passwordField.click();
        passwordField.sendKeys("te$t$tudent");
    }

    public void submit()  {
       // WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='submit']"))).click();
        //submitButton.click();

    }

    public void searchForSong()  {
        //WebElement searchField = driver.findElement(By.cssSelector("[type='search']"));
       // searchField.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='search']"))).sendKeys("Lament");
        //searchField.sendKeys("Lament");

    }

    public void clickViewAll() {
        //WebElement viewAll = driver.findElement(By.cssSelector("[data-test='view-all-songs-btn']"));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-test='view-all-songs-btn']"))).click();
        //viewAll.click();

    }

    public void clickFirstSong()  {
        WebElement firstSong = driver.findElement(By.cssSelector("#songResultsWrapper > div > div > div.item-container > table > tr > td.title"));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#songResultsWrapper > div > div > div.item-container > table > tr > td.title"))).click();
        //firstSong.click();

    }
    public void clickAddTo()  {
        WebElement addToBtn = driver.findElement(By.cssSelector("[class='btn-add-to']"));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class='btn-add-to']"))).click();
        //addToBtn.click();

    }

    public void choosePlaylist()  {
       // WebElement chosenPlaylist = driver.findElement(By.cssSelector("#songResultsWrapper > header > div.song-list-controls > div > section.existing-playlists > ul > li:nth-child(6)"));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#songResultsWrapper > header > div.song-list-controls > div > section.existing-playlists > ul > li:nth-child(6)"))).click();
        //chosenPlaylist.click();

    }

    public String getNotification() {
        WebElement notificationElement = driver.findElement(By.cssSelector("div.success.show"));
        return notificationElement.getText();
    }

    public void clickNext()  {
        WebElement nextBtn = driver.findElement(By.cssSelector("[data-testid ='play-next-btn']"));
       // wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-testid ='play-next-btn']"))).click();
        nextBtn.click();

    }

    public void clickPlay()  {
        WebElement playBtn = driver.findElement(By.cssSelector("[data-testid='play-btn']"));
       // wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-testid='play-btn']"))).click();
        playBtn.click();

    }

    public Boolean isSongPlaying() {
        WebElement songIsPLaying = driver.findElement(By.cssSelector("[class='plyr__progress--seek']"));
        return songIsPLaying.isDisplayed();
    }

    public void clickPlaylist()  {
        WebElement chosenPlaylist = driver.findElement(By.cssSelector("#playlists > ul > li:nth-child(3) > a"));
        chosenPlaylist.click();
    }
    public void clickDelete()  {
        WebElement xPlaylist = driver.findElement(By.cssSelector("[title = 'Delete this playlist']"));
        xPlaylist.click();
    }
    public void selectPlaylist(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#playlists > ul > li:nth-child(4) > a"))).click();
    }

    public void contextClickPlaylist(){
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#playlists > ul > li:nth-child(4) > a")));
        WebElement playlistElement = driver.findElement(By.cssSelector("#playlists > ul > li:nth-child(4) > a"));
        actions.contextClick(playlistElement).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#playlists > ul > li:nth-child(4) > nav > ul > li:nth-child(1)"))).click();
    }

    public void enterPlaylistName(){
        WebElement playlistInputField = driver.findElement(By.cssSelector("input[name='name']"));
        playlistInputField.sendKeys(Keys.chord(Keys.CONTROL, "a" ,Keys.BACK_SPACE));
        playlistInputField.sendKeys("newPlaylistName");
        playlistInputField.sendKeys(Keys.ENTER);
    }

    public Boolean verifyNewPlaylist(){
        WebElement playlistElement1 = driver.findElement(By.xpath("//*[@id='playlists']/ul/li[4]/a"));
        return playlistElement1.isDisplayed();
    }
}