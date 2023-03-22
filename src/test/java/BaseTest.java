import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
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
    public static WebDriver driver = null;
    public static WebDriverWait wait;
    public static String url = null;
    public static Actions actions = null;
    static ThreadLocal<WebDriver> threadDriver;

    @BeforeMethod
    @Parameters({"baseUrl"})
    public static void launchBrowser(String baseUrl) throws MalformedURLException {
        threadDriver = new ThreadLocal<>();
        driver = pickBrowser(System.getProperty("browser"));
        threadDriver.set(driver);
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        getDriver().manage().window().maximize();
        actions = new Actions(getDriver());
        url = baseUrl;
        getDriver().get(url);
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));

    }

    public static WebDriver getDriver() {
        return threadDriver.get();
    }

    public static WebDriver lambdaTest() throws MalformedURLException {
        String hubURL="https://hub.lambdatest.com/wd/hub";

        FirefoxOptions browserOptions = new FirefoxOptions();
        browserOptions.setPlatformName("macOS High Sierra");
        browserOptions.setBrowserVersion("109.0");
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("username", "mohamed.taqi");
        ltOptions.put("accessKey", "Huh7gAMTZMLs0uQGivbRtFZBFuN9nLbY84CFsHnSwlQeepW7gq");
        ltOptions.put("project", "Untitled");
        ltOptions.put("w3c", true);
        ltOptions.put("plugin", "java-testNG");
        browserOptions.setCapability("LT:Options", ltOptions);

        return new RemoteWebDriver(new URL(hubURL),browserOptions);
    }
    private static WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL = "http://192.168.1.150:4444";
        switch (browser) {
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                return driver = new FirefoxDriver();
            }
            case "safari" -> {
                WebDriverManager.edgedriver().setup();
                return driver = new SafariDriver();
            }
            case "grid-firefox" -> {
                caps.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            }
            case "grid-safari" -> {
                caps.setCapability("browserName", "safari");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            }
            case "grid-chrome" -> {
                caps.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            }
            case "lambda" ->{
                return lambdaTest();
            }
            default -> {
                WebDriverManager.chromedriver().setup();
                ChromeOptions ops = new ChromeOptions();
                ops.addArguments("--remote-allow-origins=*");
                return driver = new ChromeDriver(ops);
            }
        }
    }

    @AfterMethod
    public static void closeBrowser() {
       getDriver().close();
       threadDriver.remove();
    }
}

