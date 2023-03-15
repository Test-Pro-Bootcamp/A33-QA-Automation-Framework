import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.time.Duration;


public class BaseTest {
    public static WebDriver driver;
    public static WebDriverWait wait;

    public static Actions actions;



    @BeforeSuite
    @Parameters({"BaseURL"})
    public static void setupClass(String BaseURL) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);

        String URL = BaseURL;
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
    }


    @AfterMethod
    public static void closeBrowser() {driver.quit();}








    public static void login(String email, String password) {
        WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='email']")));
        emailField.sendKeys(email);
        WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='password']")));
        passwordField.sendKeys(password);
        WebElement submitBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='submit']")));
        submitBtn.click();
    }


    public static void rightClickOnPlaylist(String playlistName){
        WebElement playlistlink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText(playlistName)));
        actions.doubleClick(playlistlink).perform();
        //doubleclick
       // WebElement playlistDeleteBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[contains(text(),'edit')]")));
        //playlistDeleteBtn.click();
    }


    public static void putPlaylistName(String setPlaylistName) {
        WebElement playlistNameField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@data-testid='inline-playlist-name-input']")));
       // playlistNameField.sendKeys(setPlaylistName);
        playlistNameField.sendKeys(Keys.chord(Keys.COMMAND, "a", Keys.BACK_SPACE));
        playlistNameField.sendKeys(setPlaylistName);
        playlistNameField.sendKeys(Keys.ENTER);

    }




    public static boolean ifNewPlaylistExists(){
        WebElement newPlaylistName = driver.findElement(By.xpath("//a[text()='"+"Ferrari"+"']"));
        return newPlaylistName.isDisplayed();
    }







}
