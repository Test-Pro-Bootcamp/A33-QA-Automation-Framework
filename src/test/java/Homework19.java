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

        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        String currentPlaylistname = "PLDELTEST";
        loginPage.inputLogIn(email, password);
        homePage.createPlaylist(currentPlaylistname)
                .deleteEmptyPlaylist();

        Assert.assertTrue(homePage.getNotification().isDisplayed());
    }
}