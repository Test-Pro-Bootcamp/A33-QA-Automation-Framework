import org.testng.annotations.Test;
import org.testng.Assert;

public class Homework18 extends BaseTest {
    @Test
    public void playSongTest()  {
        logIn();
        playSong();
        Assert.assertTrue(isSongPlaying());
    }

}
