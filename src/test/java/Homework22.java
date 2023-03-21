import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework22 extends BaseTest {

    @Test
    public void renamePlaylist() {
        String playlistName = "Test Pro Playlist";

        LoginPage loginPage = new LoginPage(driver);
        HomePage homepage = new HomePage(driver);

        loginPage.login();
        homepage.doubleClickFirstPlaylist();
        homepage.enterPlaylistName(playlistName);
        Assert.assertTrue(homepage.doesPlaylistExists(playlistName));
    }
}
