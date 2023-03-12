import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest {

    @Test
    public void newSongToPlaylist()  {
        //etUpBrowser();
        //String url = "https://bbb.testpro.io/";
        //driver.get(url);
        //getBrowser();
        emailField("skillztomkid@gmail.com");
        passwordFinder("te$t$tudent");
        logIn();
        searchSongs("dark days");
        viewAll();
        clickFirstSong();
        addToPlaylist();
        newPlaylist("Ope");
        opePlaylist();
        deletePlaylist();
        notificationIcon();
        Assert.assertTrue(notificationVerification());
        //driver.wait(5000);
    }
}