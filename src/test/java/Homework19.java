import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest {
    @Test
    public void deleteCreatedPlaylist() throws InterruptedException {
        enterEmail("catsaremyfavorite@gmail.com");
        enterPassword("te$t$tudent");
        clickSubmit();
        selectEmptyPlaylist();
        deletePlaylist();
        getDeletePlaylistMessage();
        Assert.assertTrue(getDeletePlaylistMessage());
    }
}