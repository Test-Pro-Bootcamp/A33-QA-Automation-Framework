import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.SearchPage;

public class SearchTest extends BaseTest {
    String query = "dark";

    @Test(enabled = true, description = "validate user can search a song")
    public void findSongUsingSearchBar() throws InterruptedException {
        //GIVEN
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        SearchPage searchPage = new SearchPage(getDriver());
        //WHEN
        loginPage.loginPageTest();
        Thread.sleep(1000);
        searchPage.typeSearchQuery(query);
        //THEN
        searchPage.songIsDisplayed();
    }

    @Test(enabled = true, description = "validate user can search a song")
    public void findArtistUsingSearchBar() throws InterruptedException {
        //GIVEN
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        SearchPage searchPage = new SearchPage(getDriver());
        //WHEN
        loginPage.loginPageTest();
        Thread.sleep(1000);
        searchPage.typeSearchQuery(query);
        //THEN
        searchPage.artistIsDisplayed();
    }

    @Test(enabled = true, description = "validate user can search a song")
    public void findAlbumUsingSearchBar() throws InterruptedException {
        //GIVEN
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        SearchPage searchPage = new SearchPage(getDriver());
        //WHEN
        loginPage.loginPageTest();
        Thread.sleep(1000);
        searchPage.typeSearchQuery(query);
        //THEN
        searchPage.albumIsDisplayed();
    }
}