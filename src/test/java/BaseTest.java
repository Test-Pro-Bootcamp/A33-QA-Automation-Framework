import com.beust.jcommander.Parameter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class BaseTest {

    public static WebDriver driver = null;

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters ({"BaseURL"})
    public void setUpBrowser(String url) {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        url="BaseURL";
        driver.get(url);

    }

    public static void enterEmail(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("[type = 'email']"));
        emailField.click();
        emailField.sendKeys(email);
    }

    public static void enterPassword(String password) {
        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        passwordField.click();
        passwordField.sendKeys(password);
    }

    public static void clickSubmit() throws InterruptedException {
        WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
        submitButton.click();
        Thread.sleep(2000);
    }

    public void searchForSong(String songName) throws InterruptedException {
        WebElement searchField = driver.findElement(By.cssSelector("[type='search']"));
        searchField.click();
        searchField.sendKeys(songName);
        Thread.sleep(2000);
    }

    public static void viewAllResults() throws InterruptedException {
        WebElement viewAllButton = driver.findElement(By.xpath("//*[@id=\"searchExcerptsWrapper\"]/div/div/section[1]/h1/button"));
        viewAllButton.click();
        Thread.sleep(2000);
    }

    public static void selectFirstSong() throws InterruptedException {
        WebElement selectFirstFromTheList = driver.findElement(By.xpath("//*[@id=\"songResultsWrapper\"]/div/div/div[1]/table/tr[1]/td[2]"));
        selectFirstFromTheList.click();
        Thread.sleep(2000);
    }

    public static void clickAddTo()  throws InterruptedException {
        WebElement addToButton = driver.findElement(By.xpath("//*[@id=\"songResultsWrapper\"]/header/div[3]/span/button[2]"));
        addToButton.click();
        Thread.sleep(2000);
    }

    public static void choosePlaylist(String playlist) throws InterruptedException {
        WebElement playList = driver.findElement(By.xpath("//*[@id=\"songResultsWrapper\"]/header/div[3]/div/section[1]/ul/li[5]"));
        playList.click();
        Thread.sleep(2000);

    }

    public String verifyNotificationMessage() {
        WebElement verifyMessage = driver.findElement(By.cssSelector("div.alertify-logs.top.right > div.success.show"));
        return verifyMessage.getText();
    }
    public boolean addedSongNotification() {
        WebElement verifyMessage = driver.findElement(By.cssSelector("div.alertify-logs.top.right > div.success.show"));
        return verifyMessage.isDisplayed();
    }
    public static void playNextSong() {
        WebElement nextSong = driver.findElement(By.xpath("//i[@data-testid='play-next-btn']"));
        nextSong.click();
    }
    public static void playButton() throws InterruptedException {
        WebElement play = driver.findElement(By.xpath("//span[@data-testid='play-btn']"));
        play.click();
        Thread.sleep(2000);
    }
    public static boolean playSoundBar() {
        WebElement play = driver.findElement(By.xpath("//div[@data-testid='sound-bar-play']"));
        return play.isDisplayed();
    }

    @AfterMethod
    public static void closeBrowser(){
        driver.quit();
    }
}
