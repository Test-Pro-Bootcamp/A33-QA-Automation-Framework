import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import java.time.Duration;


public class BaseTest {

    public static WebDriver driver = null;


    @BeforeSuite

    static void setupClass() {

        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters({"BaseURL"})

    public static void launchBrowser(String BaseURL) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    public static void loginUrl() throws InterruptedException {

        String url = "https://bbb.testpro.io";

        driver.get(url);
        Thread.sleep(2000);

    }

    public static void enterEmail(String email) throws InterruptedException {

        WebElement emailField = driver.findElement(By.cssSelector("[type = 'email']"));

        emailField.click();

        emailField.clear();

        emailField.sendKeys(email);

        Thread.sleep(2000);

    }

    public static void enterPassword(String password) throws InterruptedException {

        WebElement passwordField = driver.findElement(By.cssSelector("[type = 'password']"));

        passwordField.click();

        passwordField.clear();

        passwordField.sendKeys(password);

        Thread.sleep(2000);

    }

    public static void clickSubmit() throws InterruptedException {

        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));

        submitButton.click();
        Thread.sleep(2000);

    }

    public static void findSong(String songName) throws InterruptedException {

        WebElement findSong = driver.findElement(By.cssSelector("input[type = 'search']"));

        findSong.click();
        findSong.clear();

        findSong.sendKeys(songName);
        Thread.sleep(4000);

    }

    public static void clickViewAllButton() throws InterruptedException {

        WebElement clickViewAllButton = driver.findElement(By.cssSelector("button[data-test = 'view-all-songs-btn']"));

        Thread.sleep(3000);

        clickViewAllButton.click();

       Thread.sleep(3000);

    }

    public static void selectFirstSong() throws InterruptedException {

        WebElement firstSong = driver.findElement(By.cssSelector("section#songResultsWrapper tr.song-item td.title"));

        firstSong.click();

        Thread.sleep(2000);
    }

    public static void clickAddToButton() throws InterruptedException {

        WebElement addToButton = driver.findElement(By.cssSelector("button[class = 'btn-add-to']"));

        addToButton.click();

        Thread.sleep(2000);
    }

        public static void selectPlaylist() throws InterruptedException {



            WebElement selectPlaylist = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(), 'Take my Hand')]"));

            selectPlaylist.click();
            Thread.sleep(2000);

        }

        public static String getNotificationMessage () {

            WebElement notificationMessage = driver.findElement(By.cssSelector("div.success.show"));
            return notificationMessage.getText();

        }

        @AfterMethod

        public static void closeBrowser () {

            driver.quit();

        }

    }

