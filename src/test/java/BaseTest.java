import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.time.Duration;


public class BaseTest {
   public static WebDriver driver = null;
   public static String url = null;
   public static WebDriverWait wait = null;
  
    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    @Parameters({"baseUrl"})
    public void launchBrowser(String baseUrl){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications","--remote-allow-origins=*","--incognito","--start-maximize");

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        url = baseUrl;
        driver.get(url);
        
    }

    public static void provideEmail(String email){
     WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='email']")));
     emailField.click();
     emailField.sendKeys(email);
     
    }
      public static void providePassword(String password){
        WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='password']")));
        passwordField.click();
        passwordField.sendKeys(password);
      }
    
      public static void clickSubmit(){
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable
                (By.cssSelector("[type='submit']")));
        submitButton.click();
  
      }
      public static void logIn(String email, String password){
        provideEmail(email);
        providePassword(password);
        clickSubmit();
        
      }
        public static void createNewPlaylist(){
        WebElement newPlaylistIcon = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("i[title='create new playlist']")));
        newPlaylistIcon.click();
        WebElement newPlayList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li[data-testid='playlist-context-menu-create-simple']")));
        newPlayList.click();
        WebElement nameField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[name='name']")));
        nameField.clear();
        nameField.sendKeys("Pluto");
        nameField.sendKeys(Keys.ENTER);
        }

        public static boolean newPlaylistIsDisplayed(){
        WebElement newPlaylist = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a[class='active']")));
        return newPlaylist.isDisplayed();
        }

        public static void searchSong(String songName){
        WebElement searchSong = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='search']")));
        searchSong.sendKeys(songName);
        
        }
        public static void clickViewAllButton(){
        WebElement clickViewAllButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[data-test = 'view-all-songs-btn']")));
        clickViewAllButton.click();
        }

        public static void selectFirstSong(){
        WebElement selectFirstSong = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("section#songResultsWrapper tr.song-item td.title")));
        selectFirstSong.click();
        }

        public static void clickAddToButton(){
         WebElement addToButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class = 'btn-add-to']")));
         addToButton.click();
        }


    public WebElement getDeletedPlaylistMsg(){
        return driver.findElement(By.cssSelector("div.success.show"));

    }
    public void openPlaylist() throws InterruptedException{
        WebElement emptyPlaylist = driver.findElement(By.cssSelector(".playlist:nth-child(3)"));
        emptyPlaylist.click();
        Thread.sleep(2000);
    }
    public void deletedPlaylist() throws InterruptedException{
       WebElement deletedPlaylistButton = driver. findElement(By.cssSelector(".btn-delete-playlist"));
       deletedPlaylistButton.click();
       Thread.sleep(2000);
    }

}
