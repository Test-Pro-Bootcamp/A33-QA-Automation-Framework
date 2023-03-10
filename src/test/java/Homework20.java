import org.testng.Assert;
import org.testng.annotations.*;

public class Homework20 extends BaseTest {
    @Test
    public void seleniumWaitsHomework() {
    logIn();
    playSong();
    Assert.assertTrue(isSongPlaying());
    }
}
