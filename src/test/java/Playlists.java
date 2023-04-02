import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;

public class Playlists extends BaseTest{

    @Test
    public void loginWithValidCredentials () {
        LoginPage loginPage = new LoginPage(getDriver());
        BasePage basePage = new BasePage(getDriver());
        basePage.navigateToPage(homeUrl);
        loginPage.loginWithValidCredentials(email, password);
        Assert.assertTrue(basePage.isAvatarIconDisplayed());
    }

    @Test
    @Parameters ({"Playlist"})
    public void createPlaylist (String Playlist){

        //variables
        String msg = "Created playlist \"" + Playlist + ".\"";

        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        BasePage basePage = new BasePage(getDriver());
        basePage.navigateToPage(homeUrl);
        loginPage.loginWithValidCredentials(email, password);

        System.out.println("Message should be: " + msg);
        String msgReturn = homePage.createThePlaylist(Playlist);
        Assert.assertTrue(msgReturn.contains(msg));
    }

    @Test (dependsOnMethods = {"createPlaylist"})
    @Parameters ({"Playlist"})
    public void deletePlaylist (String Playlist){

        //variables
        String msg = "Deleted playlist \"" + Playlist + ".\"";

        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        BasePage basePage = new BasePage(getDriver());
        basePage.navigateToPage(homeUrl);
        loginPage.loginWithValidCredentials(email, password);

        homePage.selectPlaylist(Playlist);
        System.out.println("Message should be: " + msg);
        String msgReturn = homePage.deleteSelectedPlaylist();
        Assert.assertTrue(msgReturn.contains(msg));
    }

    @Test
    @Parameters({"PlaylistToRename", "NewPlaylistName"})
    public void renamePlaylist (String PlaylistToRename, String NewPlaylistName) {

        //variables
        String msg = "Updated playlist \"" + NewPlaylistName + ".\"";

        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        BasePage basePage = new BasePage(getDriver());
        basePage.navigateToPage(homeUrl);
        loginPage.loginWithValidCredentials(email,password);

        System.out.println("Message should be: " + msg);
        String msgReturned = homePage.updatePlaylist(PlaylistToRename,NewPlaylistName);
        Assert.assertEquals(msgReturned,msg);
    }

}
