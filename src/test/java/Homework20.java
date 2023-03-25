import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.time.Duration;
public class Homework20 extends BaseTest {
    @Test (enabled = true, priority = 0, description = "Validate Registration Navigation")
    public void registrationNav() {
        registrationNavigation();
        String RegistrationPgUrl = "https://bbb.testpro.io/registration.php";
        Assert.assertNotEquals(driver.getCurrentUrl(), url);
        Assert.assertEquals(driver.getCurrentUrl(), RegistrationPgUrl);
    }
        @Test (enabled = true, priority = 0, description = "Validate Login works")
        public void login(){
            provideEmail("teststudent@teststudent.com");
            providePW("te$t$tudent");
            clickSubmit();
        }
    @Test(enabled = true, priority = 1, description = "Validate new playlist is created")
    @Parameters({"Playlist"})
    public void createNewPlaylist(String Playlist) {
        login("teststudent@teststudent.com", "te$t$tudent");
        String notificationText = "Created playlist \"" + Playlist + ".\"";
        createNewSimplePlaylist(Playlist);
        Assert.assertTrue(newPlaylistNotification().contains(notificationText));
        newPlaylistIsDisplayed();
    }
    @Test(enabled = true, priority = 2, description = "Validate song is added to playlist")
    @Parameters({"Playlist"})
    public void addSongToPlaylist(String Playlist) {
        String notificationText = "Added 1 song into \"" + Playlist + ".\"";
        login("teststudent@teststudent.com", "te$t$tudent");
        searchSong ("Metre");
        clickViewAllButton ();
        clickFirstSong ();
        clickAddToButton ();
        clickPlaylist (Playlist);
        Assert.assertTrue(getNotification().contains(notificationText));
    }
    @Test (enabled = true, priority = 2, description = "Validate a song is playing")
    public void playSong() {
        login("teststudent@teststudent.com", "te$t$tudent");
        clickPlayNextSong();
        clickPlaySong();
        Assert.assertTrue(pauseButtonDisplay());
        Assert.assertTrue(soundBarVisualizerDisplay());
        Assert.assertTrue(progressBarDisplay());
    }
    @Test(enabled = true, priority = 3, description = "Validate song is deleted from playlist ")
    @Parameters({"Playlist"})
    public void deleteSong(String Playlist) {
        login("teststudent@teststudent.com", "te$t$tudent");
        String msgText1 = "Removed 1 song from \"" + Playlist + ".\"";
        selectPlaylist (Playlist);
       deleteSongFromPlaylist();
        System.out.println("Message should be: " + msgText1);
        String msgReturn = delSongNotificationMsg();
        Assert.assertTrue(msgReturn.contains(msgText1));
    }
    @Test(enabled = true, priority = 4, description = "Validate existing/specified & empty playlist is deleted")
        @Parameters({"Playlist"})
        public void deletePlaylist(String Playlist) {
            login("teststudent@teststudent.com", "te$t$tudent");
            String msgText = "Deleted playlist \"" + Playlist + ".\"";
            selectPlaylist(Playlist);
            System.out.println("Message should be: " + msgText);
            deleteSelectedPlaylist(Playlist);
            String msgReturn = getNotificationMsg();
            Assert.assertTrue(msgReturn.contains(msgText));
        }
    }