import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.time.Duration;

public class Homework17 extends BaseTest {

    @Test
    public void addSongToPlaylist() {

        String testPlaylist = "test";
        logIn();
        clickViewAll();
        clickFirstSong();
        clickAddto();
        clickPlaylistfromAddto(testPlaylist);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(getSuccessPopup()));
        //System.out.println(getSuccessNotif());
        Assert.assertEquals(getSuccessNotif(), "Added 1 song into \"" + testPlaylist + ".\"");
        //Clean up and delete the first song from test playlist... so I can run this again
        deleteAddedSongPlaylist(testPlaylist);
    }
}
