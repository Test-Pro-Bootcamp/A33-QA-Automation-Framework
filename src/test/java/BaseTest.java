import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import java.time.Duration;

public class BaseTest {

    WebDriver driver;
    WebDriverWait wait;
    String playlistName = "Homework#21";
    public static Actions actions = null;
    //Actions action = new Actions(driver);

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;


public class BaseTest {

    public WebDriver driver;
    public ThreadLocal<WebDriver> threadDriver;
    public String url;

    public WebDriverWait wait;


    @BeforeSuite
    public void setupClass() {
//        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters("BaseURL")
    public void launchBrowser(String BaseURL) throws MalformedURLException {
//        threadDriver = new ThreadLocal<>();// Make sure to create this object as the first line
        driver = pickBrowser( System.getProperty("browser") );
//        threadDriver.set(driver);

        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        url = BaseURL;
        getDriver().get(BaseURL);
    }

    @AfterMethod
    public void tearDownBrowser() {
        getDriver().quit();
//        threadDriver.remove();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriver lambdaTest() throws MalformedURLException {
        String hubURL = "https://hub.lambdatest.com/wd/hub";

        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 10");
        browserOptions.setBrowserVersion("110.0");
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("username", "khaledoni01");
        ltOptions.put("accessKey", "Zx0HIXlEJ9ERHjcH9UDCvNXRoiSm2si9VM3L6Dii3SX6W1GPF4");
        ltOptions.put("project", "Test Project");
        ltOptions.put("w3c", true);
        browserOptions.setCapability("LT:Options", ltOptions);

        return new RemoteWebDriver(new URL(hubURL), browserOptions);
    }

    public WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL = "http://192.168.1.160:4444";

        switch(browser) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return driver = new FirefoxDriver();
            case "MicrosoftEdge":
                WebDriverManager.edgedriver().setup();
                return driver = new EdgeDriver();
            case "grid-edge":
                caps.setCapability("browserName", "MicrosoftEdge");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "grid-firefox":
                caps.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "grid-chrome":
                caps.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "cloud":
                return lambdaTest();
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                return driver = new ChromeDriver(options);
        }
    }

    @BeforeMethod
    @Parameters({"baseURL"})
    public void setUpBrowser(String baseURL) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(baseURL);
        wait = new WebDriverWait(driver, Duration.ofSeconds(4));
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
    @Test
    public void renamePlaylist() {
        getEmail("ponypony123@gmail.com");
        getPassword("Testtesttest123123$$");
        loginUser();
        choosePlaylist();
        contextClickChoosePlaylist();
        enterPlaylistName();
    }

    public void choosePlaylist() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)"))).click();
    }

    public void contextClickChoosePlaylist() {
        //System.out.println("11111");
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".playlist:nth-child(3)")));
        //System.out.println("22222");
        WebElement playlistElement = driver.findElement(By.cssSelector(".playlist:nth-child(3)"));
        //System.out.println("33333");
        actions.contextClick(playlistElement).perform();
        //System.out.println("44444");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li[data-testid^='playlist-context-menu-edit']"))).click();
        //System.out.println("55555");
    }

    public void enterPlaylistName() {
        WebElement playlistInputField = driver.findElement(By.cssSelector("input[name='name']"));
        playlistInputField.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
        playlistInputField.sendKeys(playlistName);
        playlistInputField.sendKeys(Keys.ENTER);
    }

    public boolean playlistDoesExist() {
        WebElement playlistElement = driver.findElement(By.xpath("//a[text()='"+playlistName+"']"));
        return playlistElement.isDisplayed();
    }

//    public void openPlayLis() {
//        WebElement emptyPlayList = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".playlist:nth-child(3)")));
//        emptyPlayList.click();
//    }
//
//    public WebElement getDeletedMessage() {
//        return wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.success.show")));
//    }
//
//    public void deletePlayList() {
//        WebElement deletePlaylistButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn-delete-playlist")));
//        deletePlaylistButton.click();
//    }
//
//    public void urlAccess() {
//        String url = "https://bbb.testpro.io/";
//        driver.get(url);
//    }

    public void getEmail(String email) {
        WebElement insertEmail = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='email']")));
        insertEmail.click();
        insertEmail.sendKeys(email);
    }

    public void getPassword(String password) {
        WebElement insertEmail = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='password']")));
        insertEmail.click();
        insertEmail.sendKeys(password);
    }

    public void loginUser() {
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
        submitButton.click();
    }

//    public void clickPlayNextSong() {
//        WebElement playNextSongButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@data-testid='play-next-btn']")));
//        WebElement playSongButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@data-testid='play-btn']")));
//        playNextSongButton.click();
//        playSongButton.click();
//    }
//
//    public boolean songPlayIsDisplayed() {
//        WebElement songIsPlaying = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//progress[@class='plyr__progress--played']")));
//        return songIsPlaying.isDisplayed();
//    }
}
