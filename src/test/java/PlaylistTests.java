import Pages.HomePage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlaylistTests extends BaseTest{
    @Test
    public void renamePlaylist(){
        String playlistName = "Audi";

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);


        loginPage.login();
        homePage.doubleClickFirstPlaylist();
        homePage.enterPlaylistName("Ferrari");
        Assert.assertTrue(homePage.ifNewPlaylistExists());


    }
}
