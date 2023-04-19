import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;
import pages.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.FindAll;
public class Homework23 extends BaseTest {
    @Test
    public void renamePlaylist() {
        String playlistName = "Renamed playlist";
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.login();
        homePage.rightClickThirdPlaylist().clickEditBtn().renamePlaylist(playlistName);
        Assert.assertTrue(homePage.isPlaylistRenamed(playlistName));
    }
}
