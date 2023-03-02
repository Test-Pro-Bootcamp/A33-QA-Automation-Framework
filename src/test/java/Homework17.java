import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
public class Homework17 extends BaseTest {

    @Test
    public static void addSongToPlaylist() throws InterruptedException {
        String newSongAddNotificationMessage = "Added 1 song into";
        loginUrl();
        enterEmail("catsaremyfavorite@gmail.com");
        enterPassword("te$t$tudent");
        clickSubmit();
        findSong("Take my Hand");
        clickViewAllButton();
        selectFirstSong();
        clickAddToButton();
        selectPlaylist();
      Assert.assertTrue(getNotificationMessage().contains(newSongAddNotificationMessage));
    }
}


