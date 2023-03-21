import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
public class Homework18 extends BaseTest {
    @Test
    public void playASong() throws InterruptedException {
        openLoginUrl();
        provideEmail("vera1077@gmail.com");
        enterPassword("te$t$tudent");
        clickSubmit();
        playNextSong();
        playSong();
        Assert.assertTrue(isDisplayedPlayingSong());
    }
}
