import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest {

    @Test
    public void addSongToPlaylist() throws InterruptedException {
        String addedSongNotification = "Added 1 song into";
        urlAccess();
        getEmail("ponypony123@gmail.com");
        getPassword("Testtesttest123123$$");
        loginUser();
        searchSong("Reactor");
        searchResult();
        selectFirstSong();
        clickAddButton();
        selectPlaylist();
        Assert.assertTrue(getNotificationMessage().contains(addedSongNotification));
        Assert.assertTrue(notificationDisplayed());
        Thread.sleep(2000);
    }
}
