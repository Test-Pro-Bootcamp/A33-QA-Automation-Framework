import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;
import java.util.Locale;

public class BaseTest {

    WebDriver driver;
    String url = "https://bbb.testpro.io/";

    public void openLoginUrl(){
     driver.get(url);
    }
    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    public void setUpBrowser(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
    public void urlAccess() throws InterruptedException{
        String url = "https://bbb.testpro.io/";
        driver.get(url);
        driver.manage().window().maximize();
        Thread.sleep(2000);
    }
    public void getEmail(String email) throws InterruptedException{
        WebElement insertEmail = driver.findElement(By.cssSelector("[type='email']"));
        insertEmail.click();
        insertEmail.sendKeys(email);
        Thread.sleep(2000);
    }
    public void getPassword(String password) throws InterruptedException{
        WebElement insertEmail = driver.findElement(By.cssSelector("[type='password']"));
        insertEmail.click();
        insertEmail.sendKeys(password);
        Thread.sleep(2000);
    }
    public void clickSubmit() {
        WebElement submitButtonElement = driver.findElement(By.cssSelector("[type='submit']"));
        submitButtonElement.click();
    }
    public void searchSong(String songName) throws InterruptedException{
        WebElement searchSong = driver.findElement(By.cssSelector("[type='Pluto']"));
        searchSong.sendKeys(songName);
        Thread.sleep(2000);
    }
    public void viewSearchResult() throws InterruptedException{
        WebElement viewSearchResult = driver.findElement(By.xpath("//h1[contains(text(), 'Songs')] " +
                "//button [contains(text(), 'View All')]"));
        viewSearchResult.click();
        Thread.sleep(2000);
    }

    public void selectFirstSongResult(String songName) throws InterruptedException{
        WebElement selectFirstSong = driver.findElement(By.xpath("//td[contains(text(), 'Take my Hand')]"));
        selectFirstSong.click();
        Thread.sleep(2000);
    }
    public void clickAddButton() throws InterruptedException{
        WebElement addButton = driver.findElement(By.cssSelector("button[class = 'btn-add-to']"));
        addButton.click();
        Thread.sleep(2000);
    }
    public void choosePlaylist(String playlistName) throws InterruptedException{
        WebElement playlistNameElement = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//section/ul/li[contains(text)),'"+playlistName+"')]"));
        playlistNameElement.click();
        Thread.sleep(2000);
    }
    public String getNotificationText(){
        WebElement notificationText = driver.findElement(By.cssSelector("div.success.show"));
        return notificationText.getText();
    }
    public boolean notificationDisplayed(){
        WebElement notificationShown = driver.findElement(By.xpath("//div[@class='success show']"));
        return notificationShown.isDisplayed();
    }
}
