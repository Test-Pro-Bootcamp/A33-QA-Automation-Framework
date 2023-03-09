import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
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
    public  void setUpBrowser() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    protected void openBrowser(){
        String url = "https://bbb.testpro.io/";
        driver.get(url);
    }
    public void closeBrowser(){
        driver.quit();
    }
    public void enterEmail(){
        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        emailField.click();
        emailField.sendKeys("rfkayoub12@gmail.com");
    }

    public void enterPassword(){
        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        passwordField.click();
        passwordField.sendKeys("te$t$tudent");
    }
    public void submit() throws InterruptedException {
        WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
        submitButton.click();
        Thread.sleep(2000);
    }

    public void searchForSong() throws InterruptedException {
        WebElement searchField = driver.findElement(By.cssSelector("[type='search']"));
        searchField.click();
        searchField.sendKeys("Lament");
        Thread.sleep(2000);
    }
    public void clickViewAll() throws InterruptedException {
        WebElement viewAll = driver.findElement(By.cssSelector("[data-test='view-all-songs-btn']"));
        viewAll.click();
        Thread.sleep(2000);
    }
    public void clickFirstSong() throws InterruptedException {
        WebElement firstSong = driver.findElement(By.cssSelector("#songResultsWrapper > div > div > div.item-container > table > tr > td.title"));
        firstSong.click();
        Thread.sleep(2000);


    }
    public void clickAddTo() throws InterruptedException {
        WebElement addToBtn = driver.findElement(By.cssSelector("[class='btn-add-to']"));
        addToBtn.click();
        Thread.sleep(2000);
    }

    public void choosePlaylist() throws InterruptedException {
        WebElement chosenPlaylist = driver.findElement(By.cssSelector("#songResultsWrapper > header > div.song-list-controls > div > section.existing-playlists > ul > li:nth-child(6)"));
        chosenPlaylist.click();
        Thread.sleep(5000);
    }
    public String getNotification(){
        WebElement notificationElement = driver.findElement(By.cssSelector("div.success.show"));
        return notificationElement.getText();
    }
    public void clickNext() throws InterruptedException {
        WebElement nextBtn = driver.findElement(By.cssSelector("[data-testid ='play-next-btn']"));
        nextBtn.click();
        Thread.sleep(2000);
    }
    public void clickPlay() throws InterruptedException {
        WebElement playBtn = driver.findElement(By.cssSelector("[data-testid='play-btn']"));
        playBtn.click();
        Thread.sleep(2000);
    }
    public Boolean isSongPlaying(){
        WebElement songIsPLaying = driver.findElement(By.cssSelector("[class='plyr__progress--seek']"));
        return songIsPLaying.isDisplayed();
    }
}
