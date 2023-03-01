import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;


public class BaseTest {
    WebDriver driver;
    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    public void setUpBrowser() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    public void closeBrowser() {
        driver.quit();
    }
    public void getBrowser() {
        String url = "https://bbb.testpro.io/";
        driver.get(url);
    }
    public void emailField(String email){
        WebElement enterEmailFinder = driver.findElement(By.cssSelector("[type='email']"));
        enterEmailFinder.click();
        enterEmailFinder.sendKeys(email);
    }
    public void passwordFinder(String password) {
        WebElement thePasswordFinder = driver.findElement(By.cssSelector("[type='password']"));
        thePasswordFinder.click();
        thePasswordFinder.sendKeys(password);
    }
    public void logIn(){
        WebElement logInAccount = driver.findElement(By.cssSelector("[type='submit']"));
        logInAccount.click();
    }
    public void searchSongs(String songTitle) {
        WebElement searchTheSongs = driver.findElement(By.cssSelector("[type='search']"));
        searchTheSongs.click();
        searchTheSongs.sendKeys(songTitle);
    }
    public void viewAll(){
        WebElement viewAllOptions = driver.findElement(By.xpath("//*[@data-test='view-all-songs-btn']"));
        viewAllOptions.click();
    }
    public void clickFirstSong(){
        WebElement FirstSong = driver.findElement(By.xpath("/html/body/div/div/div/section[1]/section[11]/div/div/div[1]/table/tr[1]/td[2]"));
        FirstSong.click();
    }

    // public String notificationDisplayed() {
    //  WebElement notificationIsShown = driver.findElement(By.xpath("//div[@class='success show']"));
    // return notificationIsShown.getText();
    // }
    public void addToPlaylist() {
        WebElement addTo = driver.findElement(By.xpath("//*[@data-test='add-to-btn']"));
        addTo.click();
    }
    public void newPlaylist(String playlistName) {
        WebElement newPlaylist = driver.findElement(By.xpath("//*[@id=\"songResultsWrapper\"]/header/div[3]/div/section[2]/form/input"));
        newPlaylist.click();
        newPlaylist.sendKeys(playlistName);
        WebElement newPlaylistEnter = driver.findElement(By.xpath("//*[@id=\"songResultsWrapper\"]/header/div[3]/div/section[2]/form/button"));
        newPlaylistEnter.click();
    }
    public String notificationIcon () {
        WebElement newNotificationIcon = driver.findElement(By.xpath("//div[@class='success show']"));
        return newNotificationIcon.getText();
    }
    public boolean notificationVerification() {
        WebElement notificationVerified = driver.findElement(By.xpath("//div[@class='success show']"));
        return notificationVerified.isDisplayed();
    }
}
