import org.apache.commons.io.input.WindowsLineEndingInputStream;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class Homework21 extends BaseTest {
    String playlistName = "Test Pro Playlist";

    @Test
    public void playSong() {
        logIn();
        chooseAllSongsList();
        contextClickFirstSong();
        choosePlay();
        Assert.assertTrue(isSongPlaying());
    }
    @Test
    public void renamePlaylist() {
        logIn();
        doubleClickChoosePlaylist();
        enterPlaylistName();
        Assert.assertTrue(doesPlaylistExist());

    }
    @Test
    public void listOfSongsWebElements(){
        logIn();
        choosePlaylist();
        displayAllSongs();
        Assert.assertTrue(getPlaylistDetails().contains(String.valueOf(countSongsInPlaylist())));

    }
    @Test
    public void hoverOverPlayBtn() {
        logIn();
        chooseAllSongsList();
        hoverToPlayBtn();
        Assert.assertTrue(hoverToPlayBtn().isDisplayed());
    }
//these are the helper methods:
    public void choosePlaylist() {
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)"))).click();
}
    public void choosePlaylistByName(String name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(), '" + name + "']"))).click();
    }
    public String getPlaylistDetails() {
        return driver.findElement(By.cssSelector("span.meta.text-secondary span.meta")).getText();
    }
    public boolean doesPlaylistExist(){
        WebElement playlistElement = driver.findElement(By.xpath("//a[text()='" + playlistName + "']"));
        return playlistElement.isDisplayed();
    }

   public void contextClickChoosePlaylist() {
       wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".playlist:nth-child(3)")));
       WebElement playlistElement = driver.findElement(By.cssSelector(".playlist:nth-child(3)"));
       actions.contextClick(playlistElement).perform();
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li[data-testid='playlist-context-menu-edit']")));
   }
   public void doubleClickChoosePlaylist(){
       wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".playlist:nth-child(3)")));
       WebElement playlistElement = driver.findElement(By.cssSelector(".playlist:nth-child(3)"));
       actions.doubleClick(playlistElement).perform();
   }
    public void enterPlaylistName() {
        WebElement playlistInputField = driver.findElement(By.cssSelector("Input[name='name']"));
        //we need to clear the current input field
        playlistInputField.sendKeys((Keys.chord(Keys.COMMAND, "a", Keys.DELETE)));
        playlistInputField.sendKeys(playlistName);
        playlistInputField.sendKeys(Keys.ENTER);
    }
   public void chooseAllSongsList() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("section.music a.songs"))).click();
    }
    public int countSongsInPlaylist() {
        return driver.findElements(By.cssSelector("section#playlistWrapper td.title")).size();
    }
    public List displayAllSongs() {
        List<WebElement> songList = driver.findElements(By.cssSelector("section#playlistWrapper td.title"));
        return songList;
    }
    public void contextClickFirstSong() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".all-songs tr.song-item:nth-child(1)")));
        WebElement firstSong = driver.findElement(By.cssSelector(".all-songs tr.song-item:nth-child(1)"));
        actions.contextClick(firstSong).perform();
    }
    public void choosePlay() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("nav.menu.song-menu li.playback"))).click();
    }
    public boolean isSongPlaying() {
        WebElement soundBarVisualizer = driver.findElement(By.cssSelector("[data-testid = 'sound-bar-play']"));
        return soundBarVisualizer.isDisplayed();
    }
    //example helper method to hover over an element
    public WebElement hoverToPlayBtn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-testid='play-btn']")));
        WebElement playButton = driver.findElement(By.xpath("//span[@data-testid='play-btn']"));
        actions.moveToElement(playButton).perform();
        return playButton;
    }
}
