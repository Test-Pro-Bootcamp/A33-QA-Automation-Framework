import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AllSongsPage;
import pages.HomePage;
import pages.LoginPage;

public class HomeTests extends BaseTest {
    @Test
    public void playSongTest()  {
        //GIVEN
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        AllSongsPage allSongPage = new AllSongsPage(getDriver());
        //WHEN
        loginPage.loginPageTest();
        allSongPage.clickAllSongsPage();
        homePage.playSongByClickingBtn();
        Assert.assertTrue(homePage.visualizerIsDisplayed());
    }
    @Test
    public void pauseSongTest()  {
        //GIVEN
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        AllSongsPage allSongPage = new AllSongsPage(getDriver());
        //WHEN
        loginPage.loginPageTest();
        allSongPage.clickAllSongsPage();
        homePage.playSongByClickingBtn();
//        Thread.sleep(2000);
        homePage.pauseSongByClickingBtn();
        //THEN
        Assert.assertFalse(homePage.visualizerIsNotDisplayed());
    }
}