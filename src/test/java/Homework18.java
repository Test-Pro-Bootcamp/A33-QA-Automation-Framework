import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest{

    @Test
    public void playSong (){

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
