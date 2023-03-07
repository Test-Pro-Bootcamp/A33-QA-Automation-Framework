import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;


import java.time.Duration;


public class BaseTest {

    public static WebDriver driver;
    public static WebDriverWait wait;


    @BeforeSuite

    static void setupClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(4));

    }

    @AfterMethod
    static void closebrowser() {
        driver.quit();
    }


    public void setupBrowser() {
      //  driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


    public void navigation(String setURL) {
        driver.get(setURL);
    }

    public void enterEmail(String email){
        WebElement EmailField = driver.findElement(By.cssSelector("[type='email']"));
        EmailField.sendKeys(email);
    }
    public void enterPassword(String password) {
        WebElement PasswordField = driver.findElement(By.cssSelector("[type='password']"));
        PasswordField.sendKeys(password);
    }
    public void submit() {
       WebElement submit = driver.findElement(By.cssSelector("[type='submit']"));
       submit.click();
    }


    public void search(String songName) {
        WebElement searchField;

        searchField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='search']")));
     //   searchField = driver.findElement(By.cssSelector("//input[@type='search']"));
        searchField.sendKeys(songName);
    }

    public void sleep() {
        try {
            Thread.sleep(2000); // sleeps for 5 seconds
        } catch (InterruptedException e) {
            // Handle the exception
        }


    }

    public void clickViewALl() {
        //WebElement viewAll = driver.findElement(By.xpath("//button[@data-test='view-all-songs-btn']"));
        WebElement viewALl = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-test='view-all-songs-btn']")));
        viewALl.click();
    }

    public void clickFirstSong() {
       WebElement selectFirstSong = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("section#songResultsWrapper tr.song-item td.title")));
       selectFirstSong.click();
    }

    public void AddTo() {
        WebElement addtobtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("section#songResultsWrapper button.btn-add-to")));
        addtobtn.click();
    }

    public void addToPlaylist() {
        WebElement addtoPlst = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(), 'SuperPlaylist3')]")));
        addtoPlst.click();
    }

    public String verifyNotification() {
        WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        return notification.getText();
    }










}
