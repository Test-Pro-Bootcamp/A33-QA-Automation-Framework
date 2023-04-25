import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
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
import java.time.Duration;
public class BaseTest {
        public static WebDriver driver;
        public WebDriverWait wait = null;
        public String url = null;
        public Actions actions = null;
    @BeforeSuite
    static void setupClass() {
        //WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    @Parameters({"BaseUrl"})
    public void launchBrowser() throws MalformedURLException {
        driver = pickBrowser(System.getProperty("browser"));
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--disable-notifications", "--remote-allow-origins=*", "--incognito", "--start-maximized");
//        driver = new ChromeDriver(options);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        wait = new WebDriverWait(driver, Duration.ofSeconds(4));
//        actions = new Actions(driver);
//          url = BaseUrl;
//          driver.get(BaseUrl);
    }
    private static WebDriver pickBrowser(String browser) {
//        DesiredCapabilities caps = new DesiredCapabilities();
//        String gridURL = "";
        switch (browser) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return driver = new FirefoxDriver();
            case "chrome":
                WebDriverManager.chromedriver().setup();
                return driver = new ChromeDriver();
//            case "grid-firefox":
//                caps.setCapability("browserName", "Firefox");
//                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(),caps);
//            case "grid-safari":
//                caps.setCapability("browserName", "Safari");
//                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(),caps);
            default: return driver = new SafariDriver();
        }
    }
    @AfterMethod
    public void closeDownBrowser() {driver.quit();
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
