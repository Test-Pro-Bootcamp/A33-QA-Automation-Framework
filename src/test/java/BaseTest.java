import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.time.Duration;

import static com.google.gson.internal.bind.TypeAdapters.URL;


public class BaseTest {


    public static WebDriver driver;


    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();

    }

    @BeforeMethod
    public static void launchBrowser(String browser) {
        driver = pickBrowser(browser);
    }


    public static WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCpabilities caps = new DesiredCapabilities();
        String gridURL = "http://192.168.55.101:4444";
        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                return driver = new ChromeDriver();
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return driver = new FirefoxDriver();
            case "grid-firefox":
                caps.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URL.create(gridURL).toURL(), caps);
            case "grid-chrome":
                caps.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URL.create(gridURL).toURL(), caps);

            default:
                return driver = new ChromeDriver();

        }
    }

    @Parameters({"BaseURL"})


    //public void launchBrowser(String BaseURL) {
    //ChromeOptions options = new ChromeOptions();
    //options.addArguments("--disable-notifications");
    //driver = new ChromeDriver();
    //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    //driver.manage().window().maximize();

    //url = BaseURL;
    //driver.get(url);


}

    @AfterMethod
    public static void closeBrowser() {
        driver.quit();
    }


    //Methods for logging in

    public static void provideEmail(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("[type = 'email']"));
        emailField.sendKeys(email);
    }

    public static void providePassword(String password) {
        WebElement passwordField = driver.findElement(By.cssSelector("[type = 'password']"));
        passwordField.sendKeys(password);
    }

    public static void clickSubmit() {
        WebElement submitButton = driver.findElement(By.cssSelector("button[type = 'submit']"));
        submitButton.click();
    }


    //Methods for playing a song
    public void enterAllSongs() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        WebElement allSongs = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href='#!/songs']")));
        allSongs.click();

        // WebElement allSongs = driver.findElement(By.cssSelector("a[href='#!/songs']"));
        //allSongs.click();

        //Thread.sleep(1000);
        // allSongs.click();
        //
    }

    public void selectSong() {
        WebElement song = driver.findElement(By.xpath("//tr[@class='song-item']"));
        song.click();

        //throws InterruptedException
        //WebElement song = driver.findElement(By.xpath("//tr[@class='song-item']"));
        //Thread.sleep(1000);

    }

    public void enterButtonPlaySong() {
        WebElement buttonPlaySong = driver.findElement(By.xpath("//span[@title='Play or resume']"));
        Actions actions = new Actions(driver);
        actions.click(buttonPlaySong).perform();
    }


    public boolean isDisplayedPlayingSong() {

        WebElement songIsPlaying = driver.findElement(By.cssSelector("[data-testid = 'sound-bar-play']"));
        return songIsPlaying.isDisplayed();


    }

    //Methods to rename a playlist
    public void doubleClickOnPlaylist() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));

        Actions actions = new Actions(driver);
        WebElement myPlayList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/nav/section[2]/ul/li[3]/a")));
        actions.doubleClick(myPlayList).perform();

    }

    public void provideNewName() {


        WebElement nameField = driver.findElement(By.xpath("/html/body/div/div/div/nav/section[2]/ul/li[3]/a"));
        nameField.sendKeys((Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE)));
        nameField.sendKeys(playlistName);
        nameField.sendKeys(Keys.ENTER);
    }

    public boolean doesPlaylistExist() {
        WebElement playlistElement = driver.findElement(By.xpath("//a[text()='" + playlistName + "']"));
        return playlistElement.isDisplayed();
    }


    //Additional things for Login test
    public boolean isHomePageElementDisplayed() {
        WebElement homePage = driver.findElement(By.xpath("/html/body/div/div/div/nav/section[1]/ul/li[1]/a"));
        return homePage.isDisplayed();

    }

    public void logIn() {
        provideEmail("janezelenova@gmail.com");
        providePassword("Floridaliving2023$");

        //AND user clicks a submit button

        clickSubmit();
    }

    @DataProvider(name = "incorrectLoginData")
    public Object[][] getDataProviders() {
        return new Object[][]{{"invalid@gmail.com", "invalidPass"}, {"onlyEmail@gmail.com", ""}, {"", ""}

        };
    }
}



