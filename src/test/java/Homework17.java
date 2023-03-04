import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest{
    @Test(enabled = true)
    public void addSongToPlaylist() throws InterruptedException {
        String newSongAddedNotification = "Added 1 song into";
        NavigateUrl();
        provideEmail("taqimed99@gmail.com");
        providePassword("Med-20115-010499@");
        clickSubmit();
        searchSong("Take my Hand");
        viewAllSearchResult();
        selectFirstSongResult();
        clickAddToButton();
        choosePlaylist("Test");
        //Assert.assertTrue(getNotificationText().contains(newSongAddedNotification));


    }

}