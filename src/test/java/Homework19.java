import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;

public class Homework19 extends BaseTest{

    @Test
    @Parameters ({"Playlist"})
    public void deletePlaylist (String Playlist){

        //variables
        String msg = "Deleted playlist \"" + Playlist + ".\"";

        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        BasePage basePage = new BasePage(getDriver());
        basePage.navigateToPage(homeUrl);
        loginPage.loginWithValidCredentials(email, password);

        homePage.selectPlaylist(Playlist);
        System.out.println("Message should be: " + msg);
        String msgReturn = homePage.deleteSelectedPlaylist();
        Assert.assertTrue(msgReturn.contains(msg));
    }

}
