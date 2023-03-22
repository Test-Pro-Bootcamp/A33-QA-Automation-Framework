package pages;

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
    private WebElement userAvatarIcon;
    @FindBy(css = ".playlist:nth-child(3)")
    private WebElement playlistInput;
    @FindBy(css = "i[data-testid='sidebar-create-playlist-btn']")
    private WebElement playlistNewBtn;
    @FindBy(css = "li[data-testid='playlist-context-menu-create-simple']")
    private WebElement playlistContextMenu;
    @FindBy(css = "[name='name']")
    private WebElement playlistInputField;
    @FindBy(xpath = "//div[@class='song-list-controls']//button[@class='del btn-delete-playlist']")
    private WebElement contextDeletePlaylist;
    @FindBy(xpath = "//div[@class='alertify-logs top right']/div[@class='success show'][1]")
    private WebElement playlistCreatedMsgLocator;
    @FindBy(xpath = "//*[@id='playlists']/ul/li[3]/a")
    private WebElement clickPlaylistLocator;
    @FindBy(xpath = "//div[@class='song-list-controls']//button[@class='del btn-delete-playlist']")
    private WebElement clickDeletePlaylistLocator;
    @FindBy(css = ".playlist:nth-child(3)")
    private WebElement doubleClickPlaylistName;
    @FindBy(xpath = "//div[@class='alertify-logs top right']/div[@class='success show'][1]")
    private WebElement msgDeletedPlaylistLocator;
    @FindBy(css = "input[name='name']")
    private WebElement enterPlaylistNameLocator;
    @FindBy(xpath = "//a[text()='\" + renameTest + \"']")
    private WebElement confirmNewPlaylistLocator;
    @FindBy(xpath = "//*[@id='playlistWrapper']/div//div[1]/table//td[2]")
    private WebElement firstSongInThePlaylist;


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

    public void createPlaylist() {
        wait.until(ExpectedConditions.elementToBeClickable(playlistNewBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(playlistContextMenu));
        playlistContextMenu.click();
//        actions.contextClick(playlistContextMenu).build().perform();
        wait.until(ExpectedConditions.elementToBeClickable(playlistInputField));
        playlistInputField.sendKeys((Keys.chord(newNameTest, Keys.RETURN)));

    }

    public HomePage deletePlaylist() {

        playlistInput.click();
        contextDeletePlaylist.click();
        return this;
    }

    public HomePage clickDeletePlaylistBtn() {
        clickDeletePlaylistLocator.click();
        return this;

    }

    public boolean confirmNotification() {
        return msgDeletedPlaylistLocator.isDisplayed();

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
        wait.until(ExpectedConditions.visibilityOf(playlistCreatedMsgLocator));
        return playlistCreatedMsgLocator.isDisplayed();

    }

    public boolean newSongExists() {
        return firstSongInThePlaylist.isDisplayed();


    }
}