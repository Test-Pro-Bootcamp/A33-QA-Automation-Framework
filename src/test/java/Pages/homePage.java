package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class homePage extends basePage {
    WebDriver driver;
    static WebDriverWait wait;
    String playlistName = "HW22";
   By userAvatarIcon = By.cssSelector("img.avatar");
     By newPlaylistIcon = By.cssSelector("i[title='Create a new playlist']");
   By newPlaylist = By.cssSelector("li[data-testid='playlist-context-menu-create-simple']");
     By nameField = By.cssSelector("input[name='name']");
   By searchSong = By.cssSelector("[type='search'");
    By clickViewAllBtn = By.cssSelector("button[data-test = 'view-all-songs-btn']");
 By firstSong = By.cssSelector("section#songResultsWrapper tr.song-item td.title");
     By addToButton = By.cssSelector("button[class = 'btn-add-to']");
     By clickPlaylistNameFromAddToBtn = By.xpath
            ("//section[@id='songResultsWrapper']//section/ul//li[contains(text(), ' " + playlistName + "')]");
     By selectPlaylist = By.cssSelector("li[class='playlist playlist'");
     By selectTheSong = By.xpath("//*[@id='playlistWrapper']/div/div/div[1]/table/tr/td[2]");
     By deleteSong = By.xpath("//*[@id= 'playlistWrapper']/div/div/div[1]/table/tr");
     By clickPlaylist = By.xpath("//a[contains(text(), 'Sleepy Songs')]");
     By clickXPlaylistButton = By.cssSelector("button[title='Delete this playlist'");
     By clickExistingPlaylist = By.cssSelector(".playlist:nth-child(3)");
     By choosePlaylist = By.xpath("//a[contains(text(),'Active Songs')]");
    By editButton = By.cssSelector("#playlists > ul > li:nth-child(3) > nav > ul > li:nth-child(1)");
     By enterPlaylistNames = By.cssSelector("input[name='name']");
    public homePage(WebDriver givenDriver){ super(givenDriver);
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public WebElement getUserAvatar(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated
                (userAvatarIcon));
    }
    public void createPlaylist(){
        wait.until(ExpectedConditions.elementToBeClickable(newPlaylistIcon)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(newPlaylist)).click();
        wait.until(ExpectedConditions.elementToBeClickable(nameField)).sendKeys
                ((Keys.chord(playlistName, Keys.ENTER)));
    }
    public static boolean newPlaylistIsDisplayed(){
        WebElement newPlaylist = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector
                ("a[class='active']")));
        return newPlaylist.isDisplayed();
    }
    public void searchASong(String songName){
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchSong)).sendKeys(songName);
    }
    public void clickViewAllButton(){
        wait.until(ExpectedConditions.elementToBeClickable(clickViewAllBtn)).click();
    }
    public void selectFirstSong(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstSong)).click();
    }
    public void clickAddToButton(){
        wait.until(ExpectedConditions.elementToBeClickable(addToButton)).click();
    }
    public void clickPlaylistNameFromAddToButton(String playlistName){
        wait.until(ExpectedConditions.elementToBeClickable(clickPlaylistNameFromAddToBtn)).click();
    }
    public static boolean notificationMessageIsDisplayed(){
        WebElement getNotificationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector
                ("div.success.show")));
        return getNotificationMessage.isDisplayed();
    }
    public void deleteSongFromPlaylist(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(selectPlaylist)).click();
        wait.until(ExpectedConditions.elementToBeClickable(selectTheSong)).click();
        wait.until(ExpectedConditions.elementToBeClickable(deleteSong)).click();
        actions.sendKeys(Keys.DELETE).perform();
    }
    public void clickUpdatedPlaylist(){
        wait.until(ExpectedConditions.elementToBeClickable(choosePlaylist)).click();
    }
    public void deleteExistingPlaylist(){
        wait.until(ExpectedConditions.elementToBeClickable(clickXPlaylistButton)).click();
    }
    public static boolean getNotificationMessage(){
        WebElement notificationMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector
                ("div.success.show")));
        return notificationMessage.isDisplayed();
    }
    public void contextClickExistingPlaylist(){
        contextClick(clickExistingPlaylist);
    }
    public void chooseEdit(){
        wait.until(ExpectedConditions.elementToBeClickable(editButton)).click();
    }
    public void renamePlaylist(String newPlaylistName){
        WebElement enterPlaylistName = wait.until(ExpectedConditions.elementToBeClickable(enterPlaylistNames));
        enterPlaylistName.sendKeys((Keys.chord(Keys.COMMAND + "a")));
        enterPlaylistName.sendKeys(Keys.BACK_SPACE);
        enterPlaylistName.sendKeys(newPlaylistName);
        enterPlaylistName.sendKeys(Keys.ENTER);
    }
    public static boolean displayUpdatedPlaylist(String newPlaylistName){
        WebElement updatedPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//a[text()= '" +newPlaylistName+"']")));
        return updatedPlaylist.isDisplayed();
    }
}

