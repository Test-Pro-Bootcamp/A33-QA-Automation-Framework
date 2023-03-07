import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeWork19 extends BaseTest {

    @Test
    public static void deletePlaylistTest() throws InterruptedException {
        openLoginUrl();
        provideEmail("agask0901@gmail.com");
        providePassword("Student2023#");
        clickSubmit();
        SearchLine("Tunnel of lights");
        clickViewAll();
        firstSongResults();
        clickAddToButton();
        createNewPlaylist();
        clickSubmitNewPlaylistButton();
        getNotification();
        deletePlaylist();
        clickToDeletePlaylistButton();
        deletePlaylistPopsUpWindow();
        clickDeleteOkButton();
        notificationMessageDeletePlaylist();

        Assert.assertTrue(notificationMessageDeletePlaylist());
        Thread.sleep(2000);
    }
}
