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
    public void addSongToPlaylist() throws InterruptedException {

        //GIVEN
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        RecentlyPage recentlyPage = new RecentlyPage(getDriver());
        String currentPlaylistname = "PLDELTEST";
        loginPage.inputLogIn(email, password);
        homePage.createPlaylist(currentPlaylistname)
                .findPlaylist(currentPlaylistname)
                .openHome();

        //THEN
//        recentlyPage.clickViewAll()
//                    .clickFirstSong()
//                    .addToBtn()
//                    .clickPlaylistfromAddto(currentPlaylistname);
        recentlyPage.openRecently()
                .songContextMenu()
                        .addtoContextMenu()
                                .addtoPlaylistMenu(currentPlaylistname);

        //WHEN
        Assert.assertTrue(homePage.getNotification().isDisplayed());
        System.out.print("Above worked");
        homePage.findPlaylist(currentPlaylistname)
                .openPlaylist()
                .filledplaylistContextDelete();

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
