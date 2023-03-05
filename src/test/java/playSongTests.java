import org.testng.Assert;
import org.testng.annotations.Test;


public class playSongTests extends BaseTest {
    @Test
    public void playSong() throws InterruptedException {
        // navigateToPage("https://bbb.testpro.io/");
        driver.get(url);
        // Login to the Homepage Koel
        provideEmail("janezelenova@gmail.com");
        providePassword("Floridaliving2023$");
        clickSubmit();
        Thread.sleep(2000);


        enterAllSongs();
        selectSong();
        enterButtonPlaySong();

        Assert.assertTrue(isDisplayedPlayingSong());

    }
}


