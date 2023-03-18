import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Parameters;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.edge.EdgeDriver;


public class BaseTest {
    private  WebDriver driver;
    private  Actions actions;
    private  WebDriverWait wait;
    private  ThreadLocal<WebDriver> threadDriver;
    //private  ThreadLocal<WebDriver> driver;
    String url = "";
    String password = "";
    String email = "";


    @BeforeSuite
    public void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters({"baseURL", "email", "password"})
    public void setupBrowser(String baseUrl, String mail, String pass) throws MalformedURLException {
        threadDriver = new ThreadLocal<>();
        driver = pickBrowser(System.getProperty("browser"));
        //driver = pickBrowser("cloud");
        threadDriver.set(driver);
        System.out.println("Thread " + Thread.currentThread().getId() + " is starting setupBrowser method...");


        actions = new Actions(getDriver());
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        url = baseUrl;
        getDriver().get(url);
        password = pass;
        email = mail;
    }

    @AfterMethod
    public void exitBrowser() {
        getDriver().quit();
        threadDriver.remove();
    }

    public WebDriver getDriver() {
        return threadDriver.get();
    }

    private static WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL = "http://192.168.1.9:4444";
        switch (browser) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            case "MicrosoftEdge":
                WebDriverManager.edgedriver().setup();
                return new EdgeDriver();
            case "grid-firefox":
                caps.setCapability("browserName", "firefox");
                return new RemoteWebDriver(URI.create(gridURL).toURL(),caps);
            case "grid-edge":
                caps.setCapability("browserName", "MicrosoftEdge");
                return new RemoteWebDriver(URI.create(gridURL).toURL(),caps);
            case "grid-chrome":
                caps.setCapability("browserName", "chrome");
                return new RemoteWebDriver(URI.create(gridURL).toURL(),caps);
            case "cloud":
                return newLambdaTest();
            default:
                ChromeOptions option = new ChromeOptions();
                option.addArguments("--remote-allow-origins=*", "--disable-notifications");
                return new ChromeDriver(option);
        }
    }

    public static WebDriver newLambdaTest() throws MalformedURLException {
        String hubURL = "https://hub.lambdatest.com/wd/hub";

        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 10");
        browserOptions.setBrowserVersion("110.0");
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("username", "naturewlf");
        ltOptions.put("accessKey", "WHJFwqnp7dyUjIwDIDPCycNjX2UsGb4ZUNBirWaG0wo0gR3s9n");
        ltOptions.put("project", "Untitled");
        ltOptions.put("w3c", true);
        browserOptions.setCapability("LT:Options", ltOptions);

        return new RemoteWebDriver(new URL(hubURL), browserOptions);
    }

    /* All the code that got moved to pages for memories
    public void openLoginURL() {
        driver.get(koelStart);
    }

    public void openAllSongs() {
        driver.get(koelSongs);
    }

    public void setUrl(String url) {
        testUrl = url;
    }

    public void setPassword(String pass) {
        password = pass;
    }

    public void setEmail(String mail) {
        email = mail;
    }

    public void openUrl(String url) {
        driver.get(url);
    }

    public void inputEmail(String email) {
        //WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        //emailField.sendKeys(email);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='email']"))).sendKeys(email);
    }

    public void inputPassword(String pass) {
        //WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        //passwordField.sendKeys(pass);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='password']"))).sendKeys(pass);
    }

    public void clickLogin() {
        //WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        //wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //loginButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='submit']"))).click();
    }

    public void loginValidAccount(String email, String password) {
        openLoginURL();
        inputEmail(email);
        inputPassword(password);
        clickLogin();
    }

    public void logIn() {
        inputEmail(email);
        inputPassword(password);
        clickLogin();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe(koelHome));
    }
    public String getEmail() {
        return email;
    }

    public void clickViewAll() {
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //wait.until(ExpectedConditions.elementToBeClickable(By.id("button[data-testid='home-view-all-recently-played-btn']")));
        WebElement viewallButton = driver.findElement(By.cssSelector("button[data-testid='home-view-all-recently-played-btn']"));
        viewallButton.click();
    }

    public void clickFirstSong() {
        currentUrl = driver.getCurrentUrl();
        WebElement firstSong = null;
        if (currentUrl.equals(koelSongs)) {
            firstSong = driver.findElement(By.cssSelector("#songsWrapper [class='song-item']:nth-child(1)"));
        }
        else if (currentUrl.equals(koelRecentlyPlayed)) {
            firstSong = driver.findElement(By.cssSelector("#recentlyPlayedWrapper [class='song-item']:nth-child(1)"));
        }
        firstSong.click();
    }

    public void playFirstSong() {
        actions = new Actions(driver);
        currentUrl = driver.getCurrentUrl();
        WebElement firstSong = null;
        if (currentUrl.equals(koelSongs)) {
            firstSong = driver.findElement(By.cssSelector("#songsWrapper [class='song-item']:nth-child(1)"));
        }
        else if (currentUrl.equals(koelRecentlyPlayed)) {
            firstSong = driver.findElement(By.cssSelector("#recentlyPlayedWrapper [class='song-item']:nth-child(1)"));
        }
        actions.doubleClick(firstSong).perform();
    }

    public void clickAddto() {

        WebElement Addto = driver.findElement(By.cssSelector("button[class='btn-add-to']"));
        Addto.click();
    }

    public void clickPlaylistfromAddto(String searchText) {
        WebElement playlistAddto = driver.findElement(By.xpath("//*[@id='recentlyPlayedWrapper'] //li[contains(text(),'" + searchText + "')]"));
        //WebElement playlistAddto = driver.findElement(By.cssSelector("#recentlyPlayedWrapper [class='existing-playlists'] [class='playlist']"));
        playlistAddto.click();
    }

    public String getSuccessNotif(){
        return driver.findElement(By.cssSelector("[class='success show']")).getText();
    }

    public WebElement getDeletedPlaylistmsg(){
        return driver.findElement(By.cssSelector("div.success.show"));
    }

    public WebElement getSuccessPopup(){
        return driver.findElement(By.cssSelector("[class='success show']"));
    }

    public WebElement getPauseButton(){
        return driver.findElement(By.cssSelector("span[class='pause']"));
    }

    public void deleteAddedSongPlaylist(String searchText){
        //WebElement testPlaylist = driver.findElement(By.xpath("//*[@id='playlists']  //li[@class='playlist playlist']  //a[contains(text(),'" + searchText + "')]"));
        //testPlaylist.click();
        actions = new Actions(driver);
        openPlaylist(searchText);
        WebElement song_to_select = driver.findElement(By.cssSelector("#playlistWrapper [class='song-item']:nth-child(1)"));
        song_to_select.click();
        WebElement song_to_delete = driver.findElement(By.cssSelector("#playlistWrapper [class='song-item selected']:nth-child(1)"));
        song_to_delete.click();
        actions.sendKeys(Keys.DELETE).perform();
    }

    public void openPlaylist(String searchText) {
        WebElement testPlaylist = driver.findElement(By.xpath("//*[@id='playlists']  //li[@class='playlist playlist']  //a[contains(text(),'" + searchText + "')]"));
        //WebElement testPlaylist = driver.findElement(By.cssSelector("#playlists li[class='playlist playlist'] a"));
        testPlaylist.click();
        //WebElement namePlaylist = driver.findElement(By.xpath("//section[@id='playlistWrapper'] //h1[contains(text(),'" + searchText + "')]"));
        //wait.until(ExpectedConditions.visibilityOf(namePlaylist));
    }

    public void createPlaylist(String name) {
        WebElement plusButton = driver.findElement(By.cssSelector("i[class='fa fa-plus-circle create']"));
        plusButton.click();
        WebElement simplePlaylist = driver.findElement(By.cssSelector("[data-testid='playlist-context-menu-create-simple']"));
        simplePlaylist.click();
        enterPlaylistName(name);
    }

    public void deleteEmptyPlaylist() {
        WebElement button = driver.findElement(By.cssSelector("[class='del btn-delete-playlist']"));
        button.click();
    }

    public void deleteFullPlaylist() {
        WebElement button = driver.findElement(By.cssSelector("[class='del btn-delete-playlist']"));
        button.click();
        WebElement okbutton = driver.findElement(By.cssSelector("button[class='ok']"));
        okbutton.click();
    }

    public boolean isPlaylistvisible(String searchText) {
        WebElement testPlaylist = driver.findElement(By.xpath("//*[@id='playlists']  //li[@class='playlist playlist']  //a[contains(text(),'" + searchText + "')]"));
        return testPlaylist.isDisplayed();
    }

    public void doubleClickPlaylist(String searchText) {
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//*[@id='playlists']  //li[@class='playlist playlist']  //a[contains(text(),'" + searchText + "')]"))));
        WebElement playlistElement = driver.findElement(By.xpath("//*[@id='playlists']  //li[@class='playlist playlist']  //a[contains(text(),'" + searchText + "')]"));
        actions.doubleClick(playlistElement).perform();
    }
    public void enterPlaylistName(String name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.cssSelector("input[name='name']"))));
        WebElement playlistTxtbox = driver.findElement(By.cssSelector("input[name='name']"));
        playlistTxtbox.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE),name, Keys.ENTER);
    }

     */
}
