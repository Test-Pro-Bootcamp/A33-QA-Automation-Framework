import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest{
    @Test
    public void addSongToPlaylist() throws InterruptedException {
    String newSongNotification = "Added 1 song into";
    urlAccess();
    getEmail("andalia.nia@gmail.com");
    getPassword("te$t$tudent");
    clickSubmit();
    searchSong("Pluto");
    clickViewAllBtn();
    selectFirstSongResult("Take my Hand");
    clickAddButton();
    choosePlaylist("Favorites");
    Assert.assertTrue(getNotificationText().contains(newSongNotification));
    }


}
