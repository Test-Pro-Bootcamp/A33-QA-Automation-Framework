import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest{

    @Test
    public void DeletePlayListTest() throws InterruptedException {
        logIn("andalia.nia@gmail.com", "te$t$tudent");
        openPlaylist();
        deletedPlaylist();

        WebElement deletedPlaylistMsg = getDeletedPlaylistMsg();
        Assert.assertTrue(deletedPlaylistMsg.isDisplayed());

    }


}
