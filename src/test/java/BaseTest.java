import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Keys;
import org.testng.Assert;





import java.time.Duration;


public class BaseTest {
public static WebDriver driver = null;
WebDriverWait wait;
public static String url = null;

Actions actions;
    String playlistName = "LinaPelo2323";

    @BeforeSuite
    static void setupClass() {

        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    @Parameters({"BaseURL"})
    public void setUpBrowser(String BaseURL) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        actions = new Actions(driver);
        url = BaseURL;
        driver.get(url);
    }
    @AfterMethod
    public static void closeBrowser(){
        driver.quit();
    }


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

    public void logIn(){
        enterEmail("vasilinapelo@gmail.com");
        enterPassword("vasilina230109!");
        clickSubmit();
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
    public void doubleClickPlaylist(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
        WebElement playlistElement = driver.findElement(By.cssSelector(".playlist:nth-child(3)"));
        actions.doubleClick(playlistElement).perform();
    }

    public void enterNewPlaylistName(){

        WebElement inputPlaylistField =wait.until(ExpectedConditions.elementToBeClickable
                (By.cssSelector("input[name='name']")));
        inputPlaylistField.sendKeys(Keys.COMMAND + "a");
        inputPlaylistField.sendKeys(Keys.DELETE);
        inputPlaylistField.sendKeys(playlistName);
        inputPlaylistField.sendKeys(Keys.ENTER);

    }

    public boolean checkNewPlaylist(){
        WebElement playlistElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//a[text()= '" +playlistName+"']")));
        return playlistElement.isDisplayed();

    }

}
