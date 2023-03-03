import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import java.time.Duration;

public class BaseTest {

    protected static WebDriver driver  = null;

    @BeforeSuite
    protected static void setUpClass () {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUpBrowser () {
        ChromeOptions options  = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    public static void navigateToPage(String url) {
        driver.get(url);
    }

    public static void loginWithValidCredentials (String email, String password) throws InterruptedException {
        WebElement emailEl = driver.findElement(By.cssSelector("[type = 'email']"));
        emailEl.sendKeys(email);
        WebElement passwdEl = driver.findElement(By.cssSelector("[type = 'password']"));
        passwdEl.sendKeys(password);
        driver.findElement(By.cssSelector("button[type = 'submit']")).click();
        Thread.sleep(3000);
    }

    protected static void searchSong (String song) throws InterruptedException {
        WebElement songEl = driver.findElement(By.cssSelector("[type = 'search']"));
        songEl.clear();
        songEl.sendKeys(song);
        String url = driver.getCurrentUrl();
        System.out.println("searchng for " + song + " in " + url);
        Thread.sleep(2000);
    }

    protected static void viewAllSongs () throws InterruptedException {
        //view all results for songs
        WebElement searchResult = driver.findElement(By.cssSelector("section.songs h1 button"));
        searchResult.click();
        String url = driver.getCurrentUrl();
        System.out.println("searchng for in " + url);
        Thread.sleep(1000);
    }

    protected static void selectFirstSong () throws InterruptedException {
        WebElement songEl = driver.findElement(By.cssSelector("#songResultsWrapper  tr > td.title"));
        songEl.click();
        Thread.sleep(1000);
    }

    protected String clickAddToPls (String playlist) throws InterruptedException{
        driver.findElement(By.cssSelector("#songResultsWrapper button.btn-add-to")).click();
        Thread.sleep(2000);
        String xpathSelector = "//section[@id='songResultsWrapper']//li[contains(text(),'" + playlist + "')]";
        WebElement ourPlaylist = driver.findElement(By.xpath(xpathSelector));
        ourPlaylist.click();
        /*WebElement playlistEl = driver.findElement(By.cssSelector("#songResultsWrapper section.new-playlist input[type='text']"));
        playlistEl.sendKeys(playlist + "1");
        Thread.sleep(500);
        driver.findElement(By.cssSelector("#songResultsWrapper section.new-playlist button[type='submit']")).click();
        String msg1 = driver.findElement(By.cssSelector("div.success.show")).getText();
        Thread.sleep(500);
        System.out.println(msg1);*/
        String msg = driver.findElement(By.cssSelector("div.success.show")).getText();
        System.out.println(msg);
        Thread.sleep(2000);
        return msg;
    }

    public static void playNextSong () throws  InterruptedException{
        driver.findElement(By.cssSelector("i[title = 'Play next song']")).click();
        driver.findElement(By.cssSelector("span.play>i")).click();
        Thread.sleep(2000);
    }

    public Boolean isPlaying () throws InterruptedException {  //verifying by checking whether the sound bar is displayed
        Boolean isPlayingFlag = driver.findElement(By.cssSelector("img[alt = 'Sound bars']")).isDisplayed();
        return isPlayingFlag;
    }

    @AfterMethod
    public void closeBrowser () {
        driver.quit();
    }
}
