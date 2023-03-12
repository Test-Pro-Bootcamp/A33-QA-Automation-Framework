import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework20 extends BaseTest {
    @Test
    public void deletePlayList(){
        logIn();
        clickPlaylistToDelete();
        clickXPlaylist();
        Assert.assertTrue(verifyNotification());
    }

}