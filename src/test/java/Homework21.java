import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest{
    String playlistName = "Playlist";
@Test
public void renamePlaylist(){
    logIn("andalia.nia@gmail.com","te$t$tudent");
    choosePlaylist();
    contextClickChoosePlaylist();
    enterPlaylistName(playlistName);
    Assert.assertTrue(doesPlaylistExist(playlistName));

    }
}