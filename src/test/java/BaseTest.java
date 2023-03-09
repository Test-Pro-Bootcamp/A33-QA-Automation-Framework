import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
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
    By searchField = By.cssSelector("[type='search']");
    By viewAllButton = By.cssSelector("[data-test ='view-all-songs-btn']");
    By selectSong = By.cssSelector("section#songResultsWrapper tr.song-item td.title");
    By addToButton = By.cssSelector("[data-test = 'add-to-btn']");
    By choosePlaylist =
            By.xpath("//section[@id='songResultsWrapper']//li[contains(text(), 'Musical')]");
    By notification = By.cssSelector("div.success.show");
    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

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
    public void searchSong(String songText) throws InterruptedException {
        WebElement searchElement = driver.findElement(searchField);
        searchElement.sendKeys(songText);
        Thread.sleep(1000);
    }
    public void clickViewAllButton() throws InterruptedException {
        WebElement viewAllElement = driver.findElement(viewAllButton);
        viewAllElement.click();
        Thread.sleep(1000);
    }
    public void clickFirstSong() throws InterruptedException {
        WebElement clickSong = driver.findElement(selectSong);
        clickSong.click();
        Thread.sleep(1000);
    }
    public void clickAddToButton() throws InterruptedException {
        WebElement addToElement = driver.findElement(addToButton);
        addToElement.click();
        Thread.sleep(1000);
    }
    public void clickPlaylist() throws InterruptedException {
        WebElement choosePlaylistElement = driver.findElement(choosePlaylist);
        choosePlaylistElement.click();
        Thread.sleep(1000);
    }
    public String getNotification() {
        WebElement notificationMessage = driver.findElement(notification);
        return notificationMessage.getText();
    }
}
}



