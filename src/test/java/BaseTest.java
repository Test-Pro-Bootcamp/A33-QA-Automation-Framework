import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.time.Duration;


public class BaseTest {

    public static WebDriver driver = null;

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public static void setUpBrowser(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterMethod
    public static void closeBrowser(){
        driver.quit();
    }

    public static void openPage(String url) {
        driver.get(url);
    }

    public static void enterEmail(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("[type = 'email']"));
        emailField.click();
        emailField.sendKeys(email);
    }

    public static void enterPassword(String password) {
        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        passwordField.click();
        passwordField.sendKeys(password);
    }

    public static void clickSubmit() throws InterruptedException {
        WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
        submitButton.click();
        Thread.sleep(2000);
    }

    public void searchForSong(String songName) throws InterruptedException {
        WebElement searchField = driver.findElement(By.cssSelector("[type='search']"));
        searchField.click();
        searchField.sendKeys(songName);
        Thread.sleep(2000);
    }

    public static void viewAllResults() throws InterruptedException {
        WebElement viewAllButton = driver.findElement(By.xpath("//*[@id=\"searchExcerptsWrapper\"]/div/div/section[1]/h1/button"));
        viewAllButton.click();
        Thread.sleep(2000);
    }

    public static void selectFirstSong() throws InterruptedException {
        WebElement selectFirstFromTheList = driver.findElement(By.xpath("//*[@id=\"songResultsWrapper\"]/div/div/div[1]/table/tr[1]/td[2]"));
        selectFirstFromTheList.click();
        Thread.sleep(2000);
    }

    public static void clickAddTo()  throws InterruptedException {
        WebElement addToButton = driver.findElement(By.cssSelector("[class='button.btn-add-to']"));
        addToButton.click();
        Thread.sleep(2000);
    }

    public static void choosePlaylist() throws InterruptedException {
        WebElement playList = driver.findElement(By.cssSelector("playlist My Playlist"));
        playList.click();
        Thread.sleep(2000);

    }
}
