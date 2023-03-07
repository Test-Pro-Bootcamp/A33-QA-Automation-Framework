import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest{

    @Test
    public void playSongTest() {

        enterEmail("vasilinapelo@gmail.com");
        enterPassword("vasilina230109!");
        clickSubmit();
        playSong();
        Assert.assertTrue(soundBarIsDisplayed());

    }

}
