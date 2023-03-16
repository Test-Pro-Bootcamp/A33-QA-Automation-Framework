package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    String newNameTest = "TestNewPlaylist";
    String renameTest = "Renamed Playlist";

    @FindBy(css = "[img.avatar]")
    WebElement userAvatarIcon;
    @FindBy(css = ".playlist:nth-child(3)")
    WebElement playlistInput;
    @FindBy(css = "i[data-testid='sidebar-create-playlist-btn']")
    WebElement playlistNewBtn;
    @FindBy(xpath = "//li[@data-testid='playlist-context-menu-create-simple']")
    WebElement playlistContextMenu;
    @FindBy(css = "[name='name']")
    WebElement playlistInputField;
    @FindBy(xpath = "//div[@class='song-list-controls']//button[@class='del btn-delete-playlist']")
    WebElement contextDeletePlaylist;
    @FindBy(xpath = "//div[@class='alertify-logs top right']/div[@class='success show'][1]")
    WebElement playlistCreatedMsgLocator;
    @FindBy(xpath = "//*[@id='playlists']/ul/li[3]/a")
    WebElement clickPlaylistLocator;
    @FindBy(xpath = "//div[@class='song-list-controls']//button[@class='del btn-delete-playlist']")
    WebElement clickDeletePlaylistLocator;
    @FindBy(css = ".playlist:nth-child(3)")
    WebElement doubleClickPlaylistName;
    @FindBy(xpath = "//div[@class='alertify-logs top right']/div[@class='success show'][2]")
    WebElement msgDeletedPlaylistLocator;
    @FindBy(css = "input[name='name']")
    WebElement enterPlaylistNameLocator;
    @FindBy(xpath = "//a[text()='\" + renameTest + \"']")
   WebElement confirmNewPlaylistLocator;
    @FindBy(xpath = "//*[@id='playlistWrapper']/div//div[1]/table//td[2]")
    WebElement firstSongInThePlaylist;


    public HomePage(WebDriver givenDriver) {
         super(givenDriver);
    }

    public WebElement getUserAvatar() {
        return userAvatarIcon;

    }

    public HomePage choosePlaylist() {
        clickPlaylistLocator.click();
        return this;
    }

    public HomePage createPlaylist() {
        wait.until(ExpectedConditions.elementToBeClickable(playlistNewBtn));
        playlistNewBtn.click();
        playlistContextMenu.click();
        playlistInputField.sendKeys(newNameTest, Keys.RETURN);
        return this;
    }

    public HomePage deletePlaylist() {
        playlistInput.click();
        actions.contextClick(contextDeletePlaylist).perform();
        return this;
    }

    public HomePage clickDeletePlaylistBtn() {
        clickDeletePlaylistLocator.click();
        return this;

    }

    public HomePage confirmNotification() {
       msgDeletedPlaylistLocator.getText();
       return this;

    }


    public void changePlaylistName() {
        doubleClickChoosePlaylist();
        enterPlaylistName();
        confirmNotification();
        playlistCreatedMsg();
    }

    public HomePage doubleClickChoosePlaylist() {
       actions.doubleClick(doubleClickPlaylistName).perform();
       return this;
    }

    public HomePage enterPlaylistName() {
        enterPlaylistNameLocator.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
        enterPlaylistNameLocator.sendKeys(renameTest);
        enterPlaylistNameLocator.sendKeys(Keys.ENTER);
        return this;
    }


    public HomePage confirmNewPlaylistExist() {
       confirmNewPlaylistLocator.isDisplayed();
       return this;
    }

    //right top green message
    public boolean playlistCreatedMsg() {
        wait.until(ExpectedConditions.visibilityOfElementLocated((By) playlistCreatedMsgLocator));
       return playlistCreatedMsgLocator.isDisplayed();

    }

    public boolean newSongExists() {
        choosePlaylist();
       return firstSongInThePlaylist.isDisplayed();


    }
}