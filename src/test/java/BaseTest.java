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

    WebDriver driver;
    WebDriverWait wait;
    String playlistName = "Homework#21";
    //public static Actions actions = null;
    //Actions action = new Actions(driver);

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
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

//    @Test
//    public void renamePlaylist() {
//        getEmail("ponypony123@gmail.com");
//        getPassword("Testtesttest123123$$");
//        loginUser();
//        choosePlaylist();
//        contextClickChoosePlaylist();
//        enterPlaylistName();
//    }

    public void choosePlaylist() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)"))).click();
    }

//    public void contextClickChoosePlaylist() {
//        //System.out.println("11111");
//        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".playlist:nth-child(3)")));
//        //System.out.println("22222");
//        WebElement playlistElement = driver.findElement(By.cssSelector(".playlist:nth-child(3)"));
//        //System.out.println("33333");
//        actions.contextClick(playlistElement).perform();
//        //System.out.println("44444");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li[data-testid^='playlist-context-menu-edit']"))).click();
//        //System.out.println("55555");
//    }

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
