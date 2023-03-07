import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest{

    @Test
    @Parameters ({"BaseUrl", "Playlist"})
    public void deletePlaylist (String BaseUrl, String Playlist){

        //variables
        String email = "me@elevchenko.com";
        String password = "$student1111";
        String msg = "Deleted playlist \"" + Playlist + ".\"";

        navigateToPage(BaseUrl);
        loginWithValidCredentials(email, password);
        selectPlaylist(Playlist);
        System.out.println("Message should be: " + msg);
        String msgReturn = deleteSelectedPlaylist();
        Assert.assertTrue(msgReturn.contains(msg));
    }

}
