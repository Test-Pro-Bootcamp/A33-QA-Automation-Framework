import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeWork20 extends BaseTest {

    @Test
    public void deletePlaylist() throws InterruptedException {
        login("valentineguts@gmail.com", "te$t$tudent");
        playlistClick("Valentino44");
        platlistRemove();
        Assert.assertTrue(getPlaylistRemovalMsg().isDisplayed());


    }
}
