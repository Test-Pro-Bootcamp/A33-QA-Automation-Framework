import org.bouncycastle.asn1.dvcs.DVCSObjectIdentifiers;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class Homework17 extends BaseTest {


    @Test
    public void addSongToPlaylists() throws InterruptedException {
        setUpDriver();
        getUrl();
        login("maryna0030910@gmail.com", "te$t$tudent");
        searchSong("Dark Days");
        viewAll();
        selectSong();
        clickAddButton();
        selectPlaylist();
        getNotification();
        verifyNotification();
        quitDriver();
    }
}
