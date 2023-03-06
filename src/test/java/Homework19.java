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

        //GIVEN
        String testPlaylist = "PLDELTEST";
        logIn();
        createPlaylist(testPlaylist);

        //THEN
        openPlaylist(testPlaylist);
        deleteEmptyPlaylist();

        //WHEN
        Assert.assertTrue(getDeletedPlaylistmsg().isDisplayed());
    }
}