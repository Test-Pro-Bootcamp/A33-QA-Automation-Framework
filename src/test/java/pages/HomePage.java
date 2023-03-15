package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;
import java.util.List;

public class HomePage extends BasePage {
@FindBy(css = "img.avatar")
    private WebElement userAvatarIcon;
@FindBy(css = ".playlist:nth-child(3)")
    private WebElement firstPlaylist;
@FindBy(css = "input[name='name']" )
    private WebElement playlistInputField;
@FindBy(css = "[data-testid='play-next-btn']")
    private WebElement buttonPlayNextSong;
@FindBy(css = "[data-testid='play-btn']")
    private WebElement playButton;
@FindBy(css = "section.music a.songs")
    private WebElement chooseAllSongs;
@FindBy(css = ".btn-delete-playlist")
    private WebElement deletePlaylistButton;
@FindBy(css = ".playlist:nth-child(4)")
    private WebElement secondPlaylist;
@FindBy(css = "[data-testid = 'sound-bar-play']")
    private WebElement soundBarVisualizer;


    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }
    public HomePage playSong() {
        buttonPlayNextSong.click();
        playButton.click();
        return this;
    }
    public WebElement getUserAvatar() {
        return userAvatarIcon;
    }
    public HomePage doubleClickFirstPlaylist() {
        firstPlaylist.isDisplayed();
        actions.doubleClick(firstPlaylist).perform();
        return this;
    }
    public HomePage chooseSecondPlaylist() {
       secondPlaylist.click();
        return this;
    }

    public HomePage enterPlaylistName(String playlistName) {
        playlistInputField.sendKeys((Keys.chord(Keys.COMMAND, "a", Keys.DELETE)));
        playlistInputField.sendKeys(playlistName);
        playlistInputField.sendKeys(Keys.ENTER);
        return this;
    }
    public boolean doesPlaylistExist(String playlistName) {
        //WebElement playlistElement = driver.findElement(By.xpath("//a[text()='"+ playlistName+"']"));
        return firstPlaylist.isDisplayed();
    }
    public List displayAllSongs() {
        List<WebElement> songList = driver.findElements(By.cssSelector("section#playlistWrapper td.title"));
        return songList;
    }
    public String getPlaylistDetails() {
        return driver.findElement(By.cssSelector("span.meta.text-secondary span.meta")).getText();
    }
    public HomePage chooseAllSongsList() {
        chooseAllSongs.click();
        return this;
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("section.music a.songs"))).click();
    }
    public int countSongsInPlaylist() {
        return driver.findElements(By.cssSelector("section#playlistWrapper td.title")).size();
    }
    public HomePage openPlaylist() {
        //WebElement emptyPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".playlist:nth-child(3)")));
        firstPlaylist.click();
        return this;
    }
    public HomePage deletePlaylist() {

        deletePlaylistButton.click();
        return this;
    }
    public WebElement getDeletedPlaylistMessage() {
        return driver.findElement(By.cssSelector("div.success.show"));
    }
    public boolean isSongPlaying() {
//        WebElement soundBarVisualizer = driver.findElement(By.cssSelector("[data-testid = 'sound-bar-play']"));
//        return soundBarVisualizer.isDisplayed();
        return soundBarVisualizer.isDisplayed();
    }
}
