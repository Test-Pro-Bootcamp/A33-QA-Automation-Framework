import org.testng.Assert;
import org.testng.annotations.Test;
public class RAHomework17 extends BaseTest {
    @Test
    public void addSongToPlaylist() throws InterruptedException {
        String notificationText = "Added 1 song into";
        openLoginURL();
        provideEmail("ruth.asghar@testpro.io");
        providePW("te$t$tudent");
        clickSubmit();
        searchSong("Take my Hand");
        clickViewAllButton();
        clickFirstSong();
        clickAddToButton();
        clickPlaylist();
        Assert.assertTrue(getNotification().contains(notificationText));
    }
}
