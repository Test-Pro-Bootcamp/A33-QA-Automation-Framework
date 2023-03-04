import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest {

    @Test
    public void deletePlaylistTest() {
        String testPlaylist = "PLDELTEST";
        logIn();
        try {
            WebElement exists = driver.findElement(By.xpath("//*[@id='playlists']  //li[@class='playlist playlist']  //a[contains(text(),'" + testPlaylist + "')]"));
            openPlaylist(testPlaylist);
        }
        catch (NoSuchElementException e) {
            createPlaylist(testPlaylist);
        }
        finally {
            deletePlaylistButton();
            Assert.assertTrue(getDeletedPlaylistmsg().isDisplayed());
        }
    }
}