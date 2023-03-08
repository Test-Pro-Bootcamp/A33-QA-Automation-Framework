import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest {

    @Test
    public void deletePlaylist() {
        getEmail("ponypony123@gmail.com");
        getPassword("Testtesttest123123$$");
        loginUser();
        openPlayLis();
        deletePlayList();
        WebElement deletePlaylistMsg = getDeletedMessage();
        Assert.assertTrue(deletePlaylistMsg.isDisplayed());
    }
}
