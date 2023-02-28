import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.time.Duration;

public class Homework17 extends LoginTests {

    @Test
    public void addSongToPlaylist() {

        String playlistname = "test";
        loginValidAccount("Test321@gmail.com", "te$t$tudent");
        clickViewAll();
        clickFirstSong();
        clickAddto();
        clickPlaylistfromAddto(playlistname);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(getSuccessPopup()));
        System.out.println(getSuccessNotif());
        Assert.assertEquals(getSuccessNotif(), "Added 1 song into \"" + playlistname + ".\"");
        //Clean up and delete the first song from test playlist... so I can run this again
        deleteAddedSongPlaylist(playlistname);
    }
}
