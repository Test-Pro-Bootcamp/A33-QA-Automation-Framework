import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework18 extends BaseTest {
//
    @Test
    public void playSong()throws InterruptedException {
        openBrowser();
        enterEmail();
        enterPassword();
        submit();
        clickNext();
        clickPlay();
        Assert.assertTrue(isSongPlaying());
    }
}