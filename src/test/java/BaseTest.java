import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import java.time.Duration;

public class BaseTest {
    static WebDriver driver;
    static WebDriverWait wait;
    static String url = "https://bbb.testpro.io";


    @BeforeMethod
    public void setUpBrowser() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications","--remote-allow-origins=*", "--incognito","--start-maximized");
        driver = new ChromeDriver(options);
        driver.get(url);
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
