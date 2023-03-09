import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest {
    @Test
    public void playSong() throws InterruptedException {
        openLoginURL();
        provideEmail("teststudent@teststudent.com");
        providePW("te$t$tudent");
        clickSubmit();
        clickPlayNextSong();
        clickPlaySong();
        Assert.assertTrue(pauseButtonDisplay());
        Assert.assertTrue(soundBarVisualizerDisplay());
    }
}