import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class Homework20 extends BaseTest {


    @Test
    public void deletePlaylist() {
        setupClass();
        navigateToPage();
        provideEmail("test@test.com");
        providePassword("te$t$tudent");
        clickSubmit();
//        createPlaylist();
        choosePlaylist();
        clickDeletePlaylistBtn();
        Assert.assertTrue(confirmNotification().contains("Deleted playlist"));
//      closeBrowser();
    }

    public void createPlaylist()  {
        WebElement newPlaylistName = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("i[data-testid='sidebar-create-playlist-btn']")));
        newPlaylistName.click();
        WebElement clickPlusButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@data-testid='playlist-context-menu-create-simple']")));
        clickPlusButton.click();
        WebElement typeNewName = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[name='name']")));
        typeNewName.sendKeys("TestNewPlaylist", Keys.RETURN);


    }

    public void choosePlaylist()  {
        WebElement clickPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='playlists']/ul/li[3]/a")));
        clickPlaylist.click();

    }

    public void clickDeletePlaylistBtn()  {
        WebElement deletePlaylistClick = wait.until(ExpectedConditions.elementToBeClickable
                (By.xpath("//div[@class='song-list-controls']//button[@class='del btn-delete-playlist']")));
        deletePlaylistClick.click();

    }

    public String confirmNotification()  {
        WebElement messageDelete = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return messageDelete.getText();

    }

}
