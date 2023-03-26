package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {
    private String playlistName = "HW25";
    @FindBy(css = "img.avatar")
    private WebElement userAvatarIcon;
    @FindBy(css = "[class='fa fa-plus-circle create']")
    private WebElement newPlaylistIcon;
    @FindBy(css = "[data-testid='playlist-context-menu-create-simple']")
    private WebElement newPlaylist;
    @FindBy(css = "input[name='name']")
    private WebElement nameField;
    @FindBy(css = "[type='search'")
    private WebElement searchSong;
    @FindBy(css = "button[data-test = 'view-all-songs-btn']")
    private WebElement clickViewAllBtn;
    @FindBy(css = "section#songResultsWrapper tr.song-item td.title")
    private WebElement firstSong;
    @FindBy(css = "button[class = 'btn-add-to']")
    private WebElement addToButton;
    @FindBy(xpath = "//*[@id='playlists']/ul/li[3]/a")
    private WebElement selectPlaylist;
    @FindBy(xpath = "//*[@id= 'songResultsWrapper']/header/div[3]/div/section[1]/ul/li[5]")
    private WebElement clickPlaylistNameFromAddBtn;
    @FindBy(xpath = "//*[@id='playlistWrapper']/div/div/div[1]/table")
    private WebElement selectTheSong;
    @FindBy(css = "[class='del btn-delete-playlist']")
    private WebElement deleteSong;
    @FindBy(css = "button[title='Delete this playlist'")
    private WebElement clickXPlaylistButton;
    @FindBy(css = ".playlist:nth-child(3)")
    private WebElement clickExistingPlaylist;
    @FindBy(xpath = "//a[contains(text(),'HW25')]")
    private WebElement choosePlaylist;
    @FindBy(css = "#playlists > ul > li:nth-child(3) > nav > ul > li:nth-child(1)")
    private WebElement editButton;
    @FindBy(css = "input[name='name']")
    private WebElement enterPlaylistNames;


    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
        driver = givenDriver;
    }

    public WebElement getUserAvatar() {
        return wait.until(ExpectedConditions.visibilityOf
                (userAvatarIcon));
    }

    public HomePage createPlaylist() {
        wait.until(ExpectedConditions.elementToBeClickable(newPlaylistIcon)).click();
        wait.until(ExpectedConditions.visibilityOf(newPlaylist)).click();
        wait.until(ExpectedConditions.elementToBeClickable(nameField)).sendKeys
                ((Keys.chord(playlistName, Keys.ENTER)));
        return this;
    }

    public static boolean newPlaylistIsDisplayed() {
        WebElement newPlaylist = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector
                ("a[class='active']")));
        return newPlaylist.isDisplayed();
    }

    public Object searchASong(String songName) {
        wait.until(ExpectedConditions.visibilityOf(searchSong)).sendKeys(songName);
        return this;
    }

    public HomePage clickViewAllButton() {
        wait.until(ExpectedConditions.visibilityOf(clickViewAllBtn)).click();
        return this;
    }

    public HomePage selectFirstSong() {
        wait.until(ExpectedConditions.visibilityOf(firstSong)).click();
        return this;
    }

    public HomePage clickAddToButton() {
        wait.until(ExpectedConditions.visibilityOf(addToButton)).click();
        return this;
    }

    public HomePage clickPlaylistNameFromAddToButton(String playlistName) {
        wait.until(ExpectedConditions.visibilityOf(clickPlaylistNameFromAddBtn));
        clickPlaylistNameFromAddBtn.click();
        return this;
    }

    public static boolean notificationMessageIsDisplayed() throws InterruptedException {
        WebElement getNotificationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector
                ("div.success.show")));
        return getNotificationMessage.isDisplayed();
        // public static boolean notificationMessageIsDisplayed(){
        //        WebElement getNotificationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector
        //                ("div.success.show")));
        //        return getNotificationMessage.isDisplayed();
        //    }
    }

    public HomePage deleteSongFromPlaylist() {
        wait.until(ExpectedConditions.visibilityOf(selectPlaylist)).click();
        wait.until(ExpectedConditions.visibilityOf(selectTheSong)).click();
        wait.until(ExpectedConditions.visibilityOf(deleteSong)).click();
        actions.sendKeys(Keys.DELETE).perform();
        return this;
    }

    public HomePage contextClickExistingPlaylist() {
        WebElement existingPlaylist = wait.until(ExpectedConditions.visibilityOf(clickExistingPlaylist));
        actions.contextClick(existingPlaylist).perform();
        return this;
       /*public HomePage contextClickExistingPlaylist () {
            contextClick(clickExistingPlaylist);
            return this;*/
    }

    public HomePage chooseEdit() {
        wait.until(ExpectedConditions.elementToBeClickable(editButton)).click();
        return this;
    }

    public HomePage renamePlaylist(String newPlaylistName) {
        wait.until(ExpectedConditions.visibilityOf(enterPlaylistNames));
        enterPlaylistNames.sendKeys((Keys.chord(Keys.COMMAND + "a", Keys.BACK_SPACE)), newPlaylistName, Keys.ENTER);
        return this;

    }

    public static boolean displayUpdatedPlaylist(String newPlaylistName) {
        WebElement updatedPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//a[text()= '" + newPlaylistName + "']")));
        return updatedPlaylist.isDisplayed();
    }
}


