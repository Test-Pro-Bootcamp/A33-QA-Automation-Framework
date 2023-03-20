import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import java.time.Duration;
public class BaseTest {
    By emailFieldLocator = By.cssSelector("[type = 'email']");
    By passwordFieldLocator = By.cssSelector("[type = 'password']");
    By submitButtonLocator = By.cssSelector("[type = 'submit']");
   By deletePlaylistBtnLocator = By.xpath("//button[@class='del btn-delete-playlist']");
    By deleteNotifyLocator=By.cssSelector("div.success.show");
    public static WebDriver driver = null;
    public static String url = null;
    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    @Parameters({"baseURL"})
    public void setUpBrowser(String baseURL) {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        url = baseURL;
        driver.get(baseURL);
    }
    @AfterMethod
    public void tearDownBrowser() {
        driver.quit();
    }
    public void login(String email, String password) throws InterruptedException{
        WebElement emailElement = driver.findElement(emailFieldLocator);
        emailElement.sendKeys(email);
        Thread.sleep(1000);
        WebElement pwField = driver.findElement(passwordFieldLocator);
        pwField.sendKeys(password);
        Thread.sleep(1000);
        WebElement subButton = driver.findElement(submitButtonLocator);
        subButton.click();
        Thread.sleep(1000);
    }
    public void selectPlaylist (String Playlist)  {
        String selectedPlaylistLocator = "//section[@id='playlists']//a[contains(text(),'" + Playlist + "')]";
        WebElement selectedPlaylistElement = driver.findElement(By.xpath(selectedPlaylistLocator));
        selectedPlaylistElement.click();
        System.out.println("Playlist " + Playlist+ " has been selected");
    }
    public String deleteSelectedPlaylist(String Playlist) throws InterruptedException {
        WebElement deletePlaylistBtnElement = driver.findElement(deletePlaylistBtnLocator);
        deletePlaylistBtnElement.click();
        Thread.sleep(2000);
        WebElement notificationElement = driver.findElement(deleteNotifyLocator);
        String msgText1 = notificationElement.getText();
        System.out.println("Message is: " + msgText1);
       return msgText1;
    }
}