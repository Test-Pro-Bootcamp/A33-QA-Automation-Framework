import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;


public class PlaySongTests extends BaseTest {
    @Test
    public void playSong()
    //throws InterruptedException
    {
        // GIVEN user is on the login page ("https://bbb.testpro.io/");
        driver.get(url);
        // AND user puts the correct login and password info
        provideEmail("janezelenova@gmail.com");
        providePassword("Floridaliving2023$");

        //AND user clicks a submit button

        clickSubmit();


        // Thread.sleep(2000);
        //AND user enters AllSongs page

        enterAllSongs();

        //AND user selects and plays a song
        selectSong();
        enterButtonPlaySong();

//THEN the play element is displayed
        Assert.assertTrue(isDisplayedPlayingSong());

    }
}


