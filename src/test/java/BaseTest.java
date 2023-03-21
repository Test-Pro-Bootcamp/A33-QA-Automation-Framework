import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;
public class BaseTest{
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static String url;
    public static Actions actions;
    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    @Parameters({"BaseURL"})
    public static void openBrowser(String BaseURL) {
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(option);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        url= BaseURL;
        driver.get(url);
    }
    @DataProvider(name="loginData")
    public static Object[][] getDataFromDataProviders(){
        return new Object[][]{
                {"linulya1411@gmail.com", "te$t$tudent"}
        };
    }
    @AfterMethod
    public  void closeBrowser(){
        driver.quit();
    }
}