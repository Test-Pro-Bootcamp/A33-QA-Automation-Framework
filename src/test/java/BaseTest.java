import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
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

    WebDriver driver;

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUpBrowser() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }

    public void urlAccess() throws InterruptedException {
        String url = "https://bbb.testpro.io/";
        driver.get(url);
        driver.manage().window().maximize();
        Thread.sleep(1000);
    }

    public void getEmail(String email) throws InterruptedException {
        WebElement insertEmail = driver.findElement(By.xpath("//input[@type='email']"));
        insertEmail.click();
        insertEmail.sendKeys(email);
        Thread.sleep(1000);
    }

    public void getPassword(String password) throws InterruptedException {
        WebElement insertEmail = driver.findElement(By.xpath("//input[@type='password']"));
        insertEmail.click();
        insertEmail.sendKeys(password);
        Thread.sleep(1000);
    }

    public void loginUser() throws InterruptedException {
        WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
        submitButton.click();
        Thread.sleep(1000);
    }

    public void clickPlayNextSong() throws InterruptedException {
        WebElement playNextSongButton = driver.findElement(By.xpath("//i[@data-testid='play-next-btn']"));
        WebElement playSongButton = driver.findElement(By.xpath("//span[@data-testid='play-btn']"));
        playNextSongButton.click();
        playSongButton.click();
    }

    public boolean songPlayIsDisplayed() throws InterruptedException {
        WebElement songIsPlaying = driver.findElement(By.xpath("//progress[@class='plyr__progress--played']"));
        Thread.sleep(1000);
        return songIsPlaying.isDisplayed();
    }
}
