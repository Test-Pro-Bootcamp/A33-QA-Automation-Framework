import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.time.Duration;


public class BaseTest {
static WebDriver driver;
String url=null;
    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
@Parameters({"baseURL"})
    @BeforeMethod
    public void launchBrowser(String baseURL){
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        url = baseURL;
        driver.get(url);
    }
    public static void provideEmail(String email) throws InterruptedException {
        WebElement emailField = driver.findElement(By.cssSelector("[type = 'email']"));
        emailField.click();
        emailField.sendKeys("taqimed99@gmail.com");
        Thread.sleep(2000);

    }

    public static void providePassword(String password) throws InterruptedException {
        WebElement passwordField = driver.findElement(By.cssSelector("[type = 'password']"));
        passwordField.click();
        passwordField.sendKeys("Med-20115-010499@");
        Thread.sleep(2000);

    }
    public void login() throws InterruptedException {
       provideEmail("taqimed99@gmail.com");
       providePassword("Med-20115-010499@");
    }

    public static void clickSubmit() throws InterruptedException {

        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitButton.click();
        Thread.sleep(2000);

    }

    public static void selectEmptyPlaylist() throws InterruptedException {

        WebElement selectPlaylist = driver.findElement(By.xpath("//*[@id='playlists']/ul/li[3]/a"));
        selectPlaylist.click();
        Thread.sleep(2000);
    }

    public static void deletePlaylist() throws InterruptedException {
        WebElement deletePlaylistbutton = driver.findElement(By.cssSelector("[class='del btn-delete-playlist']"));
        deletePlaylistbutton.click();
        Thread.sleep(2000);

    }

    public static boolean getDeletePlaylistMessage() {
        WebElement deletePlaylistMessage = driver.findElement(By.cssSelector("div.success.show"));
        return deletePlaylistMessage.isDisplayed();

    }

    @AfterMethod

    public static void closeBrowser() {

        driver.quit();

    }


}

