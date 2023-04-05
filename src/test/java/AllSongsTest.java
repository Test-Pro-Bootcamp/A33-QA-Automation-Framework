import org.testng.annotations.Test;
import pages.AllSongsPage;
import pages.HomePage;
import pages.LoginPage;

public class AllSongsTest extends BaseTest {
 @Test
 public void sortSongToVerifyNumbers() throws InterruptedException {
     LoginPage loginPage = new LoginPage(driver);
     HomePage homePage = new HomePage(driver);
     AllSongsPage allSongPage = new AllSongsPage(driver);
     loginPage.loginPageTest();
     Thread.sleep(1000);
     allSongPage.clickAllSongsPage();
     allSongPage.clickSongTitleColumn();
     allSongPage.sortSongs();

     //Koel has the bug for sorting songs
 }

}