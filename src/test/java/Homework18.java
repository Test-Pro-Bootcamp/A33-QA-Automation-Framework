import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest {
    @Test
    public void playSongTest() throws InterruptedException {
        urlAccess();
        getEmail("andalia.nia@gmail.com");
        getPassword("te$t$tudent");
        clickSubmit();
        playSong();
        Assert.assertTrue(isSongPlaying());


    }
}




