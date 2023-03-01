import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class AddSongToPlayListTest extends BaseTest{

    @Test
    public static void addSongToPlayListTest() throws InterruptedException {

        openLoginUrl();
        provideEmail("nelena35@yahoo.com");
        providePassword("te$t$tudent");
        clickSubmit();
        searchSong("Lost in Space");
        clickViewAllButton();
        selectFirstSong();
        clickAddToButton();
        clickPlaylistNameFromAddTo("Sleepy Songs");
        String addedSongNotification = "Added 1 song into Sleepy Songs";

        deleteSongFromPlaylist();

        Assert.assertTrue(getNotificationPopup());
        Thread.sleep(2000);


    }



}
