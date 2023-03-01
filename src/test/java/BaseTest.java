import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

/* creating changes */


public class BaseTest {
    WebDriver driver;
    @BeforeMethod
    public void setUpBrowser () {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
    }
    @BeforeMethod
    public void tearDownBrowser() {

        driver.quit();
    }
    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

}
