import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.SongsPage;
import pages.LoginPage;

import java.time.Duration;

public class Homework18 extends BaseTest {

    @Test
    public void playSong() {

        //GIVEN
        LoginPage loginPage = new LoginPage(getDriver());
        SongsPage songPage = new SongsPage(getDriver());
        loginPage.inputLogIn(email, password);

        //THEN
        songPage.openAllSongs()
                .playFirstSong()

        //WHEN
                .isMixerVisible();
    }
}