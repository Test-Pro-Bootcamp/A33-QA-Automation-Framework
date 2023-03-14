
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AllSongsPage;
import pages.HomePage;
import pages.LoginPage;
import pages.AllSongsPage;

public class HomePageTests extends BaseTest {
    String playlistName = "TestPro Playlist 123";
    @Test
    public void playSongTest()  {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        AllSongsPage allSongsPage = new AllSongsPage(driver);

        loginPage.logIn();
        homePage.playSong();
        Assert.assertTrue(allSongsPage.isSongPlaying());
    }
    @Test
    public void renamePlaylist() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        loginPage.logIn();
        homePage.doubleClickFirstPlaylist();
        homePage.enterPlaylistName(playlistName);
        Assert.assertTrue(homePage.doesPlaylistExist(playlistName));
    }
    @Test
    public void deleteEmptyPlaylist()  {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        loginPage.logIn();
        homePage.openPlaylist();
        homePage.deletePlaylist();
        WebElement deletedPlaylistMessage = homePage.getDeletedPlaylistMessage();
        Assert.assertTrue(deletedPlaylistMessage.isDisplayed());

    }

}
