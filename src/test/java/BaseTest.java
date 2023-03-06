import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import java.time.Duration;
import org.openqa.selenium.Keys;
public class BaseTest {
    WebDriver driver = null;
    WebDriverWait wait;
    String url;

    @BeforeSuite
    public void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    @Parameters("baseUrl")
    public void launchBrowser(String baseUrl) {
        driver = new ChromeDriver();
        url = baseUrl;
        driver.get(url);
        wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        driver.manage().window().maximize();
    }
    public void playSong() {
        WebElement buttonPlayNextSong = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-testid='play-next-btn']")));
        //WebElement buttonPlayNextSong = driver.findElement(By.cssSelector("[data-testid='play-next-btn']"));
        buttonPlayNextSong.click();

        WebElement playButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-testid='play-btn']")));
        playButton.click();
    }
    public void logIn(String email, String password) {
        WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type = 'email']")));
        //WebElement emailField = driver.findElement(By.cssSelector("[type = 'email']"));
        emailField.sendKeys(email);

        WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type = 'password']")));
        //WebElement passwordField = driver.findElement(By.cssSelector("[type = 'password']"));
        passwordField.sendKeys(password);

        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type = 'submit']")));
        //WebElement submitButton = driver.findElement(By.cssSelector("[type = 'submit']"));
        submitButton.click();
    }
    public WebElement getDeletedPlaylistMessage(){
        return driver.findElement(By.cssSelector("div.success.show"));
}
    public void openPlaylist() {
        WebElement emptyPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".playlist:nth-child(3)")));
        //WebElement emptyPlaylist = driver.findElement(By.cssSelector(".playlist:nth-child(3)"));
        emptyPlaylist.click();
}
    public void deletePlaylist() {
        WebElement deletePlaylistButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn-delete-playlist")));
        //WebElement deletePlaylistButton = driver.findElement(By.cssSelector(".btn-delete-playlist"));
        deletePlaylistButton.click();

    }
    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
}

