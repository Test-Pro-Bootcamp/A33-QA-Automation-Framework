import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest {
    @Test
    public void renamePlaylist()  {
        //setUpBrowser();
        //String url = "https://bbb.testpro.io/";
        //driver.get(url);
        //getBrowser();
        emailField("skillztomkid@gmail.com");
        passwordFinder("te$t$tudent");
        logIn();
        editPlaylist();
        notificationIcon();
        Assert.assertTrue(notificationVerification());

        //editPlaylist();
        //searchSongs("dark days");
        //viewAll();
        //clickFirstSong();
       // addToPlaylist();
       // newPlaylist("Ope");
       // opePlaylist();
       // deletePlaylist();
       // notificationIcon();
       // Assert.assertTrue(notificationVerification());
       // driver.wait(5000);

    }
}
