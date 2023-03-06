import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest{

    @Test
    @Parameters ({"BaseUrl", "Playlist"})
    public void deletePlaylist (String BaseUrl, String Playlist){

        //variables
        String homeUrl = BaseUrl;
        String email = "me@elevchenko.com";
        String password = "$student1111";
        String playlist = Playlist;
        String msg = "Deleted playlist \"" + playlist + ".\"";

        navigateToPage(homeUrl);
        loginWithValidCredentials(email, password);
        selectPlaylist(playlist);
        System.out.println("Message should be: " + msg);
        String msgReturn = deleteSelectedPlaylist();
        Assert.assertTrue(msgReturn.contains(msg));
    }

}
