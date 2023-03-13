import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.RecentlyPage;


import java.time.Duration;

public class Homework17 extends BaseTest {

    @Test
    public void addSongToPlaylist() {

        //GIVEN
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        RecentlyPage recentlyPage = new RecentlyPage(driver);
        String currentPlaylistname = "PLDELTEST";
        loginPage.inputLogIn(email, password);
        homePage.createPlaylist(currentPlaylistname);
        homePage.findPlaylist(currentPlaylistname);
        homePage.openHome();

        //THEN
        recentlyPage.clickViewAll();
        recentlyPage.clickFirstSong();
        recentlyPage.addToBtn();
        recentlyPage.clickPlaylistfromAddto(currentPlaylistname);

        //WHEN
        Assert.assertTrue(homePage.getNotification().isDisplayed());
        homePage.openPlaylist();
        homePage.deleteFilledPlaylist();

        //String testPlaylist = "test";
        //logIn();
        //clickViewAll();
        //clickFirstSong();
        //clickAddto();
        //clickPlaylistfromAddto(testPlaylist);
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //wait.until(ExpectedConditions.visibilityOf(getSuccessPopup()));
        //Assert.assertEquals(getSuccessNotif(), "Added 1 song into \"" + testPlaylist + ".\"");
        //deleteAddedSongPlaylist(testPlaylist);
    }
}
