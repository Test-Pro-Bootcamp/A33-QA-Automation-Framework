import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

public class BaseTest {

    private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();
    private static WebDriver driver;
    protected static WebDriverWait wait;
    protected String password = "";
    protected String email = "";
    protected String homeUrl = "";
    private final static int TIME = 11; // time to set up implicitlyWait for the browser


//    @BeforeSuite
//    protected static void setUpClass () {
//        WebDriverManager.chromedriver().setup();
//    }

    public static WebDriver getDriver () {
        return threadDriver.get();
    }
    @BeforeMethod
    @Parameters ({"BaseUrl", "LoginEmail", "LoginPassword"})
    public void setUpBrowser (String BaseUrl, String LoginEmail, String LoginPassword) throws MalformedURLException{
        email = LoginEmail;
        password = LoginPassword;
        homeUrl = BaseUrl;
        threadDriver.set(pickBrowser("browser")); //System.getProperty("browser")
        threadDriver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(TIME));
        threadDriver.get().manage().window().maximize();
        threadDriver.get().manage().deleteAllCookies();
        System.out.println("Thread working is " + Thread.currentThread().getId() + "driver: " + getDriver());
    }

    private static WebDriver lambdaTest() throws MalformedURLException {
        String username = "meelevchenko";
        String authkey = "3D71epOtVUMBbR20o0BuJGiEXuSTmPQfY9ow5WRE1YSGLeR6lh";
        String hub = "@hub.lambdatest.com/wd/hub";

        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 10");
        browserOptions.setBrowserVersion("109.0");
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("username", username);
        ltOptions.put("accessKey", authkey);
        ltOptions.put("project", "Untitled");
        ltOptions.put("selenium_version", "4.0.0");
        ltOptions.put("w3c", true);
        browserOptions.setCapability("LT:Options", ltOptions);
        System.out.println("Cloud testing is working!");

        return new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hub), browserOptions);
    }
    private static WebDriver pickBrowser (String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridUrl = "http://172.17.0.1:5555";
        System.out.println(browser);
        if (browser == null) {browser = "";}
        switch (browser) {
            case "firefox":
               WebDriverManager.firefoxdriver().setup();
               FirefoxOptions firefoxOptions = new FirefoxOptions();
               firefoxOptions.setBinary("/usr/bin/firefox/firefox");
               return driver = new FirefoxDriver(firefoxOptions);
            case "MicrosoftEdge":
                WebDriverManager.edgedriver().setup();
                return driver = new EdgeDriver();
            case "safari":
                WebDriverManager.safaridriver();
                return driver  = new SafariDriver();
            case "grid-firefox":
                caps.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridUrl).toURL(),caps);
            case "grid-edge":
                caps.setCapability("browserName", "MicrosoftEdge");
                return driver = new RemoteWebDriver(URI.create(gridUrl).toURL(),caps);
            case "grid-chrome":
                caps.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridUrl).toURL(),caps);
            case "cloud":
                return lambdaTest();
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions options  = new ChromeOptions();
                options.addArguments("--disable-notifications", "--remote-allow-origins=*", "--incognito");
                return driver = new ChromeDriver(options);
        }
    }

    @AfterMethod
    public void closeBrowser () {
        threadDriver.get().close();
        threadDriver.remove();
    }
}
