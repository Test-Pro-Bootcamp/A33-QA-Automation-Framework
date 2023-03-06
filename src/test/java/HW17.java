import org.testng.Assert;
import org.testng.annotations.Test;

public class HW17 extends BaseTest {
    @Test
    public void addSongToPlaylist() throws InterruptedException {

        openLoginUrl();
        enterEmail("agask0901@gmail.com");
        enterPassword("Student2023#");
        clickLoginButton();
        SearchLine("Tunnel of lights");
        clickViewAll();
        firstSongResults();
        clickAddToButton();
        createNewPlaylist();
        clickSubmitNewPlaylistButton();
        getNotification();

        Assert.assertTrue(getNotification());
        Thread.sleep(2000);
    }
}