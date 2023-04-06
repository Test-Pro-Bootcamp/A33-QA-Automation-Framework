import Pages.BasePage;
import Pages.HomePage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.*;

public class playlistTests extends BaseTest {

    @Test
    public void renamePlaylist(){
        String PlaylistName = "newPlaylistName";

        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.login();
        homePage.doubleClickFirstPlaylist();
        homePage.enterPlaylistName(PlaylistName);
        Assert.assertTrue(homePage.verifyNewPlaylist(PlaylistName));
    }
}
