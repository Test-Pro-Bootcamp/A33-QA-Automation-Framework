package pages;

import org.openqa.selenium.*;
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
    private WebElement msgPlaylistLocator;
    @FindBy(css = "input[name='name']")
    private WebElement enterPlaylistNameLocator;
    @FindBy(xpath = "//a[text()='\" + renameTest + \"']")
    private WebElement confirmNewPlaylistLocator;
    @FindBy(xpath = "//table/tr[1]/td[2]")
    private WebElement firstSongInThePlaylist;
    By firstSongInThePlaylistBy = By.xpath("//table/tr[1]/td[2]");
    //Or AllSongs page
    @FindBy(css = "[type='search']")
    private WebElement searchField;
    //    @FindBy(xpath = "//*[@id='sidebar']/section[1]/ul/li[3]/a")
//    private WebElement allSongsElement;
    By allSongsElement = By.xpath("//*[@id='sidebar']/section[1]/ul/li[3]/a");
    @FindBy(xpath = "//a[@class='logout control']")
    private WebElement logOutBtn;
    @FindBy(xpath = "//span[@title = 'Play or resume']")
    private WebElement playBtnInConsole;

    By playBtnInConsoleBy = By.xpath("//span[@title = 'Play or resume']");
    @FindBy(xpath = "//span[@title ='Pause']")
    private WebElement pauseBtnInConsole;

    By pauseBtnInConsoleBy = By.xpath("//span[@title ='Pause']");
    @FindBy(xpath = "//img[@alt='Sound bars']")
    private WebElement visualizerElement;
    @FindBy(xpath ="//li[@class='playback']")
    private WebElement pauseSongContext;

    By pauseSongContextBy = By.xpath("//li[@class='playback']");

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
        return msgPlaylistLocator.isDisplayed();

    }


    public void changePlaylistName() {
        doubleClickChoosePlaylist();
        enterPlaylistName();

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

    public void playSongByClickingBtn() throws InterruptedException {
        click(firstSongInThePlaylistBy);
        actions.doubleClick(firstSongInThePlaylist).perform();

//        findElement(playBtnInConsoleBy);
//        playBtnInConsole.click();
//        Thread.sleep(1000);
    }

    public void pauseSongByClickingBtn() {
    findElement(firstSongInThePlaylistBy).click();
    actions.contextClick(firstSongInThePlaylist).perform();
        findElement(pauseSongContextBy).click();
    }

    public boolean visualizerIsDisplayed() {
       wait.until(ExpectedConditions.visibilityOf(visualizerElement));
        return visualizerElement.isDisplayed();

    }

    public boolean visualizerIsNotDisplayed() {
        try {
            return !visualizerElement.isDisplayed();
        } catch (NoSuchElementException | StaleElementReferenceException e) {

            return false;
        }
    }

    public AllSongsPage clickAllSongsPage() {
        findElement(allSongsElement).click();
        return this.clickAllSongsPage();
    }

    public void clickLogOutBtn() {
        logOutBtn.click();

    }
}