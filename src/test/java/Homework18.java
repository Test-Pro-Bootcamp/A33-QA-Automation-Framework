import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework18 extends BaseTest {

    @Test
    @Parameters({"email", "password"})
    public void playSong(String email, String password) {

        loginValidAccount(email, password);
        openAllSongs();
        playFirstSong();
        ExpectedConditions.visibilityOf(getPauseButton());
    }
}