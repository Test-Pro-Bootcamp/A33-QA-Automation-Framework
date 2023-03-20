import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class Homework22 extends BaseTest{
    @Test
    public void renamePlaylist() {
        String playlistName = "Test Pro Playlist";

        WebDriver driver = null;
        LoginPage loginPage = new LoginPage(null);
        HomePage homePage = new HomePage(null);

        loginPage.login();
        homePage.doubleClickFirstPlaylist();
        homePage.enterPlaylistName(playlistName);
        Assert.assertTrue(homePage.doesPlaylistExist(playlistName));
    }
}
