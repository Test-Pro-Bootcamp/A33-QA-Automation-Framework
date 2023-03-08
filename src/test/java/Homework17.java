import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework17 extends BaseTest {

   @Test
    public void addSongToPlaylist() throws InterruptedException {

        openLoginURL();
        provideEmail ("jguy1@stny.rr.com");
        providePassword ("te$t$tudent");
        clickSubmit();
        searchSong("Lament");




        Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.quit();
    }

    private void searchSong(String lament) {
    }
}

