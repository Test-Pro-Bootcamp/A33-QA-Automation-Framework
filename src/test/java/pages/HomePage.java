package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePage extends BasePage {

    String newNameTest = "TestNewPlaylist";
    String renameTest = "Renamed Playlist";
    private By userAvatarIcon = By.cssSelector("img.avatar");
    private By playlistInput = By.cssSelector(".playlist:nth-child(3)");
    private By playlistNewBtn = By.cssSelector("i[data-testid='sidebar-create-playlist-btn']");
    private By playlistContextMenu = By.xpath("//li[@data-testid='playlist-context-menu-create-simple']");
    private By playlistInputField = By.cssSelector("[name='name']");
    private By contextDeletePlaylist = By.xpath("//div[@class='song-list-controls']//button[@class='del btn-delete-playlist']");
    private By playlistCreatedMsgLocator = By.xpath("//div[@class='alertify-logs top right']/div[@class='success show'][1]");
    private By clickPlaylistLocator = By.xpath("//*[@id='playlists']/ul/li[3]/a");
    private By clickDeletePlaylistLocator = By.xpath("//div[@class='song-list-controls']//button[@class='del btn-delete-playlist']");
    private By doubleClickPlaylistName = By.cssSelector(".playlist:nth-child(3)");
    private By msgDeletedPlaylistLocator = By.xpath("//div[@class='alertify-logs top right']/div[@class='success show'][2]");

    private By enterPlaylistNameLocator = By.cssSelector("input[name='name']");
    private By confirmNewPlaylistLocator = By.xpath("//a[text()='" + renameTest + "']");
    public By firstSongInThePlaylist = By.xpath("//*[@id='playlistWrapper']/div//div[1]/table//td[2]");


    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public WebElement getUserAvatar() {
        return findElement(userAvatarIcon);

    }

    public void choosePlaylist() {
        WebElement clickPlaylist = driver.findElement(clickPlaylistLocator);
        clickPlaylist.click();
    }

    public void createPlaylist() {
        WebElement clickPlusButton = wait.until(ExpectedConditions.elementToBeClickable(playlistNewBtn));
        clickPlusButton.click();
        WebElement chooseSimplePlaylist = wait.until(ExpectedConditions.elementToBeClickable(playlistContextMenu));
        chooseSimplePlaylist.click();
        WebElement typeNewName = wait.until(ExpectedConditions.elementToBeClickable(playlistInputField));
        typeNewName.sendKeys("newNameTest", Keys.RETURN);
        playlistCreatedMsg();

    }

    public void deletePlaylist() {
        WebElement clickPlaylist = wait.until(ExpectedConditions.elementToBeClickable(playlistInput));
        clickPlaylist.click();
        WebElement deletePlaylistContextMenu = wait.until(ExpectedConditions.elementToBeClickable(contextDeletePlaylist));
        actions.contextClick(deletePlaylistContextMenu).perform();
        Assert.assertTrue(confirmNewPlaylistExist());
    }

    public void clickDeletePlaylistBtn() {
        WebElement deletePlaylistClick = driver.findElement(clickDeletePlaylistLocator);
        deletePlaylistClick.click();
    }

    public String confirmNotification() {
        WebElement messageDelete = driver.findElement(msgDeletedPlaylistLocator);
        return messageDelete.getText();
    }


    public void changePlaylistName() {
        doubleClickChoosePlaylist();
        enterPlaylistName();
        confirmNotification();
        playlistCreatedMsg();
    }

    public void doubleClickChoosePlaylist() {
        WebElement playlistElement = driver.findElement(doubleClickPlaylistName);
        actions.doubleClick(playlistElement).perform();
    }

    public void enterPlaylistName() {
        WebElement playlistInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(enterPlaylistNameLocator));
        playlistInputField.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
        playlistInputField.sendKeys(renameTest);
        playlistInputField.sendKeys(Keys.ENTER);
    }


    public boolean confirmNewPlaylistExist() {
        WebElement checkPlayList = driver.findElement(confirmNewPlaylistLocator);
        return checkPlayList.isDisplayed();
    }

    //right top green message
    public boolean playlistCreatedMsg() {
        WebElement playlistWasMade = wait.until(ExpectedConditions.visibilityOfElementLocated(playlistCreatedMsgLocator));
        return playlistWasMade.isDisplayed();
    }

    public boolean newSongExists() {
        choosePlaylist();
        WebElement newSongIsInPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(firstSongInThePlaylist));
        return newSongIsInPlaylist.isDisplayed();

    }
}