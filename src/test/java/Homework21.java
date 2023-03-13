import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;

public class Homework21 extends BaseTest {

    @Test
    @Parameters({"BaseUrl", "PlaylistToRename", "NewPlaylistName"})
    public void renamePlaylist (String BaseUrl, String PlaylistToRename, String NewPlaylistName) {

        //variables
        String email = "me@elevchenko.com";
        String password = "$student1111";
        String msg = "Updated playlist \"" + NewPlaylistName + ".\"";

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage(BaseUrl);
        loginPage.loginWithValidCredentials(email, password);

        System.out.println("Message should be: " + msg);
        String msgReturned = homePage.updatePlaylist(PlaylistToRename,NewPlaylistName);
        Assert.assertEquals(msgReturned,msg);
    }
}
