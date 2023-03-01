import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest {
    @Test
    public void addSongToPlaylist() throws InterruptedException {
    String newSongAddedNotification = "Added 1 song into.";

    openLoginUrl();
    provideEmail("regniermandy@gmail.com");
    providePassword("te$t$tudent");
    clickSubmit();
    searchSong("Pluto");
    viewAllSearchResults();
    selectFirstSongResult();
    clickAddToButton();
    choosePlaylist("Favorites");

    //Assert.assertTrue(getNotificationText().contains(newSongAddedNotification));

    exitBrowser();
 }

}
