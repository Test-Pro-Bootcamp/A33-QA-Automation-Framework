import Pages.Homepage;
import Pages.Loginpage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework22 extends BaseTest {
    public Homework22(WebDriver givenDriver) {

        super(givenDriver);
    }

    @Test
    public void renamePlaylist() {
        String playlistName = "Test Pro Playlist";
        Loginpage loginPage = new Loginpage(BaseTest.driver);
        Homepage homePage = new Homepage(BaseTest.driver);

        loginPage.login();
        homePage.doubleCLickFirstPlaylist();
        homePage.enterPlaylistName(playlistName);
        Assert.assertTrue(homePage.doesPlaylistExist(playlistName));
    }
}
