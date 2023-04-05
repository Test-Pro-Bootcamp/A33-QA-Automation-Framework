package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    String newNameTest = "TestNewPlaylist";
    String renameTest = "Renamed Playlist";

    @FindBy(css = "img[alt='Avatar of Student']")
    private WebElement userAvatarIcon;
    By userAvatarIconBy = By.cssSelector("img[alt='Avatar of Student']");
    @FindBy(css = ".playlist:nth-child(3)")
    private WebElement playlistInput;
    @FindBy(css = "i[data-testid='sidebar-create-playlist-btn']")
    private WebElement playlistNewBtn;
    By playlistNewBtnBy = By.cssSelector("i[data-testid='sidebar-create-playlist-btn']");
    @FindBy(xpath = "//*[@id='playlists']/nav/ul/li[1]")
    private WebElement playlistContextMenu;
    By playlistContextMenuBy = By.xpath("//*[@id='playlists']/nav/ul/li[1]");
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
    By msgPlaylistLocatorBy = By.xpath("//div[@class='alertify-logs top right']/div[@class='success show'][1]");

    @FindBy(css = "input[name='name']")
    private WebElement enterPlaylistNameLocator;
    @FindBy(xpath = "//a[text()='\" + renameTest + \"']")
    private WebElement confirmNewPlaylistLocator;
    @FindBy(xpath = "//*[@id=\"songsWrapper\"]/div/div/div[1]/table/tr[1]/td[2]")
    private WebElement firstSongInThePlaylist;
    By firstSongInThePlaylistBy = By.xpath("//*[@id=\"songsWrapper\"]/div/div/div[1]/table/tr[1]/td[2]");
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

    By visualizerElementBy = By.xpath("//img[@alt='Sound bars']");
    @FindBy(xpath ="//li[@class='playback']")
    private WebElement pauseSongContext;

    By pauseSongContextBy = By.xpath("//li[@class='playback']");

    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public WebElement getUserAvatar() {
       return userAvatarIcon;
    }

    public boolean getUserAvatarFail() {
        driver.findElement(userAvatarIconBy);
        return false;
    }

    public HomePage choosePlaylist() {
        clickPlaylistLocator.click();
        return this;
    }

    public void createPlaylist() throws InterruptedException {
        Thread.sleep(500);
        click(playlistNewBtnBy);
        playlistNewBtn.click();
        Thread.sleep(2000);
       click(playlistContextMenuBy);
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
        wait.until(ExpectedConditions.visibilityOfElementLocated(msgPlaylistLocatorBy));
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
    public void clickFirstSong(){
        click(firstSongInThePlaylistBy);
    }
    public void playSongByClickingBtn() throws InterruptedException {
        click(firstSongInThePlaylistBy);
        actions.doubleClick(firstSongInThePlaylist).perform();

//        findElement(playBtnInConsoleBy);
//        playBtnInConsole.click();
//        Thread.sleep(1000);
    }

    public void pauseSongByClickingBtn() {
    click(firstSongInThePlaylistBy);
    actions.contextClick(firstSongInThePlaylist).perform();
        findElement(pauseSongContextBy).click();
    }

    public boolean visualizerIsDisplayed() {
       wait.until(ExpectedConditions.visibilityOf(visualizerElement));
        return visualizerElement.isDisplayed();

    }

    public boolean visualizerIsNotDisplayed() {
          wait.until(ExpectedConditions.invisibilityOfElementLocated(visualizerElementBy));

        return false;
    }


    public AllSongsPage clickAllSongsPage() {
        findElement(allSongsElement).click();
        return this.clickAllSongsPage();
    }

    public void clickLogOutBtn() {
        logOutBtn.click();

    }
}