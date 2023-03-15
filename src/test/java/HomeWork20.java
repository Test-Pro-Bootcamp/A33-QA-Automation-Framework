import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeWork20 extends BaseTest {

    @Test
    public void loginTest() throws InterruptedException {
        setUpBrowser();
        provideEmail("agask0901@gmail.com");
        providePassword("Student2023#");
        clickSubmitButton();
        SearchLine("Tunnel of lights");
        clickViewAll();
        firstSongResults();
        clickAddToButton();
        createNewPlaylist();
        clickSubmitNewPlaylistButton();
        getNotification();
        deletePlaylist();
        clickToDeletePlaylistButton();
        deletePlaylistPopsUpWindow();
        clickDeleteOkButton();
        notificationMessageDeletePlaylist();

        Assert.assertTrue(notificationMessageDeletePlaylist());
        Thread.sleep(2000);

    }
}
