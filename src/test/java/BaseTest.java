import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;


public class BaseTest {
    public static WebDriver driver = null;
    private static final ThreadLocal<WebDriver> THREAD_LOCAL = new ThreadLocal<>();
    public static String url = null;

    @BeforeSuite
    public void setupClass() {
//        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    @Parameters({"baseUrl"})
    public void launchBrowser(@Optional String baseUrl) throws MalformedURLException {
        THREAD_LOCAL.set(pickBrowser("browser"));
        THREAD_LOCAL.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        THREAD_LOCAL.get().manage().deleteAllCookies();
        url = baseUrl;
        getDriver().get(url);
        System.out.println("Browser setup byThread" + Thread.currentThread().getId() + "and Driver reference is: " + getDriver());
    }
    public WebDriver lambdaTest() throws MalformedURLException {
        String username = "nelena35";
        String authkey = "6D9yzrrfh3h2EPqM7PBxkivvaSa3f20suqAfbajUojTSreJV36";
        String hub = "@hub.lambdatest.com/wd/hub";

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platform", "Windows 10");
        caps.setCapability("browserName", "Chrome");
        caps.setCapability("version", "110.0");
        caps.setCapability("resolution", "1024x768");
        caps.setCapability("build", "TestNG With Java");
        caps.setCapability("name", this.getClass().getName());
        caps.setCapability("plugin", "git-testng");
        return new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hub), caps);
    }
    public WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL = "http://192.168.0.115:4444";
        switch (browser) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions optionsFirefox = new FirefoxOptions();
                optionsFirefox.addArguments("-private");
                return driver = new FirefoxDriver(optionsFirefox);
            case "edge":
                WebDriverManager.edgedriver().setup();
                return driver = new EdgeDriver();
            case "grid-firefox":
                caps.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "grid-edge":
                caps.setCapability("browserName", "edge");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "grid-chrome":
                caps.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "cloud":
                return lambdaTest();
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions optionsChrome = new ChromeOptions();
                optionsChrome.addArguments("--remote-allow-origins=*","--disable-notifications","--start-maximized");
                return driver = new ChromeDriver(optionsChrome);
        }
    }
    @AfterMethod
    public void closeBrowser(){
        THREAD_LOCAL.get().close();
        THREAD_LOCAL.remove();
    }
    public static WebDriver getDriver(){
        return THREAD_LOCAL.get();
    }
}


