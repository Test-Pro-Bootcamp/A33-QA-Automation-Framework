import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest {

    @Test
    public void playSong() throws InterruptedException {
        urlAccess();
        getEmail("ponypony123@gmail.com");
        getPassword("Testtesttest123123$$");
        loginUser();
        clickPlayNextSong();
        Assert.assertTrue(songPlayIsDisplayed());
        Thread.sleep(3000);
    }
}