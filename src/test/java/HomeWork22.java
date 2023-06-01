import org.testng.Assert;
import org.testng.annotations.Test;




public class HomeWork22 extends BaseTest {

    @Test
    public void renamePlaylist(){
        String playlistName = "HITS";

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

       


        homePage.doubleClickFirstPlayList();
        homePage.enterPlaylistName(playlistName);
        Assert.assertTrue(homePage.doesPlayListExit(playlistName));







    }

}
