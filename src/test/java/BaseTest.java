import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;


public class BaseTest {
    public static WebDriver driver = null;

    @BeforeSuite
    static void setupClass(){
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    public static void setUpBrowser(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterMethod
    public static void closeBrowser(){
        driver.quit();
    }
    public static void urlAccess() throws InterruptedException {
        String url = "https://bbb.testpro.io/";
        driver.get(url);
        driver.manage().window().maximize();
        Thread.sleep(2000);
    }

    public static void getEmail(String email) throws InterruptedException {
        WebElement insertEmail = driver.findElement(By.cssSelector("[type='email']"));
        insertEmail.click();
        insertEmail.sendKeys(email);
        Thread.sleep(2000);
    }

    public static void getPassword(String password) throws InterruptedException {
        WebElement insertEmail = driver.findElement(By.cssSelector("[type='password']"));
        insertEmail.click();
        insertEmail.sendKeys(password);
        Thread.sleep(2000);
    }

    public static void clickSubmit() {
        WebElement submitButtonElement = driver.findElement(By.cssSelector("[type='submit']"));
        submitButtonElement.click();
    }

    public static void playSong() throws InterruptedException {
        WebElement playButton = driver.findElement(By.xpath("//span[@data-testid='play-btn']"));
        WebElement clickNextSongButton = driver.findElement(By.xpath("//i[@data-testid='play-next-btn']"));

        clickNextSongButton.click();
        playButton.click();
    }

    public boolean isSongPlaying() throws InterruptedException {
        WebElement soundBar = driver.findElement(By.xpath("//div[@data-testid='sound-bar-play']"));

        return soundBar.isDisplayed();
    }
}
