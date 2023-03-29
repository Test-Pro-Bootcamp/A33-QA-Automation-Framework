import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
<<<<<<< Updated upstream
=======
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
>>>>>>> Stashed changes
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;


public class BaseTest {

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
    }

<<<<<<< Updated upstream
=======
    WebDriver driver;
    WebDriverWait wait;

    public void setUpDriver() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void quitDriver(){
        driver.quit();
    }

    public void getUrl() {
        String url = "https://bbb.testpro.io/";
        driver.get(url);
    }

    public void login(String email, String password){
        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        emailField.click();
        emailField.sendKeys(email);

        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        passwordField.click();
        passwordField.sendKeys(password);

        WebElement buttonLogin = driver.findElement(By.cssSelector("button[type='submit']"));
        buttonLogin.click();
    }

    public void searchSong(String song) throws InterruptedException {
        WebElement searchField = wait.until(ExpectedConditions.elementToBeClickable
                (driver.findElement(By.cssSelector("input[type='search']"))));
        searchField.click();
        searchField.sendKeys(Keys.CONTROL+"a");
        //Thread.sleep(2000);
        searchField.sendKeys(Keys.DELETE);
        searchField.sendKeys(song);
        searchField.sendKeys(Keys.ENTER);
    }

    public void viewAll() {
        WebElement buttonViewAll = wait.until(ExpectedConditions.elementToBeClickable(By.xpath
                ("//*[@id='searchExcerptsWrapper']/div/div/section[1]/h1/button")));
        buttonViewAll.click();
    }

    public void selectSong() {
        WebElement song = driver.findElement(By.xpath("//*[@id='songResultsWrapper']/div/div/div[1]/table/tr[1]"));
        song.click();
    }

    public void clickAddButton(){
        WebElement buttonAddSong = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id='songResultsWrapper']/header/div[3]/span/button[2]")));
        buttonAddSong.click();
    }
    //String playlistName did remove it, it's not working...
    public void selectPlaylist(){
        WebElement addToPlaylist = wait.until(ExpectedConditions.elementToBeClickable
                (By.xpath("//*[@id='songResultsWrapper']/header/div[3]/div/section[1]/ul/li[5]")));
        addToPlaylist.click();
    }
    //*[@id='songResultsWrapper']//section[1]/ul/li[contains(text(),'"+playlistName+"']")))
    ////*[@id="songResultsWrapper"]/header/div[3]/div/section[1]/ul/li[5]
    //*[@id="songResultsWrapper"]/header/div[3]/div/section[1]/ul/li[5]

    public boolean getNotification(){
        WebElement alert = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div")));
        return alert.isDisplayed();
    }

    public void verifyNotification(){
        getNotification();
        Assert.assertTrue(getNotification());
         }
>>>>>>> Stashed changes
}
