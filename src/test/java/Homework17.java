import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework17 extends BaseTest {

    @Test
    public void addSongToPlaylist() throws InterruptedException{

        String newSongAddedNotification = "Added one song into";

        openloginUrl();
        enterEmail("vasilinapelo@gmail.com");
        enterPassword("vasilina230109!");
        clickSubmit();
        searchForSong("Dark Days");
        clickViewAll();
        selectFirstSong();
        clickAddTo();
        choosePlaylist();
        Assert.assertTrue(getNotificationMessage().contains(newSongAddedNotification));


    }

}
