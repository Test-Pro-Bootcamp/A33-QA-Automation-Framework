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
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.time.Duration;


public class BaseTest {
    static WebDriver driver;
    static WebDriverWait wait;
    static String url = null;
    public Actions actions;
    public String playlistName = "Homework21";

    @BeforeSuite
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters({"baseURL"})
    public void launchBrowser(String baseURL) {
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(ops);
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        url = baseURL;
        driver.get(url);
        driver.manage().window().maximize();
    }

    public void provideEmail(String email) {
        WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='email']")));
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void providePassword(String password) {
        WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='password']")));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickSubmit() {
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='submit']")));
        submitButton.click();
    }

    public void logIn(String email, String password) {
        provideEmail(email);
        providePassword(password);
        clickSubmit();
    }

    public void doubleClick() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#playlists > ul > li:nth-child(4)")));
        WebElement playlistElement = driver.findElement(By.cssSelector("#playlists > ul > li:nth-child(4)"));
        actions.doubleClick(playlistElement).perform();
    }

    public void enterPlaylistName() {
        WebElement inputField1 = wait.until(ExpectedConditions.elementToBeClickable
                (By.cssSelector("input[name='name']")));
        inputField1.sendKeys(Keys.chord(Keys.CONTROL, "A", Keys.BACK_SPACE));
        inputField1.sendKeys(playlistName);
        inputField1.sendKeys(Keys.ENTER);
    }

    public boolean doesPlaylistExist() {
        WebElement playlistElement = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//a[text()='" + playlistName + "']")));
        return playlistElement.isDisplayed();
    }

}