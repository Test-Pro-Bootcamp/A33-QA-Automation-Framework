import io.github.bonigarcia.wdm.WebDriverManager;
Homework17
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

main
import org.testng.annotations.BeforeSuite;

import java.time.Duration;


public class BaseTest {
     public static WebDriver driver = null;
    public static String url = "https://bbb.testpro.io/";
    public static String homepageUrl = "https://bbb.testpro.io/#!/home";

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public static void launchBrowser(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }
    public static void openLoginUrl() throws InterruptedException {
        String url = "https://bbb.testpro.io/";
        driver.get(url);
        Thread.sleep(2000);
    }
    public static void provideEmail(String email) throws InterruptedException {
        WebElement emailField = driver.findElement(By.cssSelector("[type = 'email']"));
        emailField.click();
        emailField.clear();
        emailField.sendKeys(email);
        Thread.sleep(2000);
    }
    public static void providePassword(String password) throws InterruptedException {
        WebElement passwordField = driver.findElement(By.cssSelector("[type = 'password']"));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys(password);
        Thread.sleep(2000);
    }
    public static void clickSubmit() throws InterruptedException {
        WebElement submitButton = driver.findElement(By.cssSelector("button[type = 'submit']"));
        submitButton.click();
        Thread.sleep(2000);
    }
    public static void searchSong(String songName) throws InterruptedException {
        WebElement searchSong = driver.findElement(By.cssSelector("input[type = 'search']"));
        searchSong.click();
        searchSong.clear();
        searchSong.sendKeys(songName);
        Thread.sleep(4000);
    }
    public static void clickViewAllButton() throws InterruptedException {
        WebElement clickViewAllButton = driver.findElement(By.cssSelector("button[data-test = 'view-all-songs-btn']"));
        Thread.sleep(3000);
        clickViewAllButton.click();
        Thread.sleep(3000);
    }
    public static void selectFirstSong() throws InterruptedException {
        WebElement firstSong = driver.findElement(By.xpath("//td[contains(text(), 'Lost In Space')]"));
        firstSong.click();
        Thread.sleep(2000);
    }
    public static void clickAddToButton() throws InterruptedException {
        WebElement addToButton = driver.findElement(By.cssSelector("button[class = 'btn-add-to']"));
        addToButton.click();
        Thread.sleep(2000);
    }
    public static void clickPlaylistNameFromAddTo(String playlistName) throws InterruptedException {
        WebElement clickPlaylistNameFromAddTo = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//section/ul//li[contains(text(), '" + playlistName + "')]"));
        clickPlaylistNameFromAddTo.click();
        Thread.sleep(2000);
    }
    public static String getNotificationMessage() {
        WebElement notificationMessage = driver.findElement(By.xpath("//div[@class= 'success show']"));
        return notificationMessage.getText();
    }
    public static boolean getNotificationPopup() {
        WebElement notificationPopup = driver.findElement(By.xpath("//div[@class= 'success show']"));
        return notificationPopup.isDisplayed();
    }
        public static void deleteSongFromPlaylist() throws InterruptedException {
        WebElement SelectPlaylist = driver.findElement(By.xpath("//a[@href='#!/playlist/45609']"));
        SelectPlaylist.click();
        Thread.sleep(2000);
        WebElement clickToSong = driver.findElement(By.xpath("//*[@id='playlistWrapper']/div/div/div[1]/table/tr/td[2]"));
        clickToSong.click();
        WebElement deleteSong = driver.findElement(By.xpath("//*[@id= 'playlistWrapper']/div/div/div[1]/table/tr"));
        Actions actions = new Actions(driver);
        actions.moveToElement(clickToSong).click().sendKeys(Keys.DELETE).perform();
        Thread.sleep(2000);
    }
    @AfterMethod
    public static void closeBrowser() {driver.quit();
    }

}
