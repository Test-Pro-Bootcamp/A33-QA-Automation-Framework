
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
        HomePage homePage = new HomePage(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());
        AllSongsPage allSongsPage = new AllSongsPage(getDriver());

        loginPage.logIn();
        homePage.playSong();
        Assert.assertTrue(homePage.isSongPlaying());
    }
    @Test
    public void renamePlaylist() {
        HomePage homePage = new HomePage(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.logIn();
        homePage.doubleClickFirstPlaylist();
        homePage.enterPlaylistName(playlistName);
        Assert.assertTrue(homePage.doesPlaylistExist(playlistName));
    }

    public void deleteEmptyPlaylist()  {
        HomePage homePage = new HomePage(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.logIn();
        homePage.openPlaylist();
        homePage.deletePlaylist();
        WebElement deletedPlaylistMessage = homePage.getDeletedPlaylistMessage();
        Assert.assertTrue(deletedPlaylistMessage.isDisplayed());

    }
    @Test
    public void listOfSongsWebElements(){
        HomePage homePage = new HomePage(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.logIn();
        homePage.chooseSecondPlaylist();
        homePage.displayAllSongs();
        Assert.assertTrue(homePage.getPlaylistDetails().contains(String.valueOf(homePage.countSongsInPlaylist())));
    }
}
