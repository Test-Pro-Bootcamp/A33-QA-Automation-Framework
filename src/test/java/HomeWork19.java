import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeWork19  extends BaseTest {

    @Test
    public void deletePlaylist()  throws InterruptedException {
        String deletePlaylistMsg ="Deleted playlist";
        logIn();
        openPlaylist();
        clickDeletePlaylistBtn();
       Assert.assertTrue(getDeletedPlaylistMsg().contains(deletePlaylistMsg));
    }
}


