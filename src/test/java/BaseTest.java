import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.time.Duration;

public class BaseTest {
    public static WebDriver driver= null;
    public static WebDriverWait wait = null;
    public static Actions actions = null;
    public static String url = null;

    @BeforeSuite
    public void setupClass() {
        WebDriverManager.chromedriver().setup();
    }


    @Parameters({"BaseURL"})
    @BeforeMethod
    public void launchBrowser(@Optional String BaseURL) throws MalformedURLException {
        driver = pickBrowser(System.getProperty("browser"));
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications","--remote-allow-origins=*","--start-maximized");
        driver = new ChromeDriver(options);
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(8));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        url = BaseURL;
        driver.get(url);

    }

    private static WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL ="http://192.168.0.2:4444";

        switch(browser){
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
                        caps.setCapability("browserName","chrome");
                        return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
                    default:
                        ChromeOptions options = new ChromeOptions();
                        options.addArguments("--remote-allow-origins=*","--disable-notifications", "--start-maximized");
                        return driver = new ChromeDriver(options);
                }
}

@AfterMethod
    public static void closeBrowser(){
        driver.quit();
}

}