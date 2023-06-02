import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;


public class BaseTest {
    static WebDriver driver;
    static WebDriverWait wait;
    static String url;
    static Actions actions;
    private static String browser;
    static ThreadLocal<WebDriver> threadDriver;


    @BeforeSuite
    public void setupClass() {
    }

    public static WebDriver getDriver() {
        return driver;

    }

    @BeforeMethod
    @Parameters({"BaseURL"})
    public static void launchBrowser(String BaseURL) throws MalformedURLException {
        threadDriver = new ThreadLocal<>();
        driver = pickBrowser(System.getProperty("browser"));
        threadDriver.set(driver);

        actions = new Actions(getDriver());
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        url = BaseURL;
        getDriver().get(BaseURL);
    }

        public static WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL = "https://192.168.1.2:4444";
            switch (browser) {
                case "firefox" -> {
                    System.setProperty("Webdriver.gecko.driver", "geckoDriver");
                    return driver = new FirefoxDriver();
                }
                case "MicrosoftEdge" -> {
                    WebDriverManager.edgedriver().setup();
                    return driver = new EdgeDriver();
                }
                case "grid-edge" -> {
                    caps.setCapability("browserName", "MicrosoftEdge");
                    return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
                }
                case "grid-firefox" -> {
                    caps.setCapability("browserName", "firefox");
                    return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
                }
                case "grid-chrome" -> {
                    caps.setCapability("browserName", "chrome");
                    return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
                }
                case "cloud" -> {
                    return lambdaTest();

                }
                default -> {
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--remote-allow-origins=*");
                    return driver = new ChromeDriver(options);
                }
            }

    }
        @AfterMethod
        public void tearDownBrowser () {
            getDriver().quit();
            threadDriver.remove();
        }





        public static WebDriver lambdaTest() throws MalformedURLException {
            String hubURL = "https://hub.lambdatest.com/wd/hub";

            ChromeOptions browserOptions = new ChromeOptions();
            browserOptions.setPlatformName("Windows 10");
            browserOptions.setBrowserVersion("111.0");
            HashMap<String, Object> ltOptions = new HashMap<String, Object>();

            ltOptions.put("username", "lamas0411");
            ltOptions.put("accessKey", "b9fvmMXWzAoLxzgyz9gy7rh4iJvDKLtxJtIm5n2c6l6OgUoEh5");
            ltOptions.put("project", "Test Project");
            ltOptions.put("selenium_version", "4.0.0");
            ltOptions.put("w3c", true);
            browserOptions.setCapability("LT:Options", ltOptions);
            return new RemoteWebDriver(new URL(hubURL), browserOptions);
        }


            public void submitButton () {
                WebElement submitButtonElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type ='submit']")));
                submitButtonElement.click();
            }

            public void provideEmail (String email) {
                WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type ='email']")));
                emailField.sendKeys(email);

            }

            public void providePassword (String password) {
                WebElement provideField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type ='password']")));
                provideField.sendKeys(password);
            }

            public void searchSong () {
                WebElement findSong = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='submit'")));
                findSong.sendKeys();
            }

            public void clickViewAllButton () {
                WebElement ViewAllButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[data-test='view-all-songs-btn']")));
                ViewAllButton.click();

            }

            public void selectFirstSong () {
                WebElement FirstSong = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("section#songResultsWrapper tr.song-item td.title")));
                FirstSong.click();

            }

            public void openPlaylist () {
                WebElement emptyPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".playlist:nth-child(3)")));
                emptyPlaylist.click();
            }

            public void deletePlaylist () {
                WebElement deletePlaylistButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn-delete-playlist")));
                deletePlaylistButton.click();
            }

            public String getNotificationMsg () { //replaced method to return String value for getText()
                WebElement NotificationMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
                return NotificationMsg.getText();
            }

            public boolean songIsPlaying () { //replaced method to return boolean value for isDisplayed()
                WebElement isSongPlaying = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='bars']")));
                return isSongPlaying.isDisplayed();
            }

            public boolean isDeletedPlaylistMsgDisplayed () {//replaced method to return boolean value for isDisplayed()
                WebElement deletedPlaylistMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
                return deletedPlaylistMsg.isDisplayed();
            }





        }



