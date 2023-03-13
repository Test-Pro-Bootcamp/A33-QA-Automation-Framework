import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class Homework19 extends BaseTest {

    @Test
    public void deletePlaylistTest() {

        //GIVEN
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        String currentPlaylistname = "PLDELTEST";
        loginPage.inputLogIn(email, password);
        homePage.createPlaylist(currentPlaylistname);

        //THEN
        homePage.findPlaylist(currentPlaylistname);
        homePage.openPlaylist();
        homePage.deleteEmptyPlaylist();

        //WHEN
        Assert.assertTrue(homePage.getNotification().isDisplayed());
    }
}