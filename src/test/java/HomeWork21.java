import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeWork21 extends BaseTest {



    @Test
    public static void renamePlaylist() {
        login("valentineguts@gmail.com", "te$t$tudent");
        rightClickOnPlaylist("lambo");

        putPlaylistName("Ferrari");

        Assert.assertTrue(ifNewPlaylistExists());
















    }
}
