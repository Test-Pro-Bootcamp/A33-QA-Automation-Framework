package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage extends BasePage {
//    WebDriver driver;
//    WebDriverWait wait;
    By userAvatarIcon = By.cssSelector("img.avatar");
    By firstPlaylist = By.cssSelector(".playlist:nth-child(3)");
    By playlistInputField = By.cssSelector("input[name='name']");
    By buttonPlayNextSong = By.cssSelector("[data-testid='play-next-btn']");
    By playButton = By.cssSelector("[data-testid='play-btn']");

    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }
    public void playSong() {
        //WebElement buttonPlayNextSong = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-testid='play-next-btn']")));
        WebElement buttonPlayNextSong = driver.findElement(By.cssSelector("[data-testid='play-next-btn']"));
        buttonPlayNextSong.click();

        WebElement playButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-testid='play-btn']")));
        playButton.click();
    }
    public WebElement getUserAvatar() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(userAvatarIcon));
    }
    public void doubleClickFirstPlaylist() {
        doubleClick(firstPlaylist);
    }
    public void enterPlaylistName(String playlistName) {
        WebElement playlistNameTextField = findElement(playlistInputField);
        playlistNameTextField.sendKeys((Keys.chord(Keys.COMMAND, "a", Keys.DELETE)));
        playlistNameTextField.sendKeys(playlistName);
        playlistNameTextField.sendKeys(Keys.ENTER);
    }
    public boolean doesPlaylistExist(String playlistName) {
        WebElement playlistElement = driver.findElement(By.xpath("//a[text()='"+ playlistName+"']"));
        return playlistElement.isDisplayed();
    }
    public List displayAllSongs() {
        List<WebElement> songList = driver.findElements(By.cssSelector("section#playlistWrapper td.title"));
        return songList;
    }
    public void chooseAllSongsList() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("section.music a.songs"))).click();
    }
    public boolean isSongPlaying() {
        WebElement soundBarVisualizer = driver.findElement(By.cssSelector("[data-testid = 'sound-bar-play']"));
        return soundBarVisualizer.isDisplayed();
    }

    public void openPlaylist() {
        WebElement emptyPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".playlist:nth-child(3)")));
        emptyPlaylist.click();
    }
    public void deletePlaylist() {
        WebElement deletePlaylistButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn-delete-playlist")));
        deletePlaylistButton.click();
    }
    public WebElement getDeletedPlaylistMessage() {
        return driver.findElement(By.cssSelector("div.success.show"));
    }
    public void choosePlaylist() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)"))).click();
    }
}
