import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.openqa.selenium.support.ui.WebDriverWait;



import java.time.Duration;


public class BaseTest {
public static WebDriver driver = null;
WebDriverWait wait;
public static String url = null;

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    @Parameters({"BaseURL"})
    public void setUpBrowser(String BaseURL) {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,Duration.ofSeconds(15));
        url = BaseURL;
        driver.get(url);
    }
    @AfterMethod
    public static void closeBrowser(){
        driver.quit();
    }

    //public void openloginUrl() {
        //driver.get("https://bbb.testpro.io/");
    //}

    public void enterEmail(String email) {
        WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='email']")));
        emailField.click();
        emailField.sendKeys(email);
    }

    public void enterPassword(String password) {
        WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='password']")));
        passwordField.click();
        passwordField.sendKeys(password);
    }

    public void clickSubmit() {
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
        submitButton.click();
    }

    public void searchForSong(String songName) {
        WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='search']")));
        searchField.sendKeys(songName);
    }

    public void clickViewAll() {
        WebElement viewAll = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.results section.songs h1 button")));
        viewAll.click();
    }

    public void selectFirstSong()  {
        WebElement firstSong = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'Dark Days')]")));
        firstSong.click();
    }

    public void clickAddTo()  {
        WebElement addOnButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn-add-to']")));
        addOnButton.click();
    }
    public void choosePlaylist(){
        WebElement playlistName = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(),'lina230109')]")));
        playlistName.click();
    }

    public boolean getNotificationMessage(){
        WebElement notificationElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notificationElement.isDisplayed();
    }

    public void playSong() {
        WebElement playButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[data-testid ='play-btn']")));
        WebElement nextSongPlayButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[data-testid ='play-next-btn']")));
        nextSongPlayButton.click();
        playButton.click();
    }

    public boolean soundBarIsDisplayed(){
        WebElement soundBarButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid ='sound-bar-play']")));
        return soundBarButton.isDisplayed();
    }

    public void selectPlaylist() {
        WebElement playlistButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".playlist:nth-child(3)")));
        playlistButton.click();
    }
   public void deletePlayList() {
        WebElement deletePlaylistButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn-delete-playlist")));
        deletePlaylistButton.click();
   }

   public boolean getDeletedPlaylistMessage() {
        WebElement notificationMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.success.show")));
       return notificationMessage.isDisplayed();
   }

}
