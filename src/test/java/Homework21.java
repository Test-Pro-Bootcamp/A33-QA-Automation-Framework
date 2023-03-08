import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest {

    @Test
    @Parameters({"BaseUrl", "PlaylistToRename", "NewPlaylistName"})
    public void renamePlaylist (String BaseUrl, String PlaylistToRename, String NewPlaylistName) {

        //variables
        String email = "me@elevchenko.com";
        String password = "$student1111";
        String msg = "Updated playlist \"" + NewPlaylistName + ".\"";


        navigateToPage(BaseUrl);
        loginWithValidCredentials(email, password);

        System.out.println("Message should be: " + msg);
        String msgReturned = updatePlaylist(PlaylistToRename,NewPlaylistName);
        Assert.assertEquals(msgReturned,msg);
    }
}
