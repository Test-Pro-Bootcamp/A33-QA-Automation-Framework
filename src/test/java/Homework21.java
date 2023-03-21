import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest {

    @Test
    public void renamePlaylistMethod () {
        urlAccess();
        getEmail("ponypony123@gmail.com");
        getPassword("Testtesttest123123$$");
        loginUser();
        renamePlaylist();
        Assert.assertTrue(playlistDoesExist());
    }
}
