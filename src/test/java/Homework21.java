import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest {

    @Test
    public void renamePlaylistTest() {

        //GIVEN
        String currentPlaylistname = "PLDELTEST";
        String newPlaylistname = "PLRNTEST";
        logIn();
        createPlaylist(currentPlaylistname);

        //THEN
        doubleClickPlaylist(currentPlaylistname);
        enterPlaylistName(newPlaylistname);

        //WHEN
        Assert.assertTrue(isPlaylistvisible(newPlaylistname));
    }
}