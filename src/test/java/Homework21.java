
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

public class Homework21 extends BaseTest {

    String NewNameTest = "Renamed Playlist";
    @Test
    public void renamePlaylist() {
        setupClass();
        navigateToPage();
        provideEmail("test@test.com");
        providePassword("te$t$tudent");
        clickSubmit();
//        createPlaylist();
//        System.out.println(playlistCreatedMsg());
        doubleClickChoosePlaylist();
        enterPlaylistName();
        confirmNewPlaylistExist();
        Assert.assertTrue(confirmNewPlaylistExist());


//
    }

    public void createPlaylist() {
        WebElement newPlaylistName = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("i[data-testid='sidebar-create-playlist-btn']")));
        newPlaylistName.click();
        WebElement clickPlusButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@data-testid='playlist-context-menu-create-simple']")));
        clickPlusButton.click();
        WebElement typeNewName = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[name='name']")));
        typeNewName.sendKeys("TestNewPlaylist", Keys.RETURN);


    }

    public String playlistCreatedMsg() {
        WebElement playlistWasMade = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alertify-logs top right']/div[@class='success show'][1]")));
        return playlistWasMade.getText();


    }

    public void choosePlaylist() {
        WebElement clickPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='playlists']/ul/li[3]/a")));
        clickPlaylist.click();

    }

    public void clickDeletePlaylistBtn() {
        WebElement deletePlaylistClick = wait.until(ExpectedConditions.elementToBeClickable
                (By.xpath("//div[@class='song-list-controls']//button[@class='del btn-delete-playlist']")));
        deletePlaylistClick.click();

    }

    public String confirmNotification() {
        WebElement messageDelete = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alertify-logs top right']/div[@class='success show'][2]")));
        return messageDelete.getText();
////div[@class='alertify-logs top right']/div[text()='Deleted playlist']
    }


    public void doubleClickChoosePlaylist() {
        WebElement playlistElement = wait.until
                (ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
        actions.doubleClick(playlistElement).perform();

    }
    public void enterPlaylistName() {
    WebElement playlistInputField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[name='name']")));
    playlistInputField.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.BACK_SPACE));
    playlistInputField.sendKeys(NewNameTest);

    playlistInputField.sendKeys(Keys.ENTER);

    }
    public boolean confirmNewPlaylistExist() {
        WebElement checkPlayList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='"+NewNameTest+"']")));
        return checkPlayList.isDisplayed();
    }
}

