import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest {

    @Test
    public void newSongToPlaylist() throws InterruptedException {
        //setUpBrowser();
        //String url = "https://bbb.testpro.io/";
        //driver.get(url);
        emailField("skillztomkid@gmail.com");
        passwordFinder("te$t$tudent");
        logIn();
        soundBar();
        hoverOnPlay();
        play();
        //pause();
        Assert.assertTrue(verifySoundBar());

        //driver.wait(5000);
    }
}