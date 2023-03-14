import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeWork19 extends BaseTest
{
    @Test
    public void deletePlaylist() throws InterruptedException {
        login("valentineguts@gmail.com", "te$t$tudent");
        playlistClick("lambo");
        platlistRemove();
       Assert.assertTrue(getPlaylistRemovalMsg().isDisplayed());









    }






}
