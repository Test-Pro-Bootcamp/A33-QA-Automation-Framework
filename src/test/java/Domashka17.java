import com.fasterxml.jackson.databind.ser.Serializers;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Domashka17 extends BaseTest {


    @Test
    public void addSongToThePlaylist() {

        setupBrowser();
        navigation("https://bbb.testpro.io/");
        enterEmail("valentineguts@gmail.com");
        enterPassword("te$t$tudent");
        submit();
        search("hozlinaCC0");
       // B.sleep();
        clickViewALl();
        clickFirstSong();
        AddTo();
        addToPlaylist();
        Assert.assertTrue(verifyNotification().contains("Added 1 song into"));















    }



}
