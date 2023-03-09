import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import java.time.Duration;
public class BaseTest {
    public static WebDriver driver = null;
    String url = "https://bbb.testpro.io/";
    By emailField = By.cssSelector("[type = 'email']");
    By passwordField = By.cssSelector("[type = 'password']");
    By submitButton = By.cssSelector("[type = 'submit']");
    By playNextSongButton =
            By.xpath("//*[@title = 'Play next song' and @data-testid='play-next-btn']");
    By playSongButton =
            By.xpath("//*[@title='Play or resume' and  @data-testid='play-btn']");
    By pauseButton = By.xpath("//span[@title ='Pause' and @data-testid='pause-btn']");
    By soundBarVisualizer = By.cssSelector("[data-testid='sound-bar-play']");
    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    public void setUpBrowser() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    @AfterMethod
    public void tearDownBrowser() {
        driver.quit();
    }
    public void openLoginURL() {
        driver.get(url);
    }
    public void provideEmail(String email) {
        WebElement emailElement = driver.findElement(emailField);
        emailElement.sendKeys(email);
    }
    public void providePW(String password) {
        WebElement pwField = driver.findElement(passwordField);
        pwField.sendKeys(password);
    }
    public void clickSubmit() throws InterruptedException {
        WebElement subButton = driver.findElement(submitButton);
        subButton.click();
        Thread.sleep(1000);
    }
    public void clickPlayNextSong() throws InterruptedException {
        WebElement playNextSongElement = driver.findElement(playNextSongButton);
        playNextSongElement.click();
        Thread.sleep(2000);
    }
    public void clickPlaySong() throws InterruptedException {
        WebElement playSongElement = driver.findElement(playSongButton);
        Thread.sleep(2000);
        playSongElement.click();
    }
    public boolean pauseButtonDisplay() throws InterruptedException {
        WebElement pauseButtonElement = driver.findElement(pauseButton);
        Thread.sleep(2000);
        return pauseButtonElement.isDisplayed();
    }
    public boolean soundBarVisualizerDisplay() throws InterruptedException {
        WebElement soundBarVisualizerBarElement = driver.findElement(soundBarVisualizer);
        Thread.sleep(2000);
        return soundBarVisualizerBarElement.isDisplayed();
    }
}