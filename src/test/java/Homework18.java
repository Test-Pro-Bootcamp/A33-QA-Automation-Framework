import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest {

    @Test
    public void playSong() throws InterruptedException {
        urlAccess();
        getEmail("taqimed99@gmail.com");
        getPassword("Med-20115-010499@");
        loginUser();
        clickPlayNextSong();
        Assert.assertTrue(songPlayIsDisplayed());
        Thread.sleep(2000);
    }
}