import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework20 extends BaseTest {
    @Test(dataProvider = "loginData")
    public void deletePlayList(String email, String password){

        enterEmail(email);
        enterPassword(password);
        clickSubmit();
        clickPlaylistToDelete();
        clickXPlaylist();
        Assert.assertTrue(verifyNotification());
    }
}