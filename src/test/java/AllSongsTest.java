import org.testng.annotations.Test;
import pages.AllSongsPage;
import pages.HomePage;
import pages.LoginPage;

public class AllSongsTest extends BaseTest {
 @Test
 public void sortSongToVerifyNumbers() {
     LoginPage loginPage = new LoginPage(getDriver());
     HomePage homePage = new HomePage(getDriver());
     AllSongsPage allSongPage = new AllSongsPage(getDriver());
     loginPage.loginPageTest();
//     Thread.sleep(1000);
     allSongPage.clickAllSongsPage();
     allSongPage.clickSongTitleColumn();
     allSongPage.sortSongs();

     //Koel has the bug for sorting songs
 }

}