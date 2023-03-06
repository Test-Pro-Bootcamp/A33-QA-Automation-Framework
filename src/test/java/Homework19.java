import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest{
// Create a test case, deletePlaylist() using @Test annotation
// Use the helper/reusable methods we created.
// Use @Parameters for passing baseUrl from the TestNG config file to the tests.
// Navigate to "https://bbb.testpro.io/".
// Log in with your credentials.
// Click the playlist you want to delete.
// We should see a red button "x PLAYLIST" on the top right part of the page, and click on it.
// Note: If the red button is not displayed, let's create a new playlist and click it.
// Verify that the confirmation notification displayed has the text, "Deleted playlist {playlist name}".

    @Test
    @Parameters ({"BaseUrl", "Playlist"})
    public void deletePlaylist (String BaseUrl, String Playlist) throws InterruptedException {

        //variables
        String homeUrl = BaseUrl;
        String email = "me@elevchenko.com";
        String password = "$student1111";
        String playlist = Playlist;
        String msg = "Deleted playlist \"" + playlist + ".\"";

        //Navigate to BaseUrl, which is listed in TsetNG parameters ("https://bbb.testpro.io/")
        navigateToPage(homeUrl);
        //Log in with your credentials
        loginWithValidCredentials(email, password);
        selectPlaylist(playlist);
        System.out.println("Message should be: " + msg);
        String msgReturn = deleteSelectedPlaylist(playlist);
        Assert.assertTrue(msgReturn.contains(msg));
    }

}
