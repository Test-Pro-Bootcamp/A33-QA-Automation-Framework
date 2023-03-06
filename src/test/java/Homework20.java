import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework20 extends BaseTest{
    @Test(enabled = true,priority = 0, description = "Validate can create a new playlist")
    public static void createNewPlaylistTest(){
        login("nelena35@yahoo.com", "te$t$tudent");
        clickSubmit();
        createNewPlaylist();
        Assert.assertTrue(newPlaylistIsDisplayed());
    }

    @Test(enabled = true, priority = 1, description = "Validate a song is added to an existing playlist")
    public static void addASongToExistingPlaylistTest() {
        login("nelena35@yahoo.com", "te$t$tudent");
        clickSubmit();
        searchASong("Lost In Space");
        clickViewAllButton();
        selectFirstSong();
        clickAddToButton();
        clickPlaylistNameFromAddToButton("Sleepy Songs");
        Assert.assertTrue(notificationMessageIsDisplayed());
        deleteSongFromPlaylist();
    }
    @Test(enabled = true, priority = 2, description = "Validate the song is playing")
    public static void playSongTest(){
        login("nelena35@yahoo.com", "te$t$tudent");
        clickSubmit();
        accessMediaPlayerControls();
        playingSongIsDisplayed();
        Assert.assertTrue(playingSongIsDisplayed());
    }
    @Test(enabled = true, priority = 3, description = "Validate the existing playlist is deleted")
    public static void deletePlaylistTest(){
        login("nelena35@yahoo.com", "te$t$tudent");
        clickSubmit();
        clickExistingPlaylist();
        deleteExistingPlaylist();
        Assert.assertTrue(getNotificationMessage());
    }
}
