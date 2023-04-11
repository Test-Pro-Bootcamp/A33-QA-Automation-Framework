import K_pages.AllSongsPage;
import K_pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Playlist2   extends BaseTest {


        @Test
        public void renamePlaylist (){
            String playlistName = "Christmas Music";
            LoginPage loginPage = new LoginPage(driver);
            AllSongsPage allSongsPage = new AllSongsPage(driver);

            loginPage.provideEmail()
                    .providePassword()
                    .clickSubmitBtn();
            allSongsPage.doubleClickOnPlaylist();
            allSongsPage.enterPlaylistNewName(playlistName);
            Assert.assertTrue(AllSongsPage.doesPlaylistExist(playlistName));
        }

    }


