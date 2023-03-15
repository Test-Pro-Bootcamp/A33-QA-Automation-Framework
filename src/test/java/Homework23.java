import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;
import org.openqa.selenium.By;

public class Homework23 extends BaseTest {

    @Test(enabled = true, priority = 0, description = "Login with valid email and password")

    public void loginWithValidCredentialsTest(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login();
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }
    @Test(enabled = true, priority = 1, description = "Validate can create a playlist")
    public void createNewPlaylistTest(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login();
        homePage.createPlaylist();
        Assert.assertTrue(homePage.newPlaylistIsDisplayed());
    }
    @Test(enabled = true, priority = 2, description = "Validate can add a song to playlist")
    public void addSongToExistingPlaylistTest()  {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login();
        homePage.searchASong("Lost In Space")
                .clickViewAllButton()
                .selectFirstSong()
                .clickAddToButton()
                .clickPlaylistNameFromAddToButton("Sleepy Songs")
                .deleteSongFromPlaylist();
        Assert.assertTrue(homePage.notificationMessageIsDisplayed());
    }
    @Test(enabled = true, priority = 3, description = "Validate can rename an existing playlist")
    public void renamePlaylistTest(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login();
        homePage.contextClickExistingPlaylist()
                .chooseEdit()
                .renamePlaylist("Active Songs");
        Assert.assertTrue(homePage.displayUpdatedPlaylist("Active Songs"));
    }
    @Test (enabled = true, priority = 4, description = "Validate can delete a playlist")
    public void deletePlaylistTest(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login();
        homePage.clickUpdatedPlaylist()
                .deleteExistingPlaylist();
        Assert.assertTrue(homePage.getNotificationMessage());
    }

}
