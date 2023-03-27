import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;
public class Homework21 extends BaseTest {
@Test

    //GIVEN
    public void loginToAccount() {
        provideEmail("vera1077@gmail.com");
        enterPassword("te$t$tudent");
        clickSubmit();
        selectPlaylist();
        renamePlaylist();
        Assert.assertTrue(isPlaylistRenamed());
    }

    //WHEN
    public void selectPlaylist() {
        Actions action = new Actions(driver);
        WebElement selectPlaylistToRename = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"playlists\"]/ul/li[3]/a")));
        action.contextClick(selectPlaylistToRename).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"playlists\"]/ul/li[3]/nav/ul/li[1]"))).click();
    }

    public void renamePlaylist() {
        Actions action = new Actions(driver);
        WebElement playlistInputField = driver.findElement(By.xpath("//input[@name='name']"));
        playlistInputField.sendKeys(Keys.chord(Keys.COMMAND,"a", Keys.DELETE));
        playlistInputField.sendKeys("Renamed Playlist");
        playlistInputField.sendKeys(Keys.ENTER);
    }

    //THEN
    public boolean isPlaylistRenamed() {
        WebElement playlistRename = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='success show']")));
        return playlistRename.isDisplayed();
    }
}
