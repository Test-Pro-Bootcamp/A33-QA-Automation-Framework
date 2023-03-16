import Pages.HomePage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {


    String playlistNewName= "Ferrari";





    @Test
    public void renamePlaylist() throws InterruptedException{

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.login();
        homePage.doubleClickFirstPlaylist();
        homePage.enterPlaylistName(playlistNewName);
        Assert.assertTrue(homePage.ifNewPlaylistExists());

    }
}
