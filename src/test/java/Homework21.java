import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest{
    @Test
    public void renamePlaylist(){
        logIn();
        clickPlayList();
        chooseEdit();
        renamePlayListName();

        Assert.assertTrue(verifyNewPlayListName());
    }
}