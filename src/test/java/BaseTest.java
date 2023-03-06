import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
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
    public static WebDriverWait wait = null;

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    @Parameters({"baseUrl"})
    public static void launchBrowser(String baseUrl){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        url = baseUrl;
        driver.get(url);
    }
    public static void provideEmail(String email){
        WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector
                ("[type='email']")));
        emailField.clear();
        emailField.sendKeys(email);
    }
    public static void providePassword(String password){
        WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector
                ("[type='password']")));
        passwordField.clear();
        passwordField.sendKeys(password);
    }
    public static void clickSubmit(){
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector
                ("button[type='submit']")));
        submitButton.click();
    }
    public static void login(String email, String password){
        provideEmail(email);
        providePassword(password);
        clickSubmit();
    }
    public static void createNewPlaylist(){
        WebElement newPlaylistIcon = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector
                ("i[title='Create a new playlist']")));
        newPlaylistIcon.click();
        WebElement newPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector
                ("li[data-testid='playlist-context-menu-create-simple']")));
        newPlaylist.click();
        WebElement nameField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector
                (" input[name='name']")));
        nameField.clear();
        nameField.sendKeys("Sleepy Songs");
        nameField.sendKeys(Keys.ENTER);
    }
    public static boolean newPlaylistIsDisplayed(){
        WebElement newPlaylist = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector
                ("a[class='active']")));
        return newPlaylist.isDisplayed();
    }
    public static void searchASong(String songName){
        WebElement searchSong = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector
                ("[type='search']")));
        searchSong.sendKeys(songName);
}
    public static void clickViewAllButton(){
        WebElement clickViewAllButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector
                ("button[data-test = 'view-all-songs-btn']")));
        clickViewAllButton.click();
}
    public static void selectFirstSong(){
        WebElement firstSong = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector
                ("section#songResultsWrapper tr.song-item td.title")));
        firstSong.click();
}
    public static void clickAddToButton(){
        WebElement addToButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector
                ("button[class = 'btn-add-to'")));
        addToButton.click();
}
    public static void clickPlaylistNameFromAddToButton(String playlistName){
        WebElement clickPlaylistNameFromAddToButton = wait.until(ExpectedConditions.elementToBeClickable
                (By.xpath(("//section[@id='songResultsWrapper']//section/ul//li[contains(text(), '" + playlistName + "')]"))));
        clickPlaylistNameFromAddToButton.click();
}
    public static boolean notificationMessageIsDisplayed() {
        WebElement getNotificationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector
                ("div.success.show")));
        return getNotificationMessage.isDisplayed();
    }
    public static void deleteSongFromPlaylist() {
        WebElement selectPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector
                ("li[class='playlist playlist']")));
        selectPlaylist.click();
        WebElement selectTheSong = wait.until(ExpectedConditions.elementToBeClickable(By.xpath
                ("//*[@id='playlistWrapper']/div/div/div[1]/table/tr/td[2]")));
        selectTheSong.click();
        WebElement deleteSong = wait.until(ExpectedConditions.elementToBeClickable(By.xpath
                ("//*[@id= 'playlistWrapper']/div/div/div[1]/table/tr")));
        Actions actions = new Actions(driver);
        actions.moveToElement(selectTheSong).click().sendKeys(Keys.DELETE).perform();
    }

    public static void accessMediaPlayerControls() {
        WebElement clickPlayNextSongControl = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector
                ("i[title='Play next song']")));
        clickPlayNextSongControl.click();

        WebElement clickPlayButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector
                ("span[title='Play or resume']")));
        clickPlayButton.click();
        Actions actions = new Actions(driver);
        actions.click(clickPlayButton).perform();
    }
    public static boolean playingSongIsDisplayed(){
        WebElement songIsPlaying = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//progress[@class='plyr__progress--played']")));
        return songIsPlaying.isDisplayed();
    }
    public static void clickExistingPlaylist() {
        WebElement clickPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath
                ("//a[contains(text(), 'Sleepy Songs')]")));
        clickPlaylist.click();

    }
    public static void deleteExistingPlaylist(){
        WebElement clickXPlaylistButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector
                ("button[title='Delete this playlist']")));
        clickXPlaylistButton.click();
    }
    public static boolean getNotificationMessage(){
        WebElement notificationMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector
                ("div.success.show")));
        return notificationMessage.isDisplayed();
    }
    @AfterMethod
    public static void closeBrowser(){
        driver.quit();
    }

}
