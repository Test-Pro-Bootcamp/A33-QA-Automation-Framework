 import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

    public class Homework18 extends BaseTest {
        @Test(priority = 1, description = "Play a song and validate if song is playing")
        public void playSongTest() throws InterruptedException {
            loginUrl();
            enterEmail("catsaremyfavorite@gmail.com");
            enterPassword("te$t$tudent");
            clickSubmit();
            usePlayerControls();
            Assert.assertTrue(songIsPlaying());
        }
    }

