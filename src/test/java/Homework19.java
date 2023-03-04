import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest{

    @Test
    public static void deletePlaylistTest() throws InterruptedException {

          login();
          clickExistingPlaylist();
          deleteExistingPlaylist();

          Assert.assertTrue(getNotificationMessage());
          Thread.sleep(2000);


    }

}
