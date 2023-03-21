import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;

public class Homework18 extends BaseTest{

    @Test
    public void playSong () {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage(homeUrl);
        loginPage.loginWithValidCredentials(email, password);
        Assert.assertTrue(homePage.playNextSong().isPlaying());
    }

}
