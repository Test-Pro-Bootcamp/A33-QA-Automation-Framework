import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AllSongsPage;
import pages.HomePage;
import pages.LoginPage;

public class PlaylistTest extends BaseTest {
    @Test
    public void createPlaylist() throws InterruptedException {
        //GIVEN
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        AllSongsPage allSongPage = new AllSongsPage(getDriver());
        //WHEN
        loginPage.loginPageTest();
        Thread.sleep(1000);
        homePage.createPlaylist();
        //THEN
        Assert.assertTrue(homePage.playlistCreatedMsg());
    }

    @Test(dependsOnMethods = {"createPlaylist"})
    public void deletePlaylistTest() throws InterruptedException {
        //GIVEN
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        //WHEN
        loginPage.loginPageTest();
        Thread.sleep(1000);

        homePage.deletePlaylist();
        //THEN
        Assert.assertTrue(homePage.confirmNotification());
    }

    @Test
    public void renamePlaylistTest() throws InterruptedException {
        //GIVEN
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        AllSongsPage allSongPage = new AllSongsPage(getDriver());
        loginPage.loginPageTest();
        Thread.sleep(1000);
        //WHEN
        homePage.createPlaylist();
        homePage.changePlaylistName();
        //THEN
        Assert.assertTrue(homePage.confirmNotification());
    }

    @Test
    public void addSongPlaylist() throws InterruptedException {
        //GIVEN
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        AllSongsPage allSongPage = new AllSongsPage(getDriver());
        loginPage.loginPageTest();
        Thread.sleep(2000);
        //WHEN
        homePage.createPlaylist();
        Thread.sleep(1000);
        allSongPage.addSongsToPlaylist();
        allSongPage.confirmSongIsAdded();
    }

    @Test
    public void addSongPlaylistDragAndDrop() throws InterruptedException {
        //GIVEN
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        AllSongsPage allSongPage = new AllSongsPage(getDriver());
        loginPage.loginPageTest();
        Thread.sleep(1000);
        //WHEN
        homePage.createPlaylist();
        Thread.sleep(1000);
        allSongPage.clickAllSongsPage();
//        Thread.sleep(1000);
        allSongPage.dropToAddSong();
        allSongPage.confirmSongIsAdded();
        driver.close();
    }


}