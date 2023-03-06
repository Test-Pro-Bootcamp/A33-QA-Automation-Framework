import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;


public class BaseTest {

    public static WebDriver driver = null;

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public static void launchBrowser() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

    }

    @AfterMethod
    public static void closeBrowser() {
        driver.quit();
    }

    public static void navigateToPage(String url) {
        driver.get(url);
    }

    public static void provideEmail(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("[type = 'email']"));
        emailField.sendKeys(email);
    }

    public static void providePassword(String password) {
        WebElement passwordField = driver.findElement(By.cssSelector("[type = 'password']"));
        passwordField.sendKeys(password);
    }

    public static void clickSubmit() {
        WebElement submitButton = driver.findElement(By.cssSelector("button[type = 'submit']"));
        submitButton.click();
    }


    public void enterAllSongs() throws InterruptedException {
        WebElement allSongs = driver.findElement(By.cssSelector("a[href='#!/songs']"));
        Thread.sleep(1000);
        allSongs.click();
    }

    public void selectSong() throws InterruptedException {
        WebElement song = driver.findElement(By.xpath("//tr[@class='song-item']"));
        Thread.sleep(1000);
        song.click();
    }

    public void enterButtonPlaySong() {
        WebElement buttonPlaySong = driver.findElement(By.xpath("//span[@title='Play or resume']"));
        Actions actions = new Actions(driver);
        actions.click(buttonPlaySong).perform();
    }


    public boolean isDisplayedPlayingSong() {

        WebElement songIsPlaying = driver.findElement(By.cssSelector("[data-testid = 'sound-bar-play']"));
        return songIsPlaying.isDisplayed();


    }

}
