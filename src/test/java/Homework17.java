import org.testng.Assert;
import org.testng.annotations.Test;
public class Homework17 extends BaseTest {
    @Test
    public void addSongToPlaylist() throws InterruptedException {
        String notificationText = "Added 1 song into";
        openLoginURL();
        provideEmail("teststudent@teststudent.com");
        providePW("te$t$tudent");
        clickSubmit();
        searchSong("Metre");
        clickViewAllButton();
        clickFirstSong();
        clickAddToButton();
        clickPlaylist();
        Assert.assertTrue(getNotification().contains(notificationText));
    }
}