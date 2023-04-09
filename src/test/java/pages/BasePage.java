package pages;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import java.time.Duration;
public class BasePage {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;
    String url;
    public BasePage(WebDriver givenDriver) {
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
    }

    public void contextClick(WebElement locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        actions.contextClick(locator).perform();
    }
    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    @Parameters({"BaseUrl"})
    public void launchBrowser(String BaseUrl) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications", "--remote-allow-origins=*", "--incognito", "--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        url = BaseUrl;
        driver.get(BaseUrl);
        wait = new WebDriverWait(driver, Duration.ofSeconds(4));
    }
}
