import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest {

    // Create a test case, addSongToPlaylist() using @Test annotation
    //and the helper/reusable methods we created.

    @Test
    public void addSongToPlaylist () throws InterruptedException {

        String playlist = "Motivating songs";
        String msg = "Added 1 song into";
        String song = "Pluto";
        String homeUrl = "https://bbb.testpro.io/";

        //Navigate to "https://bbb.testpro.io/"
        navigateToPage(homeUrl);
        //Log in with your credentials
        loginWithValidCredentials("me@elevchenko.com", "$student1111");
        //Search for a song (choose any song of your choice)
        searchSong(song);
        //Click View All to display the search results
        viewAllSongs();
        selectFirstSong(); //Click the first song

        //Click ADD TO...  playlist, Verify that the notification message appears and says "Added 1 song into {your playlist}"
        String msgReturn = clickAddToPls(playlist);
        Assert.assertTrue(msgReturn.contains(msg));
    }
}
