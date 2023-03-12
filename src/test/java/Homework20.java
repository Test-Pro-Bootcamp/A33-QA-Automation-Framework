import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework20 extends BaseTest {
    @Test
    public void deletePlayList(){

        enterEmail("linulya1411@gmail.com");
        enterPassword("te$t$tudent");
        clickSubmit();
        clickPlaylistToDelete();
        clickXPlaylist();
        Assert.assertTrue(verifyNotification());
    }
}