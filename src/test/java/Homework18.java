import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.interactions.Actions;
import java.time.Duration;
import java.time.Duration;

public class Homework18 extends BaseTest  {
//
    @Test
    public void playSong() {
        openBrowser();
        enterEmail();
        enterPassword();
        submit();
        clickNext();
        clickPlay();
        Assert.assertTrue(isSongPlaying());
    }
}
