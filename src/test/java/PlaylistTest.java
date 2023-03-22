
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.testng.Assert;
import com.beust.jcommander.Parameter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import pages.AllSongsPage;
import pages.HomePage;
import pages.LoginPage;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class PlaylistTest extends BaseTest {
    @Test
    public void createPlaylistAddSong() throws MalformedURLException, InterruptedException {
        //GIVEN
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        AllSongsPage allSongPage = new AllSongsPage(getDriver());
        //WHEN
        loginPage.loginPageTest();
        Thread.sleep(2000);
        homePage.createPlaylist();
        //THEN
        Assert.assertTrue(homePage.playlistCreatedMsg());
    }
    @Test
    public void deletePlaylistTest() throws InterruptedException {
        //GIVEN
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        AllSongsPage allSongPage = new AllSongsPage(getDriver());
        //WHEN
        loginPage.loginPageTest();
        Thread.sleep(2000);
        homePage.deletePlaylist();
        //THEN
        Assert.assertTrue(homePage.confirmNotification());
    }
}
