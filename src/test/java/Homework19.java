import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest {

    @Test
    public void deleteCreatedPlaylist() throws InterruptedException {
        login();
        clickSubmit();
        selectEmptyPlaylist();
        deletePlaylist();
        getDeletePlaylistMessage();
        Assert.assertTrue(getDeletePlaylistMessage());
    }

}