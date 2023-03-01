package src.test.java;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MyTest {

    @Test
    public void testAddSongToPlaylist() {
        // Navigate to the website and log in
        navigateToWebsite();
        logIn();

        // Search for a song and add it to a playlist
        String songName = "Bohemian Rhapsody"; // Choose any song of your choice
        searchForSong(songName);
        clickViewAll();
        clickFirstSong();
        String playlistName = createPlaylist();
        addSongToPlaylist(playlistName);

        // Verify that the notification message appears
        String expectedMessage = "Added 1 song into " + playlistName;
        assertTrue(checkNotificationMessage(expectedMessage), "Notification message doesn't match expected value.");
    }

}
