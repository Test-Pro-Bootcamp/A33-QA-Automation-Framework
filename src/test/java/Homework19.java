import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest{

    @Test
    public void deletePlaylist() throws InterruptedException{

        enterEmail("vasilinapelo@gmail.com");
        enterPassword("vasilina230109!");
        clickSubmit();
        selectPlaylist();
        deletePlayList();

        WebElement getDeletedPlaylistMessage = getDeletedPlaylistMessage();
        Assert.assertTrue(getDeletedPlaylistMessage.isDisplayed());


    }

}
