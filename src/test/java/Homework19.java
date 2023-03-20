import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
public class Homework19 extends BaseTest {
    @Test
    @Parameters({"Playlist"})
    public void deletePlaylist(String Playlist) throws InterruptedException {
        login("teststudent@teststudent.com", "te$t$tudent");
        String msgText = "Deleted playlist \"" + Playlist + ".\"";
        selectPlaylist(Playlist);
        System.out.println("Message should be: " + msgText);
        String msgReturn = deleteSelectedPlaylist(Playlist);
        Assert.assertTrue(msgReturn.contains(msgText));
    }
}