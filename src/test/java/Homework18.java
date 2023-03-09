import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest{
    @Test
    public void playSong() {
    navigate("https://bbb.testpro.io/");
    provideEmail("Valentineguts@gmail.com");
    providePassword("te$t$tudent");
    submitLogin();
    playNextSong();

    Assert.assertTrue(isSongPlaying());
    //I manage to play the song only in case if I hover over with my mouse manually on the play button.
    }
}
