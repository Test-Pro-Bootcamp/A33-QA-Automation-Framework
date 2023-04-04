
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;


import java.time.Duration;

public class BaseTest {
static WebDriver driver;
    WebDriverWait wait;
    String url="https://bbb.testpro.io/";
    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    String playlistName ="Emiliia's Fun";

@BeforeMethod
public void setUpBrowser() {
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--remote-allow-origins=*");
    driver = new ChromeDriver(options);
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.manage().window().maximize();
    wait = new WebDriverWait(driver, Duration.ofSeconds(4));
    driver.get(url);
}
    @AfterMethod
    public static void tearDownBrowser() {
        driver.quit();
    }
    public void login() {
        provideEmail("krista_ua86@gmail.com");
        providePassword("te$t$tudent");
        submit();
    }

    public void provideEmail(String email) {
        WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='email']")));
        emailField.sendKeys(email);
    }

    public void providePassword(String password) {
        WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='password']")));
        passwordField.sendKeys(password);
    }

    public void submit()  {
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='submit']")));
        submitButton.click();
    }
    public String getDeletedPlaylistMsg(){
        WebElement notificationMsg=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notificationMsg.getText();
    }
    public void openPlaylist() {
        WebElement emptyPlaylist =wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".playlist:nth-child(3)")));
        emptyPlaylist.click();
    }

    public void clickDeletePlaylistBtn() {
        WebElement deletePlaylist= wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn-delete-playlist")));
        deletePlaylist.click();
    }

    public void enterPlaylistNewName() {
//
        WebElement playlistInputField = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[data-testid='inline-playlist-name-input']")));
        Actions actions = new Actions(driver);
        actions.doubleClick(playlistInputField).perform();
// Send keys to the playlist name element to enter a new name
        actions.sendKeys(Keys.chord(Keys.CONTROL), playlistName).perform();
// Press the Enter key to save the changes
        actions.sendKeys(Keys.ENTER).perform();

    }


    private void doubleClickOnPlaylist(){
        Actions action = new Actions(driver);
        WebElement playlist = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".playlist:nth-child(3)")));
        action.doubleClick(playlist).perform();

    }


}



