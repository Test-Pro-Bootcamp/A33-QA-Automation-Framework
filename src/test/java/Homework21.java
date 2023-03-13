import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest{
    @Test
    public void renamePlaylist() {
        logIn();
        doubleClickPlaylist();
        enterNewPlaylistName();
        Assert.assertTrue(checkNewPlaylist());

    }

}
