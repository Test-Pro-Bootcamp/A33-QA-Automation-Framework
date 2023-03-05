import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

    public class Homework20 extends BaseTest {
        @Test(priority = 1, description = "Play a song and validate if song is playing")
        public void addSongToPlaylist() throws InterruptedException {
            String newSongAddNotificationMessage = "Added 1 song into";
            provideEmail("catsaremyfavorite@gmail.com");
            providePassword("te$t$tudent");
            submit();
            findSong("Take my Hand");
            clickViewAllButton();
            selectFirstSong();
            clickAddToButton();
            selectPlaylist();
            Assert.assertTrue(getNotificationMessage().contains(newSongAddNotificationMessage));
        }
        @Test(priority = 2, description = "Play a song and validate if song is playing")
        public void playSongTest() throws InterruptedException {
            provideEmail("catsaremyfavorite@gmail.com");
            providePassword("te$t$tudent");
            submit();
            usePlayerControls();
            Assert.assertTrue(songIsPlaying());
        }
        @Test(priority = 3, description = "Delete an empty playlist")
        public void deleteCreatedPlaylist() throws InterruptedException {
            provideEmail("catsaremyfavorite@gmail.com");
            providePassword("te$t$tudent");
            submit();
            selectEmptyPlaylist();
            deletePlaylist();
            getDeletePlaylistMessage();
            Assert.assertTrue(getDeletePlaylistMessage());
        }
    }

