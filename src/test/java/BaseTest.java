import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.time.Duration;


public class BaseTest {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters({"baseURL"})
    public void setUpBrowser(String baseURL) {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseURL);
        wait = new WebDriverWait(driver, Duration.ofSeconds(4));
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }

    public void openPlayLis() throws InterruptedException {
        WebElement emptyPlayList = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".playlist:nth-child(3)")));
        emptyPlayList.click();
    }

    public WebElement getDeletedMessage() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.success.show")));
    }

    public void deletePlayList() throws InterruptedException {
        WebElement deletePlaylistButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn-delete-playlist")));
        deletePlaylistButton.click();
    }

    public void urlAccess() throws InterruptedException {
        String url = "https://bbb.testpro.io/";
        driver.get(url);
    }

    public void getEmail(String email) throws InterruptedException {
        WebElement insertEmail = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='email']")));
        insertEmail.click();
        insertEmail.sendKeys(email);
    }

    public void getPassword(String password) throws InterruptedException {
        WebElement insertEmail = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='password']")));
        insertEmail.click();
        insertEmail.sendKeys(password);
    }

    public void loginUser() throws InterruptedException {
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
        submitButton.click();
    }

    public void clickPlayNextSong() throws InterruptedException {
        WebElement playNextSongButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@data-testid='play-next-btn']")));
        WebElement playSongButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@data-testid='play-btn']")));
        playNextSongButton.click();
        playSongButton.click();
    }

    public boolean songPlayIsDisplayed() throws InterruptedException {
        WebElement songIsPlaying = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//progress[@class='plyr__progress--played']")));
        return songIsPlaying.isDisplayed();
    }
}
