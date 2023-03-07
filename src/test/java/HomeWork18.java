import org.testng.Assert;
import org.testng.annotations.Test;

  public class HomeWork18 extends BaseTest {

    @Test
    public void playSongTest() throws InterruptedException {
        openLoginUrl();
        provideEmail("agask0901@gmail.com");
        providePassword("Student2023#");
        clickSubmit();
        clickPlayButton();
        Assert.assertTrue(theSongIsPlaying());
        Thread.sleep(2000);
    }
}
