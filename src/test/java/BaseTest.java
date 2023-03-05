import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.*;
import java.time.Duration;
import org.openqa.selenium.Keys;
public class BaseTest {
    WebDriver driver = null;
    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    @Parameters("baseUrl")
    public void launchBrowser(String baseUrl) {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }
    public void playSong() throws InterruptedException {
        driver.findElement(By.cssSelector("[data-testid='play-next-btn']")).click();
        driver.findElement(By.cssSelector("[data-testid='play-btn']")).click();
    }
    public void logIn(String email, String password) {
        WebElement emailField = driver.findElement(By.cssSelector("[type = 'email']"));
        emailField.sendKeys(email);

        WebElement passwordField = driver.findElement(By.cssSelector("[type = 'password']"));
        passwordField.sendKeys(password);

        WebElement submitButton = driver.findElement(By.cssSelector("[type = 'submit']"));
        submitButton.click();
    }
    public WebElement getDeletedPlaylistMessage(){
        return driver.findElement(By.cssSelector("div.success.show"));
}
    public void openPlaylist() throws InterruptedException {
        WebElement emptyPlaylist = driver.findElement(By.cssSelector(".playlist:nth-child(3)"));
        emptyPlaylist.click();
        Thread.sleep(2000);
}
    public void deletePlaylist() throws InterruptedException {
        WebElement deletePlaylistButton = driver.findElement(By.cssSelector(".btn-delete-playlist"));
        deletePlaylistButton.click();
        Thread.sleep(2000);

    }
    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
}

