import K_pages.AllSongsPage;
import K_pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlaylistTestHW22 extends BaseTest{


    @Test
    public void renamePlaylist () {
        String playlistName = "Emiliia Music";

        LoginPage loginPage = new LoginPage(driver);
        AllSongsPage allSongsPage = new AllSongsPage(driver);

        loginPage.login();
        allSongsPage.doubleClickOnPlaylist();
        allSongsPage.enterPlaylistNewName(playlistName);
        Assert.assertTrue(AllSongsPage.doesPlaylistExist(playlistName));
    }

}



