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

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login();
        homePage.doubleClickFirstPlaylist();
        homePage.enterPlaylistName(PlaylistName);
        Assert.assertTrue(homePage.verifyNewPlaylist(PlaylistName));
    }
}
