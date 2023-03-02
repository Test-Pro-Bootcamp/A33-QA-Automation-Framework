import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest{

    @Test(priority = 1, description = "Play a song and validate if the song is playing")

    public static void playSongTest() throws InterruptedException {
      openLoginUrl();
      provideEmail("nelena35@yahoo.com");
      providePassword("te$t$tudent");
      clickSubmit();
      accessMediaPlayerControls();

      Assert.assertTrue(playingSongIsDisplayed());
      Thread.sleep(2000);
    }


}
