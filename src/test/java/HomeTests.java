import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AllSongsPage;
import pages.HomePage;
import pages.LoginPage;

public class HomeTests extends BaseTest {
    @Test
    public void playSongTest() throws InterruptedException {
        //GIVEN
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        AllSongsPage allSongPage = new AllSongsPage(driver);
        //WHEN
        loginPage.loginPageTest();
        allSongPage.clickAllSongsPage();
        homePage.playSongByClickingBtn();
        Assert.assertTrue(homePage.visualizerIsDisplayed());
    }
    @Test
    public void pauseSongTest() throws InterruptedException {
        //GIVEN
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        AllSongsPage allSongPage = new AllSongsPage(driver);
        //WHEN
        loginPage.loginPageTest();
        allSongPage.clickAllSongsPage();
        homePage.playSongByClickingBtn();
        Thread.sleep(2000);
        homePage.pauseSongByClickingBtn();
        //THEN
        Assert.assertFalse(homePage.visualizerIsNotDisplayed());
    }
}