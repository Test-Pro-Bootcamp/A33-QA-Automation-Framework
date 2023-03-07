import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.Duration;


public class BaseTest {

    public static WebDriver driver = null;
    public static String url = null;

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters ({"BaseURL"})
    public void setUpBrowser(String BaseURL) {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(BaseURL);
    }
    public static void enterEmail(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("[type = 'email']"));
        emailField.click();
        emailField.sendKeys(email);
    }

    public static void enterPassword(String password) {
        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        passwordField.click();
        passwordField.sendKeys(password);
    }

    public static void clickSubmit() throws InterruptedException {
        WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
        submitButton.click();
        Thread.sleep(2000);
    }
    public void clickXPlaylist() {
        WebElement clickX = driver.findElement(By.cssSelector("button[title='Delete this playlist']"));
        clickX.click();
    }
    public void clickPlaylistToDelete() {
        WebElement clickToDelete = driver.findElement(By.xpath("//*[@id=\"playlists\"]/ul/li[3]/a"));
        clickToDelete.click();
    }
    public static boolean verifyNotification(){
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
    public static void closeBrowser(){
        driver.quit();
    }
}
