import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.time.Duration;

public class HomeWork19 extends BaseTest {
    @Test
    public void deletePlaylist() throws InterruptedException {
        /*openLoginUrl();*/
        provideEmail("vera1077@gmail.com");
        enterPassword("te$t$tudent");
        clickSubmit();
        selectPlaylist();
        clickDeletePlaylist();
    }
    public void selectPlaylist() throws InterruptedException {
        WebElement selectPlaylistToDelete = driver.findElement(By.xpath("//*[@id=\"playlists\"]/ul/li[3]/a"));
        Thread.sleep(2000);
        selectPlaylistToDelete.click();
    }

    public void clickDeletePlaylist() throws InterruptedException{
        WebElement deleteBtn = driver.findElement(By.xpath("//button[@class='del btn-delete-playlist']"));
        deleteBtn.click();
        Thread.sleep(2000);
        WebElement deleteConfirm = driver.findElement(By.xpath("//button[@class='ok']"));
        deleteConfirm.click();
    }

    public boolean isDisplayedDeletedPlaylist() {
        WebElement playlistIsDeleted = driver.findElement(By.cssSelector("[class='success show']"));
        return playlistIsDeleted.isDisplayed();
    }
}
