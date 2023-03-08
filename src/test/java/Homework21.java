import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest {

    @Test(enabled = true, priority = 1, description = "Validate a playlist is renamed")
    public void renamePlaylistTest(){
        login("nelena35@yahoo.com", "te$t$tudent");
        contextClickExistingPlaylist("Sleepy Songs");
        chooseEdit();
        renamePlaylistName("Active Songs");
        Assert.assertTrue(displayUpdatedPlaylist("Active Songs"));
    }


}
