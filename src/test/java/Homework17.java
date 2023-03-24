import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;

public class Homework17 extends BaseTest {


    @Test
    @Parameters ({"SongToSearch", "PlaylistToAddSong"})
    public void addSongToPlaylist (String song, String playlist) {

        //variables
        String msg = "Added 1 song into";

        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        BasePage basePage = new BasePage(getDriver());
        basePage.navigateToPage(homeUrl);
        loginPage.loginWithValidCredentials(email, password);
        //Search for a song (choose any song of your choice)
        String msgReturn = homePage.searchSong(song).viewSearchedSong().clickAddToPls(playlist);
        Assert.assertTrue(msgReturn.contains(msg));
    }
}
