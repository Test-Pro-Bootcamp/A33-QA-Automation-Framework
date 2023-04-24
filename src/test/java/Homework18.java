import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest {
    @Test
    public void playSongTest () {
        logIn("sinushkinaolesia@gmail.com", "te$t$tudent");
        playSong();
        Assert.assertTrue(isSongPlaying());
    }
        public boolean isSongPlaying() {
            WebElement songBar = driver.findElement(By.cssSelector("[data-testid = 'sound-bar-play']"));
            return songBar.isDisplayed();
    }
}
