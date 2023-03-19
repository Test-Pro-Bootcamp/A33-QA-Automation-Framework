import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.HomePage;

public class Homework21 extends BaseTest {

    @Test
    public void renamePlaylistTest() {

        //GIVEN
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        String currentPlaylistname = "PLDELTEST";
        String newPlaylistname = "PLRNTEST";
        loginPage.inputLogIn(email, password);

        //THEN
        homePage.createPlaylist(currentPlaylistname)
                .startRenameActivePlaylist()
                .inputPlaylistName(newPlaylistname);

        //WHEN
        Assert.assertTrue(homePage.confirmPlaylistNameChange(newPlaylistname));
        homePage.playlistContextDelete();
    }
}