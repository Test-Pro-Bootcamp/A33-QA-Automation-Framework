import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework20 extends BaseTest {

    @Test(enabled = true, priority = 0, description = "Validate can create a new playlist")
    public static void createNewPlaylist(){

        logIn("andalia.nia@gmail.com", "te$t$tudent");
        clickSubmit();
        createNewPlaylist();
        Assert.assertTrue(newPlaylistIsDisplayed());
    }
    @Test
    public static void addASongToPlaylist(){
        logIn("andalia.nia@gmail.com","te$t$tudent");
        clickSubmit();
        searchSong("Pluto");
        clickViewAllButton();
        selectFirstSong();
        clickAddToButton();
        Assert.assertTrue(newPlaylistIsDisplayed());
    }
}
