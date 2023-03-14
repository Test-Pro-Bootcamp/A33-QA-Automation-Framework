import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework20 extends BaseTest {

    @Test
    public static void createNewPlaylistTest() {

        logIn("andalia.nia@gmail.com", "te$t$tudent");
        clickSubmit();
        createNewPlaylist();
        Assert.assertTrue(newPlaylistDisplayed());
    }
    @Test
    public static void addASongToPlaylist(){
        logIn("andalia.nia@gmail.com","te$t$tudent");
        clickSubmit();
        searchSong("Pluto");
        clickViewAllButton();
        selectFirstSong();
        clickAddToButton();
        Assert.assertTrue(newPlaylistDisplayed());
    }
}
