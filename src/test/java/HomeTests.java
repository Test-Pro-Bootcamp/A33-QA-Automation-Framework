import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AllSongsPage;
import pages.HomePage;
import pages.LoginPage;

public class HomeTests extends BaseTest {
    @Test
    public void playSongTest() throws InterruptedException {
        //GIVEN
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        AllSongsPage allSongPage = new AllSongsPage(getDriver());
        //WHEN
        loginPage.loginPageTest();
        Thread.sleep(1000);
        homePage.playSongByClickingBtn();
        Thread.sleep(1000);
        Assert.assertTrue(homePage.visualizerIsDisplayed());
    }
    @Test
    public void pauseSongTest() throws InterruptedException {
        //GIVEN
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        AllSongsPage allSongPage = new AllSongsPage(getDriver());
        //WHEN
        loginPage.loginPageTest();
        Thread.sleep(1000);
        homePage.playSongByClickingBtn();
        Thread.sleep(1000);
        homePage.pauseSongByClickingBtn();
        //THEN
        Assert.assertTrue(homePage.visualizerIsNotDisplayed());
    }
}