import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;
public class Homework20 extends BaseTest {
    @Test
    public void deletePlaylist() throws InterruptedException {
        /*openLoginUrl();*/
        provideEmail("vera1077@gmail.com");
        enterPassword("te$t$tudent");
        clickSubmit();
        selectPlaylist();
        clickDeletePlaylist();
    }
    public void selectPlaylist() {
        WebElement selectPlaylistToDelete = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"playlists\"]/ul/li[3]/a")));
        selectPlaylistToDelete.click();
    }

    public void clickDeletePlaylist() {
        WebElement deleteBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='del btn-delete-playlist']")));
        deleteBtn.click();
        WebElement deleteConfirm = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='ok']")));
        deleteConfirm.click();
    }

    public boolean isDisplayedDeletedPlaylist() {
        WebElement playlistIsDeleted = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='success show']")));
        return playlistIsDeleted.isDisplayed();
    }
}


