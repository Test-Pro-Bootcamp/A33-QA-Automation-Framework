import Pages.HomePage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework22 extends BaseTest {
    @Test(enabled = true, priority = 0, description = "Login with valid credentials")

    public void loginWithValidCredentials() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login();
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }

    @Test(enabled = true, priority = 1, description = "create a playlist")
    public void createNewPlaylist() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login();
        homePage.createPlaylist();
        Assert.assertTrue(HomePage.newPlaylistIsDisplayed());
    }

    @Test(enabled = true, priority = 2, description = " add a song to playlist")
    public void addSongToExistingPlaylist() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login();
        homePage.searchASong("Take  my Hand");
        homePage.clickViewAllButton();
        homePage.selectFirstSong();
        homePage.clickAddToButton();
        homePage.clickPlaylistNameFromAddToButton("HW22");
        Assert.assertTrue(HomePage.notificationMessageIsDisplayed());
        homePage.deleteSongFromPlaylist();
    }

    @Test(enabled = true, priority = 3, description = " rename an existing playlist")
    public void renamePlaylist() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login();
        homePage.contextClickExistingPlaylist();
        homePage.chooseEdit();
        homePage.renamePlaylist("Homework22");
        Assert.assertTrue(HomePage.displayUpdatedPlaylist("Homework22"));
    }

}

