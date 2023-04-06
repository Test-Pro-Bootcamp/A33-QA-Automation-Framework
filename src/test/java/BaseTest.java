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
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

public class BaseTest {

    public static WebDriver driver = null;
     WebDriverWait wait;
    @BeforeSuite
    static void setupClass() {
    //    WebDriverManager.chromedriver().setup();
    }
    public static Actions actions = null;
    public ThreadLocal<WebDriver> threadDriver;

    @BeforeMethod
    @Parameters("BaseUrl")
    public  void launchBrowser(String BaseUrl) throws MalformedURLException {
        threadDriver = new ThreadLocal<>();
        driver = pickBrowser(System.getProperty("browser")) ;
        threadDriver.set(driver);
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String url = BaseUrl;
        getDriver().get(BaseUrl);
        wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        actions = new Actions(driver);
   }

   public WebDriver lambdaTest() throws MalformedURLException {
       String hubURL = "https://hub.lambdatest.com/wd/hub";

       ChromeOptions browserOptions = new ChromeOptions();
       browserOptions.setPlatformName("Windows 10");
       browserOptions.setBrowserVersion("111.0");
       HashMap<String, Object> ltOptions = new HashMap<String, Object>();
       ltOptions.put("username", "ayoub.rafiqui");
       ltOptions.put("accessKey", "6LidJdX30K6sCilU2bVnJGObjIMdEBOY1SdXEARYgNDejUr7KF");
       ltOptions.put("project", "Untitled");
       ltOptions.put("w3c", true);
       ltOptions.put("plugin", "java-testNG");
       browserOptions.setCapability("LT:Options", ltOptions);
       return new RemoteWebDriver(new URL(hubURL),browserOptions);
   }
    private WebDriver pickBrowser(String browser) throws MalformedURLException {
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
            case "lambda":
                return lambdaTest();
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-notifications","--remote-allow-origins=*", "--incognito","--start-maximized");
                return driver = new ChromeDriver(options);

        }
    }
        protected void openBrowser() {String url = "https://bbb.testpro.io/";
            getDriver().get(url);
   }
   @AfterMethod
    public void closeBrowser() {
       getDriver().quit();
        threadDriver.remove();
    }
    public WebDriver getDriver(){
        return threadDriver.get();
    }
    public void enterEmail() {
        WebElement emailField = getDriver().findElement(By.cssSelector("[type='email']"));
        emailField.click();
        emailField.sendKeys("rfkayoub12@gmail.com");
    }

    public void enterPassword() {
        WebElement passwordField = getDriver().findElement(By.cssSelector("[type='password']"));
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
        WebElement firstSong = getDriver().findElement(By.cssSelector("#songResultsWrapper > div > div > div.item-container > table > tr > td.title"));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#songResultsWrapper > div > div > div.item-container > table > tr > td.title"))).click();


    }
    public void clickAddTo()  {
        WebElement addToBtn = getDriver().findElement(By.cssSelector("[class='btn-add-to']"));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class='btn-add-to']"))).click();
    }
    public void choosePlaylist()  {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#songResultsWrapper > header > div.song-list-controls > div > section.existing-playlists > ul > li:nth-child(6)"))).click();
    }
    public String getNotification() {
        WebElement notificationElement = getDriver().findElement(By.cssSelector("div.success.show"));
        return notificationElement.getText();
    }
    public void clickNext()  {
        WebElement nextBtn = getDriver().findElement(By.cssSelector("[data-testid ='play-next-btn']"));
        nextBtn.click();
    }
    public void clickPlay()  {
        WebElement playBtn = getDriver().findElement(By.cssSelector("[data-testid='play-btn']"));
        playBtn.click();
    }
    public Boolean isSongPlaying() {
        WebElement songIsPLaying = getDriver().findElement(By.cssSelector("[class='plyr__progress--seek']"));
        return songIsPLaying.isDisplayed();
    }
    public void clickPlaylist()  {
        WebElement chosenPlaylist = getDriver().findElement(By.cssSelector("#playlists > ul > li:nth-child(3) > a"));
        chosenPlaylist.click();
    }
    public void clickDelete()  {
        WebElement xPlaylist = getDriver().findElement(By.cssSelector("[title = 'Delete this playlist']"));
        xPlaylist.click();
    }


}