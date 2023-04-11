
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
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

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

public class BaseTest {
    static WebDriver driver;
    WebDriverWait wait;
    String url = "https://bbb.testpro.io/";

    ThreadLocal<WebDriver> threadDriver;
    //    @BeforeSuite
//    static void setupClass() {
//        WebDriverManager.chromedriver().setup();
//    }
    String playlistName = "Emiliia's Fun";

    @BeforeMethod
    public void setUpBrowser () throws MalformedURLException {

        driver = pickBrowser(System.getProperty("browser"));
        threadDriver = new ThreadLocal<>();
        threadDriver.set(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        driver.get(url);
    }

    public WebDriver lambdaTest () throws MalformedURLException {
        String hubURL = "https://hub.lambdatest.com/wd/hub";

        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("MacOS Ventura");
        browserOptions.setBrowserVersion("111.0");
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("username", "kristinaostropolets");
        ltOptions.put("accessKey", "6cIGa2HGbr4u0tjvBFCgijWWQXvB40FGyYHIrEJDFfhKsfWfLK");
        ltOptions.put("timezone", "New_York");
        ltOptions.put("project", "Test Project");
        ltOptions.put("selenium_version", "4.0.0");
        ltOptions.put("w3c", true);
        browserOptions.setCapability("LT:Options", ltOptions);

        return new RemoteWebDriver(new URL(hubURL), browserOptions);
    }

    public WebDriver pickBrowser (String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL = "http://192.168.1.160:4444";

        switch (browser) {
            case "Safari":
                WebDriverManager.safaridriver().setup();
                return driver = new SafariDriver();
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return driver = new FirefoxDriver();
            case "MicrosoftEdge":
                WebDriverManager.edgedriver().setup();
                return driver = new EdgeDriver();
            case "grid-edge":
                caps.setCapability("browserName", "MicrosoftEdge");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "grid-firefox":
                caps.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "grid-chrome":
                caps.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "cloud":
                return lambdaTest();
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                return driver = new ChromeDriver(options);
        }
    }

    @AfterMethod
    public static void tearDownBrowser () {
        driver.quit();
    }

    public void login () {
        provideEmail("krista_ua86@gmail.com");
        providePassword("te$t$tudent");
        submit();
    }

    public void provideEmail (String email) {
        WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='email']")));
        emailField.sendKeys(email);
    }

    public void providePassword (String password) {
        WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='password']")));
        passwordField.sendKeys(password);
    }

    public void submit () {
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='submit']")));
        submitButton.click();
    }

    public String getDeletedPlaylistMsg () {
        WebElement notificationMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notificationMsg.getText();
    }

    public void openPlaylist () {
        WebElement emptyPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".playlist:nth-child(3)")));
        emptyPlaylist.click();
    }

    public void clickDeletePlaylistBtn () {
        WebElement deletePlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn-delete-playlist")));
        deletePlaylist.click();
    }

    public void enterPlaylistNewName () {
//
        WebElement playlistInputField = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='name']")));
        Actions actions = new Actions(driver);
        actions.doubleClick(playlistInputField).perform();
// Send keys to the playlist name element to enter a new name
        actions.sendKeys(Keys.chord(Keys.CONTROL), playlistName).perform();
// Press the Enter key to save the changes
        actions.sendKeys(Keys.ENTER).perform();

    }


    private void doubleClickOnPlaylist () {
        Actions action = new Actions(driver);
        WebElement playlist = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".playlist:nth-child(3)")));
        action.doubleClick(playlist).perform();

    }
}



