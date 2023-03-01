package src.test.java;

import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class MusicPlayerTest {

    @Test
    public void playSongTest() {
        // implementation of the test case
        public void playSongTest() {
            MusicPlayer player = new MusicPlayer();
            player.loadPlaylist("myPlaylist");
            player.playNextSong();
            assertTrue(player.isPlaying(), "The song is not playing.");
        }
    }

    @Test
    public void stopSongTest() {
        // implementation of another test case
    }

    @Test
    public void skipSongTest() {
        // implementation of another test case
    }
}