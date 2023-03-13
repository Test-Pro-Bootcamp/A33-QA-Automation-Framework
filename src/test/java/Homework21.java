import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.HomePage;

public class Homework21 extends BaseTest {

    @Test
    public void renamePlaylistTest() {

        //GIVEN
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        String currentPlaylistname = "PLDELTEST";
        String newPlaylistname = "PLRNTEST";
        loginPage.inputLogIn(email, password);

        //THEN
        homePage.createPlaylist(currentPlaylistname);
        homePage.findPlaylist(currentPlaylistname);
        homePage.startRenamingPlaylist();
        homePage.inputPlaylistName(newPlaylistname);
        System.out.printf(homePage.confirmPlaylistNameChange(newPlaylistname));

        //WHEN
        Assert.assertTrue(homePage.isPlaylistvisible(newPlaylistname).isDisplayed());
        homePage.openPlaylist();
        homePage.deleteEmptyPlaylist();
    }
}