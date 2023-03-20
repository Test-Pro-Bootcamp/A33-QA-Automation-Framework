import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest {
    @Test
    public void renamePlaylist() {
        logIn("taqimed99@gmail.com", "Med-20115-010499@");
        doubleClick();
        enterPlaylistName();
        Assert.assertTrue(doesPlaylistExist());
    }
}
