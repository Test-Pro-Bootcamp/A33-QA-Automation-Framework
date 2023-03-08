import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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
public static WebDriver driver = null;
public static String url = null;
protected static WebDriverWait wait;
protected static Actions actions;
protected static Actions action;

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    @Parameters({"baseUrl"})
    public static void launchBrowser(String baseUrl){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        action = new Actions(driver);
        url = baseUrl;
        driver.get(url);
    }
    public static void provideEmail(String email){
        WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector
                ("[type='email']")));
        emailField.clear();
        emailField.sendKeys(email);
    }
    public static void providePassword(String password){
        WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector
                ("[type='password']")));
        passwordField.clear();
        passwordField.sendKeys(password);
    }
    public static void clickSubmit(){
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector
                ("button[type='submit']")));
        submitButton.click();
    }
    public void login(String email, String password){
        provideEmail(email);
        providePassword(password);
        clickSubmit();
    }
    public void contextClickExistingPlaylist(String existingPlaylistName){
        WebElement clickExistingPlaylist = wait.until(ExpectedConditions.presenceOfElementLocated
                (By.cssSelector("li[class='playlist playlist']")));
        action.click(clickExistingPlaylist).perform();
        action.contextClick(clickExistingPlaylist).perform();
    }
    public void chooseEdit (){
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector
                ("li[data-testid='playlist-context-menu-edit-47144']"))).click();
    }
    public void renamePlaylistName(String newPlaylistName){
        WebElement enterPlaylistName = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector
                ("input[name='name']")));
        enterPlaylistName.sendKeys(Keys.CONTROL + "a");
        enterPlaylistName.sendKeys(Keys.DELETE);
        enterPlaylistName.sendKeys(newPlaylistName);
        enterPlaylistName.sendKeys(Keys.ENTER);
    }
    public boolean displayUpdatedPlaylist(String newPlaylistName){
        WebElement updatedPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//a[text()= '" +newPlaylistName+"']")));
        return updatedPlaylist.isDisplayed();
    }
@AfterMethod
    public void closeBrowser(){
        driver.quit();
}

}
