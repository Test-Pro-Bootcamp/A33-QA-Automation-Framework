import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.*;
import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {
    WebDriver driver;
    WebDriverWait wait;
    String url;
    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters ({"BaseURL"})
    public void setUpBrowser(String BaseURL) {
        driver = new ChromeDriver();
        url = BaseURL;
        driver.get(url);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    By enterEmailAddress = By.cssSelector(("[type = 'email']"));
    By passwordField = By.cssSelector(("[type='password']"));
    By submitButton = By.cssSelector(("[type='submit']"));

    public void logIn() {
        enterEmail("linulya1411@gmail.com");
        enterPassword("te$t$tudent");
        clickSubmit();
    }
    public  void enterEmail(String email) {
        WebElement emailElement = wait.until(ExpectedConditions.elementToBeClickable(enterEmailAddress));
        emailElement.sendKeys();
    }
    public void enterPassword(String password) {
        WebElement passwordElement = wait.until(ExpectedConditions.elementToBeClickable(passwordField));
        passwordElement.sendKeys();
    }

    public void clickSubmit() {
        WebElement submitElement = wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        //submitElement.click();

    }
    public void clickXPlaylist() {
        WebElement clickX = driver.findElement(By.cssSelector("button[title='Delete this playlist']"));
        clickX.click();
    }
    public void clickPlaylistToDelete() {
        WebElement clickToDelete = driver.findElement(By.xpath("//*[@id=\"playlists\"]/ul/li[3]/a"));
        clickToDelete.click();
    }
    public boolean verifyNotification(){
        WebElement notificationMessage = driver.findElement(By.cssSelector("div.success.show"));
        return notificationMessage.isDisplayed();
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

