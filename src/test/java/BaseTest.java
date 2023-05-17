import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.*;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

public class BaseTest {
        public static WebDriver driver;
        public WebDriverWait wait = null;
        public String url = null;
        public Actions actions = null;
        ThreadLocal <WebDriver> threadDriver;
    @BeforeSuite
    static void setupClass() {
        //WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    @Parameters({"BaseUrl"})
    public void launchBrowser(String BaseUrl) throws MalformedURLException {
        threadDriver = new ThreadLocal<>();
        driver = pickBrowser(System.getProperty("browser"));
        threadDriver.set(driver);
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--disable-notifications", "--remote-allow-origins=*", "--incognito", "--start-maximized");
//        driver = new ChromeDriver(options);
//        wait = new WebDriverWait(driver, Duration.ofSeconds(4));
          actions = new Actions(driver);
          getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
          url = BaseUrl;
          getDriver().get(url);
    }
    private WebDriver pickBrowser(String browser) throws MalformedURLException {
          DesiredCapabilities caps = new DesiredCapabilities();
          String gridURL = "http://172.20.10.2:4444";
        switch (browser) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return driver = new FirefoxDriver();
            case "safari":
                WebDriverManager.safaridriver().setup();
                return driver = new SafariDriver();
            case "grid-firefox":
                caps.setCapability("browserName", "Firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(),caps);
            case "grid-safari":
                caps.setCapability("browserName", "Safari");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(),caps);
            case "lambda":
                return lambdaTest();
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                return driver = new ChromeDriver(options);
        }
    }
    @AfterMethod
    public void closeDownBrowser() {getDriver().quit();
        threadDriver.remove();
    }
    public WebDriver getDriver() {
        return threadDriver.get();
    }
    public WebDriver lambdaTest() throws MalformedURLException {
        String hubURL = "http://hub.lambdatest.com/wd/hub";
        EdgeOptions browserOptions = new EdgeOptions();
        browserOptions.setPlatformName("Windows 10");
        browserOptions.setBrowserVersion("111.0");
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("username", "vera1077");
        ltOptions.put("accessKey", "PTb1KgRWQIeRSlxTTfXEsU5tb11BeDMiE1nPLNFP2SKF7gwNnW");
        ltOptions.put("project", "Test Project");
        ltOptions.put("w3c", true);
        ltOptions.put("plugin", "java-testNG");
        browserOptions.setCapability("LT:Options", ltOptions);
        return new RemoteWebDriver(new URL(hubURL), browserOptions);
    }
//    public void provideEmail(String email) {
//        WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='email']")));
//        emailField.sendKeys(email);
//    }
//    public void providePassword(String password) {
//        WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='password']")));
//        passwordField.sendKeys(password);
//    }
//    public void clickSubmit() {
//        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='submit']")));
//        submitButton.click();
//    }
}
