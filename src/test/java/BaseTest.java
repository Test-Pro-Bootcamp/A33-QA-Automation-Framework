import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.time.Duration;


public class BaseTest {
static WebDriver driver;
static WebDriverWait wait;
static String url=null;
    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    @Parameters({"baseURL"})
    public void launchBrowser (String baseURL){
        ChromeOptions ops= new ChromeOptions();
        ops.addArguments("--remote-allow-origins=*");
     driver= new ChromeDriver(ops);
     wait=new WebDriverWait(driver,Duration.ofSeconds(10));
     url=baseURL;
     driver.get(url);
    }
    public void provideEmail(String email){
        WebElement emailField=wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='email']")));
        emailField.clear();
        emailField.sendKeys(email);
    }
    public void providePassword(String password){
        WebElement passwordField=wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='password']")));
        passwordField.clear();
        passwordField.sendKeys(password);
    }
    public void clickSubmit(){
        WebElement submitButton=wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='submit']")));
        submitButton.click();
    }
    public void logIn(String email,String password){
        provideEmail(email);
        providePassword(password);
        clickSubmit();
    }
    public void createPlaylist(){
        WebElement plusButton= wait.until(ExpectedConditions.elementToBeClickable
                (By.cssSelector("[class='fa fa-plus-circle create']")));
        plusButton.click();
        WebElement newPlaylist=wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector("li[data-testid='playlist-context-menu-create-simple']")));
        newPlaylist.click();
        WebElement  nameField=wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[name='name']")));
        nameField.clear();
        nameField.sendKeys("HW20Playlist");
        nameField.sendKeys(Keys.ENTER);    }
    public boolean newPlaylistIsDisplayed(){
        WebElement newPlaylist=wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.success.show")));
        return newPlaylist.isDisplayed();
    }
    public void searchASong(String songName) {
        WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='q']")));
        searchField.sendKeys(songName);
    }
    public void viewAllButton(){
    WebElement clickViewAll=wait.until(ExpectedConditions.elementToBeClickable
            (By.cssSelector("[data-test='view-all-songs-btn']")));
    clickViewAll.click();
}
    public void selectFirstSong(){
        WebElement firstSong=wait.until(ExpectedConditions.elementToBeClickable
                (By.xpath("//*[@id=\"songResultsWrapper\"]/div/div/div[1]/table/tr[1]/td[2]")));
        firstSong.click();
}
    public void clickAddButton(){
        WebElement addButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class='btn-add-to']")));
        addButton.click();
    }
    public void clickPlaylistNameFromAddToButton(String  playlistName){
        WebElement clickPlaylistName = wait.until(ExpectedConditions.elementToBeClickable
                (By.xpath("//section[@id='songResultsWrapper']//section/ul//li[contains(text(),'"+playlistName+"')]")));
       clickPlaylistName.click();
    }
    public boolean notificationMsgIsDisplayed(){
        WebElement showNotificationMsg=wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector("div.success.show")));
        return showNotificationMsg.isDisplayed();
    }
    public static void deleteSongFromPlaylist() {
        WebElement selectPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector
                ("li[class='playlist playlist']")));
        selectPlaylist.click();
        WebElement selectTheSong = wait.until(ExpectedConditions.elementToBeClickable(By.xpath
                ("//*[@id='playlistWrapper']/div/div/div[1]/table/tr/td[2]")));
        selectTheSong.click();
        WebElement deleteTheSong = wait.until(ExpectedConditions.elementToBeClickable(By.xpath
                ("//*[@id= 'playlistWrapper']/div/div/div[1]/table/tr")));
        Actions actions = new Actions(driver);
        actions.moveToElement(selectTheSong).click().sendKeys(Keys.DELETE).perform();
    }
    public static void accessMediaPlayerControls() {
        WebElement clickPlayNextSongControl = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector
                ("i[title='Play next song']")));
        clickPlayNextSongControl.click();

        WebElement clickPlayButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector
                ("span[title='Play or resume']")));
        clickPlayButton.click();
        Actions actions = new Actions(driver);
        actions.click(clickPlayButton).perform();
    }
    public static boolean playingSongIsDisplayed(){
        WebElement songIsPlaying = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//progress[@class='plyr__progress--played']")));
        return songIsPlaying.isDisplayed();
    }
    public static void clickExistingPlaylist() {
        WebElement clickPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath
                ("//a[contains(text(), 'HW20Playlist')]")));
        clickPlaylist.click();

    }
    public static void deleteExistingPlaylist(){
        WebElement clickXPlaylistButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector
                ("button[title='Delete this playlist']")));
        clickXPlaylistButton.click();
    }
    public static boolean getNotificationMessage(){
        WebElement notificationMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector
                ("div.success.show")));
        return notificationMessage.isDisplayed();
    }
    @AfterMethod
    public static void closeBrowser(){
        driver.quit();
    }


}



