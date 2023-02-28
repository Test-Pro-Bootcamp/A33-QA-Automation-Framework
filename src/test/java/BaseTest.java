import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

    WebDriver driver;

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUpBrowser() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }

    public void urlAccess() throws InterruptedException {
        String url = "https://bbb.testpro.io/";
        driver.get(url);
        driver.manage().window().maximize();
        Thread.sleep(2000);
    }

    public void getEmail(String email) throws InterruptedException {
        WebElement insertEmail = driver.findElement(By.xpath("//input[@type='email']"));
        insertEmail.click();
        insertEmail.sendKeys(email);
        Thread.sleep(2000);
    }

    public void getPassword(String password) throws InterruptedException {
        WebElement insertEmail = driver.findElement(By.xpath("//input[@type='password']"));
        insertEmail.click();
        insertEmail.sendKeys(password);
        Thread.sleep(2000);
    }

    public void loginUser() throws InterruptedException {
        WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
        submitButton.click();
        Thread.sleep(2000);
    }

    public void searchSong(String songName) throws InterruptedException {
        WebElement searchSong = driver.findElement(By.xpath("//input[@type='search']"));
        searchSong.sendKeys(songName);
        Thread.sleep(2000);
    }

    public void searchResult() throws InterruptedException {
        WebElement viewResult = driver.findElement(By.xpath("//h1[ contains(text(), 'Songs') ] //button [  contains(text(), 'View All') ]"));
        viewResult.click();
        Thread.sleep(2000);
    }

    public void selectFirstSong() throws InterruptedException {
        WebElement selectSong = driver.findElement(By.xpath("//td[contains(text(),'Reactor')]"));
        selectSong.click();
        Thread.sleep(2000);
    }

    public void clickAddButton() throws InterruptedException {
        WebElement addToButton = driver.findElement(By.xpath("//button[@class='btn-add-to']"));
        addToButton.click();
        Thread.sleep(2000);
    }

    public void selectPlaylist() throws InterruptedException {
        WebElement selectPlaylistName = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//section/ul//li[contains(text(),'PlayList')]"));
        selectPlaylistName.click();
        Thread.sleep(2000);
    }

    public String getNotificationMessage () {
        WebElement notificationMessage = driver.findElement(By.xpath("//div[@class='success show']"));
        return notificationMessage.getText();
    }

    public boolean notificationDisplayed() {
        WebElement notificationIsShown = driver.findElement(By.xpath("//div[@class='success show']"));
        return notificationIsShown.isDisplayed();
    }

   /* public void deleteSongFromPlaylist() throws InterruptedException {
        WebElement SelectPlaylist = driver.findElement(By.xpath("//a[@href='#!/playlist/37058']"));
        SelectPlaylist.click();
        Thread.sleep(2000);

        WebElement clickToSong = driver.findElement(By.xpath("//*[@id='playlistWrapper']/div/div/div[1]/table/tr/td[2]"));
        clickToSong.click();
        clickToSong.sendKeys(Keys.BACK_SPACE);
        Thread.sleep(2000);
    }*/


}
