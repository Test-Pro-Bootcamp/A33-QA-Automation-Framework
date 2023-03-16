import Pages.homePage;
import Pages.loginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework22 extends BaseTest {
    @Test(enabled = true, priority = 0, description = "Login with valid credentials")

    public void loginWithValidCredentials() {
        loginPage loginPage = new loginPage(driver);
        homePage homePage = new homePage(driver);

        loginPage.login();
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }

    @Test(enabled = true, priority = 1, description = "create a playlist")
    public void createNewPlaylist() {
        loginPage loginPage = new loginPage(driver);
        homePage homePage = new homePage(driver);

        loginPage.login();
        homePage.createPlaylist();
        Assert.assertTrue(Pages.homePage.newPlaylistIsDisplayed());
    }

    @Test(enabled = true, priority = 2, description = " add a song to playlist")
    public void addSongToExistingPlaylist() {
        loginPage loginPage = new loginPage(driver);
        homePage homePage = new homePage(driver);

        loginPage.login();
        homePage.searchASong("Take  my Hand");
        homePage.clickViewAllButton();
        homePage.selectFirstSong();
        homePage.clickAddToButton();
        homePage.clickPlaylistNameFromAddToButton("HW22");
        Assert.assertTrue(Pages.homePage.notificationMessageIsDisplayed());
        homePage.deleteSongFromPlaylist();
    }

    @Test(enabled = true, priority = 3, description = " rename an existing playlist")
    public void renamePlaylist() {
        loginPage loginPage = new loginPage(driver);
        homePage homePage = new homePage(driver);

        loginPage.login();
        homePage.contextClickExistingPlaylist();
        homePage.chooseEdit();
        homePage.renamePlaylist("Homework22");
        Assert.assertTrue(Pages.homePage.displayUpdatedPlaylist("Homework22"));
    }

}

