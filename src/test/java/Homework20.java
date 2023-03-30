import org.testng.Assert;
import org.testng.annotations.Test;
public class Homework20 extends BaseTest {

    @Test
    public void deletePlaylist()  {
        String deletePlaylistMsg ="Deleted playlist";
        logIn();
        openPlaylist();
        clickDeletePlaylistBtn();
        Assert.assertTrue(getDeletedPlaylistMsg().contains(deletePlaylistMsg));
    }
}
