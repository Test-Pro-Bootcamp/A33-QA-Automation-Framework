import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest {
//    Create a test case, playSong() using @Test annotation.
//    Use the helper/reusable methods we created.
//    Create a new config XML file for the test case.
//    Specify the method to be ran in the XML file.
//    Navigate to "https://bbb.testpro.io/".
//    Log in with your credentials.
//    Click «Play next song» (media player controls), then the Play button, to play a song.
//    Validate that a song is playing by verifying if the sound bar, or the pause button is displayed.

    @Test
    public void playSong () throws InterruptedException {

        //variables
        String homeUrl = "https://bbb.testpro.io/";
        String email = "me@elevchenko.com";
        String password = "$student1111";


        //Navigate to "https://bbb.testpro.io/"
        navigateToPage(homeUrl);
        //Log in with your credentials
        loginWithValidCredentials(email, password);
        playNextSong();
        Assert.assertTrue(isPlaying());
    }

}
