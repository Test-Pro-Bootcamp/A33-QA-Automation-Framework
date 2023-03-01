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
    String url = "https://bbb.testpro.io/";

    //These are the helper methods
    public void openLoginUrl() {
        driver.get(url);
    }
    public void provideEmail (String email) {
        WebElement emailField= driver.findElement(By.cssSelector("[type='email']"));
        emailField.sendKeys(email);
    }
    public void providePassword( String password) {
        WebElement passwordElement = driver.findElement(By.cssSelector("[type='password']"));
        passwordElement.sendKeys(password);
    }
    @BeforeMethod
    public void setUpBrowser() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterMethod
    public void exitBrowser () {
        driver.quit();
    }
    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    public void searchSong(String songTitleKeyword) throws InterruptedException {
        WebElement searchField = driver.findElement(By.cssSelector("[type='search']"));
        searchField.sendKeys(songTitleKeyword);
        Thread.sleep(2000);
    }
    public void viewAllSearchResults() throws InterruptedException {
        WebElement viewAllSearchResult = driver.findElement(By.cssSelector("div.results section.songs h1 button"));
        viewAllSearchResult.click();
        Thread.sleep(2000);
    }

    public void selectFirstSongResult() throws InterruptedException {
        WebElement viewAllFirstSongResult = driver.findElement(By.cssSelector("section#songResultsWrapper tr.song-item td.title"));
        viewAllFirstSongResult.click();
        Thread.sleep(2000);
    }

    public void clickAddToButton() throws InterruptedException {
        WebElement addTo = driver.findElement(By.cssSelector("button.btn-add-to"));
        addTo.click();
        Thread.sleep(2000);
    }
    public void choosePlaylist(String playlistName) throws InterruptedException {
        WebElement playlistNameElement = driver.findElement(By.cssSelector("[href='#!/favorites']"));
        playlistNameElement.click();
        Thread.sleep(2000);
    }
    public String getNotificationText() {
        WebElement notificationText = driver.findElement(By.cssSelector("div.success.show"));
        return notificationText.getText();
    }

    public void clickSubmit() {
        WebElement submitButtonElement = driver.findElement(By.cssSelector("[type='submit']"));
        submitButtonElement.click();
    }
}
