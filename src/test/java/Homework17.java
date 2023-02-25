import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework17 extends LoginTests {

    @Test
    public void addSongToPlaylist() {

        LoginValidEmailValidPasswordTest();
        //clickCreatePlaylist();
        //inputPlaylist();
        //enterPress();
        //openHomeURL();
        clickViewAll();
        clickFirstSong();
        clickAddto();
        clickPlaylistfromAddto();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(getSuccessPopup()));
        Assert.assertEquals(getSuccessNotif(),"Added 1 song into test.");
    }

    private void clickViewAll() {
        WebElement viewallButton = driver.findElement(By.cssSelector("button[data-testid='home-view-all-recently-played-btn']"));
        viewallButton.click();
    }

    private void clickFirstSong() {
            WebElement firstSong = driver.findElement(By.cssSelector("#recentlyPlayedWrapper [class='song-item']:nth-child(1)"));
            firstSong.click();
    }

    private void clickAddto() {
        WebElement Addto = driver.findElement(By.cssSelector("button[class='btn-add-to']"));
        Addto.click();
    }

    private void clickPlaylistfromAddto() {
        WebElement playlistAddto = driver.findElement(By.cssSelector("#recentlyPlayedWrapper [class='existing-playlists'] [class='playlist']"));
        playlistAddto.click();
    }

    private String getSuccessNotif(){
        return driver.findElement(By.cssSelector("[class='success hide']")).getText();
    }

    private WebElement getSuccessPopup(){
        return driver.findElement(By.cssSelector("[class='success hide']"));
    }
}
