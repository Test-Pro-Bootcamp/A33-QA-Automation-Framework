import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import java.time.Duration;
import java.util.Collection;
public class BaseTest {

    static WebDriver driver;
    static String url = ("https://bbb.testpro.io/");

    @BeforeSuite
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    public static void launchBrowser() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    public void NavigateUrl () {
        driver.get(url);
    }
    public  void provideEmail (String email) throws InterruptedException {
        WebElement provideEmail = driver.findElement(By.cssSelector("[type='email']"));
        provideEmail.click();
        provideEmail.sendKeys(email);
        Thread.sleep(2000);
    }

    public void providePassword (String password ) throws InterruptedException {
        WebElement providePassword = driver.findElement(By.cssSelector("[type='password']"));
        providePassword.click();
        providePassword.sendKeys(password);
        Thread.sleep(2000);
    }

    public void clickSubmit () throws InterruptedException {
        WebElement clickSubmit = driver.findElement(By.cssSelector("[type='submit']"));
        clickSubmit.click();
        Thread.sleep(2000);

    }

    public void searchSong(String song) throws InterruptedException {
        WebElement searchSong = driver.findElement(By.xpath("//*[@type='search']"));
        searchSong.click();
        searchSong.sendKeys(song);
        Thread.sleep(2000);

    }

    public void viewAllSearchResult() throws InterruptedException {
        WebElement viewAllSearchResult = driver.findElement(By.cssSelector("#searchExcerptsWrapper > div > div > section.songs > h1 > button"));
        viewAllSearchResult.click();
        Thread.sleep(2000);

    }

    public void selectFirstSongResult() throws InterruptedException {
        WebElement selectFirstSongResult = driver.findElement(By.cssSelector("section[id='songResultsWrapper'] tr:nth-child(1) td:nth-child(1)"));
        selectFirstSongResult.click();
        Thread.sleep(2000);


    }

    public void clickAddToButton() throws InterruptedException {
        WebElement clickAddToButton = driver.findElement(By.cssSelector("button[class='btn-add-to'"));
        clickAddToButton.click();
        Thread.sleep(2000);


    }

    public void choosePlaylist(String playlistName) throws InterruptedException {
        WebElement choosePlaylist  = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//li[@class='playlist'][normalize-space()='"+playlistName+"']"));
        choosePlaylist.click();
        Thread.sleep(4000);

    }
   /* public String getNotificationText() throws InterruptedException {
         WebElement notificationText = driver.findElement(By.cssSelector("[class='success show']"));
         return notificationText.getText();*/

    @AfterMethod
    public static void closeBrowser() {
        driver.quit();
    }


}