import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Homework17 extends BaseTest {
@Test
    public void addSongToPlaylist()  {

    String notification = "Added 1 song into";
   // openBrowser();
    enterEmail();
    enterPassword();
    submit();
    searchForSong();
    clickViewAll();
    clickFirstSong();
    clickAddTo();
    choosePlaylist();
    Assert.assertTrue(getNotification().contains(notification));


}

}