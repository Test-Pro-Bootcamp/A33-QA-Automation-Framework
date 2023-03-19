package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Parameters;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;

public class SongsPage extends BasePage{

    @FindBy(css = "#songsWrapper [class='song-item']:nth-child(1)")
    private WebElement firstSong;

    @FindBy(css = "#songsWrapper [class='song-item playing selected']:nth-child(1)")
    private WebElement firstSongPlaying;

    @FindBy(css = "[class='songs']")
    private WebElement allSongsPage;

    @FindBy(css = "span[class='pause']")
    private WebElement pauseButton;

    @FindBy(css = "img[alt='Sound bars']")
    private WebElement mixer;

    @FindBy(css = "li[class='playback']")
    private WebElement playContextmenu;

    @FindBy(css = "li[class='has-sub']")
    private WebElement addtoContextmenu;



    public SongsPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public SongsPage playFirstSong() {
        wait.until(ExpectedConditions.elementToBeClickable((firstSong)));
        actions.doubleClick(firstSong).perform();
        return this;
    }

    public SongsPage songContextMenu() {
        wait.until(ExpectedConditions.visibilityOf(firstSong));
        wait.until(ExpectedConditions.elementToBeClickable((firstSong)));
        actions.contextClick(firstSong).perform();
        return this;
    }

    public SongsPage playContextMenu() {
        wait.until(ExpectedConditions.elementToBeClickable((playContextmenu)));
        playContextmenu.click();
        return this;
    }

    public SongsPage openAllSongs() {
        wait.until(ExpectedConditions.elementToBeClickable((allSongsPage)));
        allSongsPage.click();
        //driver.get(koelSongs);
        return this;
    }

    public WebElement getPauseButton(){
        wait.until(ExpectedConditions.visibilityOf(pauseButton));
        return pauseButton;
    }

    public SongsPage addtoContextMenu() {
        wait.until(ExpectedConditions.visibilityOf(addtoContextmenu));
        wait.until(ExpectedConditions.elementToBeClickable((addtoContextmenu)));
        addtoContextmenu.click();
        return this;
    }

    public SongsPage clickPlaylistfromAddto(String searchText) {
        WebElement playlistAddto = driver.findElement(By.xpath("//li[@class='has-sub'] //li[contains(text(),'" + searchText + "')]"));
        wait.until(ExpectedConditions.elementToBeClickable((playlistAddto)));
        playlistAddto.click();
        return this;
    }

    public void isMixerVisible() {
        Assert.assertTrue(mixer.isDisplayed());
    }
}
