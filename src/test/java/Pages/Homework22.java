package Pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework22 extends BasePage {
    public Homework22(WebDriver givenDriver) {
        super(givenDriver);
    }

    @Test
    public void renamePlaylist(){
        String playlistName = "Test Pro Playlist";
        LoginPage loginPage = new LoginPage(BasePage.driver);
        HomePage homePage = new HomePage(BasePage.driver);

        loginPage.login();
        homePage.doubleCLickFirstPlaylist();
        homePage.enterPlaylistName(playlistName);
        Assert.assertTrue(homePage.doesPlaylistExist(playlistName));
    }
}
