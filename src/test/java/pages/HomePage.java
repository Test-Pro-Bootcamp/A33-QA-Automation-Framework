package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePage extends BasePage {


    String NewNameTest = "Renamed Playlist";

//    By userAvatarIcon = By.cssSelector("img.avatar");
    By playlistInput = By.cssSelector(".playlist:nth-child(3)");
    By playlistNewBtn = By.cssSelector("i[data-testid='sidebar-create-playlist-btn']");
    By playlistContextMenu = By.xpath("//li[@data-testid='playlist-context-menu-create-simple']");
    By playlistInputField = By.cssSelector("[name='name']");
    By contextDeletePlaylist = By.xpath("//div[@class='song-list-controls']//button[@class='del btn-delete-playlist']");
    By playlistCreatedMsgLocator = By.xpath("//div[@class='alertify-logs top right']/div[@class='success show'][1]");
//    By clickPlaylistLocator = By.xpath("//*[@id='playlists']/ul/li[3]/a");
//    By clickDeletePlaylistLocator = By.xpath("//div[@class='song-list-controls']//button[@class='del btn-delete-playlist']");
    By doubleClickPlaylistName = By.cssSelector(".playlist:nth-child(3)");
    By msgDeletedPlaylistLocator = By.xpath("//div[@class='alertify-logs top right']/div[@class='success show'][2]");
    // Change [2] to [1] in case use this without playlistCreatedMsg().
    By enterPlaylistNameLocator = By.cssSelector("input[name='name']");
    By confirmNewPlaylistLocator = By.xpath("//a[text()='" + NewNameTest + "']");




    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

//    public WebElement getUserAvatar() {
//        return findElement(userAvatarIcon);
//
//    }


//    public void choosePlaylist() {
//        WebElement clickPlaylist = click(clickPlaylistLocator);
//        clickPlaylist.click();
//    }

    public void createPlaylist() {
        WebElement clickPlusButton = driver.findElement(playlistNewBtn);
        clickPlusButton.click();
        WebElement chooseSimplePlaylist = driver.findElement(playlistContextMenu);
        chooseSimplePlaylist.click();
        WebElement typeNewName = driver.findElement(playlistInputField);
        typeNewName.sendKeys("TestNewPlaylist", Keys.RETURN);
        playlistCreatedMsg();

    }

    public void deletePlaylist() {
        WebElement clickPlaylist = driver.findElement(playlistInput);
        clickPlaylist.click();
        WebElement deletePlaylistContextMenu = driver.findElement(contextDeletePlaylist);
        actions.contextClick(deletePlaylistContextMenu).perform();
        Assert.assertTrue(confirmNewPlaylistExist());
    }



//    public void clickDeletePlaylistBtn() {
//        WebElement deletePlaylistClick = click(clickDeletePlaylistLocator);
//        deletePlaylistClick.click();

//    }

    public String confirmNotification() {
        WebElement messageDelete = driver.findElement(msgDeletedPlaylistLocator);
        return messageDelete.getText();

    }


    @Test
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
        WebElement playlistInputField =driver.findElement(enterPlaylistNameLocator);
        playlistInputField.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
        playlistInputField.sendKeys(NewNameTest);
        playlistInputField.sendKeys(Keys.ENTER);

    }

    public boolean confirmNewPlaylistExist() {
        WebElement checkPlayList = driver.findElement(confirmNewPlaylistLocator);
        return checkPlayList.isDisplayed();
    }

    public boolean playlistCreatedMsg() {
        WebElement playlistWasMade = driver.findElement(playlistCreatedMsgLocator);
        return playlistWasMade.isDisplayed();

    }
}
