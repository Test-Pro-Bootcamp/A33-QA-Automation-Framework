import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest{
    String newPlayListName = "New Playlist";
    @Test
    public void renamePlaylist(){
        logIn();
        clickPlayList();
        renamePlayListName();

        Assert.assertTrue(verifyNewPlayListName());
    }
}