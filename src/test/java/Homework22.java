import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;
import pages.*;
public class Homework22 extends BaseTest {
    @Test
    //GIVEN
    public void renamePlaylist() {
        String playlistName = "Playlist to Rename";
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.login();
        homePage.rightClickThirdPlaylist();
        homePage.renamePlaylist("Renamed playlist");
        Assert.assertTrue(homePage.isPlaylistRenamed(playlistName));
    }
}