import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.*;
import java.time.Duration;
import org.testng.Assert;

public class Homework19 extends BaseTest {
    @Test
    public void deleteEmptyPlaylist() throws InterruptedException {

        logIn("regniermandy@gmail.com", "te$t$tudent");
        openPlaylist();
        deletePlaylist();

        WebElement deletedPlaylistMessage = getDeletedPlaylistMessage();
        Assert.assertTrue(deletedPlaylistMessage.isDisplayed());

    }
}
