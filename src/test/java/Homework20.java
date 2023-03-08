import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework20 extends BaseTest{
    @Test(enabled = true,description = "test1",priority = 0)
    public void createNewPlaylist() {
        logIn("taqimed99@gmail.com", "Med-20115-010499@");
        clickSubmit();
        createPlaylist();
        Assert.assertTrue(newPlaylistIsDisplayed());
    }
    @Test(enabled = true,description = "test2",priority = 1)
    public void addASongToExistingPlaylist(){
        logIn("taqimed99@gmail.com", "Med-20115-010499@");
        clickSubmit();
        searchASong("take my Hand");
        viewAllButton();
        selectFirstSong();
        clickAddButton();
        clickPlaylistNameFromAddToButton("HW20Playlist");
        Assert.assertTrue(notificationMsgIsDisplayed());
        deleteSongFromPlaylist();
    }
@Test(enabled = true,description = "test3",priority = 2)
public void playSong(){
    logIn("taqimed99@gmail.com", "Med-20115-010499@");
    clickSubmit();
    accessMediaPlayerControls();
    playingSongIsDisplayed();
    Assert.assertTrue(playingSongIsDisplayed());
}
    @Test(enabled = true,description = "test4",priority = 3)
    public void deletePlaylist(){
        logIn("taqimed99@gmail.com", "Med-20115-010499@");
        clickSubmit();
        clickExistingPlaylist();
        deleteExistingPlaylist();
        Assert.assertTrue(getNotificationMessage());
    }


}
