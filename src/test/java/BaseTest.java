import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
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



    @BeforeSuite
    @Parameters({"BaseURL"})
    public static void setupClass(String BaseURL) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
       // String baseURL = "https://bbb.testpro.io/";
        String url = BaseURL;
        driver.get(url);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterMethod
    static void close() { driver.quit();}

    public static void login(String email, String password){
        WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='email']")));
        emailField.sendKeys(email);
        WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='password']")));
        passwordField.sendKeys(password);
        WebElement submitBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='submit']")));
        submitBtn.click();
    }
    public WebElement getPlaylistRemovalMsg(){
        return driver.findElement(By.cssSelector("div.success.show"));
    }

    public void playlistClick(String playlistName) throws InterruptedException {
        WebElement playlistlink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText(playlistName)));
        playlistlink.click();
    }
    public void platlistRemove() {
        WebElement deleteButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Delete this playlist']")));
        deleteButton.click();
        WebElement PlaylistDeleteConfirmation = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.ok")));
        if (PlaylistDeleteConfirmation.isDisplayed()==true) {
            PlaylistDeleteConfirmation.click();
        }
    }




}
