import Pages.AllSongsPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.PlaylistPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddSongsToNewPlaylist extends BaseTest {
    @Test(priority = 1)
    public void loginValidCre() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login();
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }
    @Test(priority = 2)
    public void createNewPlaylist(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login();
        homePage.createPlaylist();
        Assert.assertTrue(homePage.newPlaylistIsDisplayed());
    }
    @Test(priority = 3)
    public void addSongToPlaylist(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        AllSongsPage allSongsPage = new AllSongsPage(driver);

        loginPage.login();
        allSongsPage.redirectToAllSongsPage();
        allSongsPage.chooseSong();
        allSongsPage.hoverOverToAddTo();
        allSongsPage.hoverOverTOPlaylist();
        allSongsPage.clickPlaylist();
        allSongsPage.songAddedMsgDisplayed();
    }
    @Test(priority = 4)
    public void DeleteSong(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        AllSongsPage allSongsPage = new AllSongsPage(driver);
        loginPage.login();
        homePage.choosePlaylist();
        allSongsPage.deleteSongFromPlaylist();
        Assert.assertTrue(allSongsPage.notificationSongDeleted());
    }
    @Test(priority = 5)
    public void DeletePlaylist(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        AllSongsPage allSongsPage = new AllSongsPage(driver);
        PlaylistPage playlistPage = new PlaylistPage(driver);

     loginPage.login();
     playlistPage.chooseThePlaylist();
     playlistPage.DeletePlaylist();
     Assert.assertTrue(playlistPage.notificationDeletedPlaylist());
    }
}
