import K_pages.AllSongsPage;
import K_pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlaylistTests extends BaseTest {


    @Test
    public void renamePlaylist (){
        String playlistName = "Emiliia Music";
        LoginPage loginPage = new LoginPage(getThreadLocal());
        AllSongsPage allSongsPage = new AllSongsPage(getThreadLocal());

        loginPage.provideEmail();
        loginPage.providePassword();
        loginPage.clickSubmitBtn();
        allSongsPage.doubleClickOnPlaylist();
        allSongsPage.enterPlaylistNewName(playlistName);
        Assert.assertTrue(AllSongsPage.doesPlaylistExist(playlistName));
    }

}


