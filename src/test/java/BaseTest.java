import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;


import java.time.Duration;


public class BaseTest {
public static WebDriver driver = null;

public static String url = null;

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    @Parameters({"BaseURL"})
    public void setUpBrowser(String BaseURL) {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        url = BaseURL;
        driver.get(url);


    }
    @AfterMethod
    public static void closeBrowser(){
        driver.quit();
    }

    public void openloginUrl() {
        driver.get("https://bbb.testpro.io/");
    }

    public void enterEmail(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        emailField.click();
        emailField.sendKeys(email);
    }

    public void enterPassword(String password) {
        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        passwordField.click();
        passwordField.sendKeys(password);
    }

    public void clickSubmit() {
        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitButton.click();
    }

    public void searchForSong(String songName) throws InterruptedException {
        WebElement searchField = driver.findElement(By.cssSelector("[type='search']"));
        searchField.sendKeys(songName);
        Thread.sleep(2000);

    }

    public void clickViewAll() throws InterruptedException {
        WebElement viewAll = driver.findElement(By.cssSelector("div.results section.songs h1 button"));
        viewAll.click();
        Thread.sleep(2000);

    }

    public void selectFirstSong() throws InterruptedException {
        WebElement firstSong = driver.findElement(By.xpath("//td[contains(text(),'Dark Days')]"));
        firstSong.click();
        Thread.sleep(2000);
    }

    public void clickAddTo() throws InterruptedException {
        WebElement addOnButton = driver.findElement(By.xpath("//button[@class='btn-add-to']"));
        addOnButton.click();
        Thread.sleep(2000);

    }
    public void choosePlaylist()throws InterruptedException{
        WebElement playlistName = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(),'lina230109')]"));
        playlistName.click();
        Thread.sleep(2000);

    }

    public String getNotificationMessage(){
        WebElement notificationElement = driver.findElement(By.cssSelector("div.success.show"));
        return notificationElement.getText();

    }

    public void playSong() throws InterruptedException{
        WebElement playButton = driver.findElement(By.cssSelector("[data-testid ='play-btn']"));
        WebElement nextSongPlayButton = driver.findElement(By.cssSelector("[data-testid ='play-next-btn']"));
        nextSongPlayButton.click();
        Thread.sleep(2000);
        playButton.click();
        Thread.sleep(2000);
    }

    public boolean soundBarIsDisplayed(){
        WebElement soundBarButton = driver.findElement(By.cssSelector("[data-testid ='sound-bar-play']"));
        return soundBarButton.isDisplayed();
    }

    public void selectPlaylist() throws InterruptedException{
        WebElement playlistButton = driver.findElement(By.cssSelector(".playlist:nth-child(3)"));
        playlistButton.click();
        Thread.sleep(2000);

    }
   public void deletePlayList() throws InterruptedException{
        WebElement deletePlaylistButton = driver.findElement(By.cssSelector(".btn-delete-playlist"));
        deletePlaylistButton.click();
       Thread.sleep(2000);

   }


   public WebElement getDeletedPlaylistMessage() {
       return driver.findElement(By.cssSelector("div.success.show"));
   }

}
