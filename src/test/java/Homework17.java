import org.testng.annotations.Test;

public class Homework17 extends BaseTest {

    @Test
    public void newSongToPlaylist() throws InterruptedException {
        setUpBrowser();
        String url = "https://bbb.testpro.io/";
        driver.get(url);
        //getBrowser();
        emailField("skillztomkid@gmail.com");
        passwordFinder("te$t$tudent");
        logIn();
        searchSongs("dark days");
        viewAll();
        clickFirstSong();
        addToPlaylist();
        newPlaylist("Ope");
        notificationIcon();
        //driver.wait(5000);
    }
}
