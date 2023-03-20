import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.BasePage;
import Pages.LoginPage;
import Pages.HomePage;


public class Homework22 extends BaseTest{
    @Test
    public void renamePlaylistPOM(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.logIn();
        homePage.doubleClickPlaylist();
        homePage.enterNewPlaylistName();
        Assert.assertTrue(homePage.checkNewPlaylist());

    }
}
