import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;
import org.openqa.selenium.By;

public class HomeTests extends BaseTest {

    @Test(enabled = true, priority = 1, description = "Validate can create a playlist")
    public void createNewPlaylistTest(){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.login();
        homePage.createPlaylist();
        Assert.assertTrue(homePage.newPlaylistIsDisplayed());
    }
    @Test(enabled = true, priority = 2, description = "Validate can add a song to playlist")
    public void addSongToExistingPlaylistTest()  {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.login();
        homePage.searchASong("Lost In Space")
                .clickViewAllButton()
                .selectFirstSong()
                .clickAddToButton()
                .clickPlaylistNameFromAddToButton("Sleepy Songs");
        Assert.assertTrue(homePage.notificationMessageIsDisplayed());
//        homePage.deleteSongFromPlaylist();
    }
    @Test(enabled = true, priority = 3, description = "Validate can rename an existing playlist")
    public void renamePlaylistTest(){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.login();
        homePage.contextClickExistingPlaylist()
                .chooseEdit()
                .renamePlaylist("Active Songs");
        Assert.assertTrue(homePage.displayUpdatedPlaylist("Active Songs"));
    }
    @Test (enabled = true, priority = 4, description = "Validate can delete a playlist")
    public void deletePlaylistTest(){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.login();
        homePage.clickUpdatedPlaylist()
//                .deleteExistingPlaylist();
                .deleteFullPlaylist();
        Assert.assertTrue(homePage.getNotificationMessage());
    }

}