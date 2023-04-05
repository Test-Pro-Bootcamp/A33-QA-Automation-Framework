import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import org.openqa.selenium.chromium.ChromiumDriver;














public class homework17 extends BaseTest {
    @Test
public static void addSongToPlaylist() throws InterruptedException {

String newSongAddNotificationMessage = "Added 1 song into";

loginUrl();

enterEmail("codnerlife@gmail.com");

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
