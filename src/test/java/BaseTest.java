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
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.openqa.selenium.interactions.Actions;

import java.net.MalformedURLException;
import java.net.URI;
import java.time.Duration;
public class BaseTest {

    public static WebDriver driver = null;
     WebDriverWait wait;
    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    public static Actions actions = null;
    @BeforeMethod
    @Parameters("BaseUrl")
    public void setUpBrowser(String BaseUrl) {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications","--remote-allow-origins=*", "--incognito","--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(BaseUrl);
        wait = new WebDriverWait(driver,Duration.ofSeconds(5));
         actions = new Actions(driver);
    }
    @BeforeMethod
    @Parameters("BaseUrl")
    public static void launchBrowser() throws MalformedURLException {
        driver = pickBrowser(System.getProperty("browser")) ;
   }
    private static WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL = " http://192.168.1.248:4444";
        switch (browser){
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return driver = new FirefoxDriver();
            case "grid-chrome":
             caps.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "grid-firefox":
                caps.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            default:
                return driver = new ChromeDriver();

        }
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
    public void submit() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='submit']"))).click();
    }

    public void searchForSong()  {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='search']"))).sendKeys("Lament");
    }
    public void clickViewAll() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-test='view-all-songs-btn']"))).click();
    }
    public void clickFirstSong()  {
        WebElement firstSong = driver.findElement(By.cssSelector("#songResultsWrapper > div > div > div.item-container > table > tr > td.title"));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#songResultsWrapper > div > div > div.item-container > table > tr > td.title"))).click();


    }
    public void clickAddTo()  {
        WebElement addToBtn = driver.findElement(By.cssSelector("[class='btn-add-to']"));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class='btn-add-to']"))).click();
    }
    public void choosePlaylist()  {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#songResultsWrapper > header > div.song-list-controls > div > section.existing-playlists > ul > li:nth-child(6)"))).click();
    }
    public String getNotification() {
        WebElement notificationElement = driver.findElement(By.cssSelector("div.success.show"));
        return notificationElement.getText();
    }
    public void clickNext()  {
        WebElement nextBtn = driver.findElement(By.cssSelector("[data-testid ='play-next-btn']"));
        nextBtn.click();
    }
    public void clickPlay()  {
        WebElement playBtn = driver.findElement(By.cssSelector("[data-testid='play-btn']"));
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


}