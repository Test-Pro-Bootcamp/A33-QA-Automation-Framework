import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseTest {

    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected  static Actions action;
    private static final int TIME = 6; //time in seconds for timeout wait

    protected String password = "";
    protected String email = "";
    protected String homeUrl = "";


    @BeforeSuite
    protected static void setUpClass () {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters ({"BaseUrl", "LoginEmail", "LoginPassword"})
    public void setUpBrowser (String BaseUrl, String LoginEmail, String LoginPassword) {
        email = LoginEmail;
        password = LoginPassword;
        homeUrl = BaseUrl;
        ChromeOptions options  = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        driver.manage().window().maximize();
    }

    protected static void searchSong (String song){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.main-scroll-wrap")));
        WebElement songEl = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type = 'search']")));
        songEl.clear();
        String url = driver.getCurrentUrl();
        System.out.println("searching for " + song + " in " + url);
        songEl.sendKeys(song);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.results")));
    }

    protected static void viewAllSongs () {
        //view all results for songs
        WebElement searchResult = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("section.songs h1 button")
        ));
        searchResult.click();
        String url = driver.getCurrentUrl();
        System.out.println("searching for in " + url);
    }

    protected static void selectFirstSong () {
        WebElement songEl = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("#songResultsWrapper  tr > td.title")
        ));
        songEl.click();
    }

    protected String clickAddToPls (String playlist) {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#songResultsWrapper button.btn-add-to"))).click();
        String xpathSelector = "//section[@id='songResultsWrapper']//li[contains(text(),'" + playlist + "')]";
        WebElement ourPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathSelector)));
        ourPlaylist.click();
        String msg = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("div.success.show")
        )).getText();
        System.out.println(msg);
        return msg;
    }

    @AfterMethod
    public void closeBrowser () {
        driver.quit();
    }
}
