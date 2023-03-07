import com.fasterxml.jackson.databind.ser.Serializers;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Domashka17 extends BaseTest {


    @Test
    public static void addSongToThePlaylist() {
        BaseTest B = new BaseTest();
        B.setupBrowser();
        B.navigation("https://bbb.testpro.io/");
        B.enterEmail("valentineguts@gmail.com");
        B.enterPassword("te$t$tudent");
        B.submit();
        B.search("hozlinaCC0");
       // B.sleep();
        B.clickViewALl();
        B.clickFirstSong();
        B.AddTo();
        B.addToPlaylist();
        Assert.assertTrue(B.verifyNotification().contains("Added 1 song into"));















    }



}
