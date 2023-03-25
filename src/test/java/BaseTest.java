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
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Action;


public class BaseTest {
    private static final ThreadLocal<WebDriver> THREAD_LOCAL = new ThreadLocal<>();
    public String url = "https://bbb.testpro.io/";
    private WebDriver driver;
    public static WebDriver getThreadLocal() {
        return THREAD_LOCAL.get();
    }
//    public WebDriver driver;
//    public ThreadLocal<WebDriver> threadDriver;
//    //WebDriver driver = null;
//    Actions actions;
//    WebDriverWait wait;
//    String url;

    //@BeforeSuite
    //public void setupClass() {
        //WebDriverManager.chromedriver().setup();
    //}
    @BeforeMethod
    @Parameters({"BaseURL"})
    //public void launchBrowser(String BaseURL) throws MalformedURLException {
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--remote-allow-origins=*");
//        driver = new ChromeDriver(options);
//        driver = new SafariDriver();
//
        public void setUpBrowser(@Optional String baseURL) throws MalformedURLException {
            THREAD_LOCAL.set(pickBrowser("browser"));
            THREAD_LOCAL.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            THREAD_LOCAL.get().manage().window().maximize();
            THREAD_LOCAL.get().manage().deleteAllCookies();
            getThreadLocal().get(url);
            System.out.println(
                    "Browser setup by Thread " + Thread.currentThread().getId() + " and Driver reference is : " + getThreadLocal());

        }
//        threadDriver = new ThreadLocal<>();
//        driver = pickBrowser(System.getProperty("browser"));
//        threadDriver.set(driver);
//
//        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//        url = BaseURL;
//        getDriver().get(BaseURL);
//        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        actions = new Actions(driver);
//        driver.manage().window().maximize();
//    }

        public WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL = "http://192.168.86.39:4444";

        switch (browser){
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions optionsFirefox = new FirefoxOptions();
                optionsFirefox.addArguments("-private");
                return driver = new FirefoxDriver();
            case "MicrosoftEdge":
                WebDriverManager.edgedriver().setup();
                return driver = new EdgeDriver();
            case "safari":
                WebDriverManager.safaridriver().setup();
                return driver = new SafariDriver();
            case "grid-edge":
                caps.setCapability("browserName", "MicrosoftEdge");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "grid-firefox":
                caps.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "grid-chrome":
                caps.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "grid-safari":
                caps.setCapability("browserName", "safari");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "lambda":
                return newLambdaTest();
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*","--disable-notifications","--incognito","--start-maximized");
                return driver = new ChromeDriver(options);
        }
    }
//    public WebDriver getDriver() {
//        return threadDriver.get();
//    }
    public WebDriver newLambdaTest() throws MalformedURLException {
        String hubURL = "https://hub.lambdatest.com/wd/hub";

        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 10");
        browserOptions.setBrowserVersion("110.0");
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("username", "mandyregnier3");
        ltOptions.put("accessKey", "dAZ1MJWLcm5O21sGsHNdsBtg8VR7R5iPPEDequA8s8jKQhsrsU");
        ltOptions.put("project", "TestProject");
        ltOptions.put("w3c", true);
        ltOptions.put("plugin", "java-testNG");
        browserOptions.setCapability("LT:Options", ltOptions);

        return new RemoteWebDriver(new URL(hubURL), browserOptions);
    }
    @AfterMethod
    public void tearDown() {
        THREAD_LOCAL.get().close();
        THREAD_LOCAL.remove();
    }

}

