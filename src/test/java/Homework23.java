import Pages.HomePage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework23 extends BaseTest{
    @Test
    public void renamePlaylistTest(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage
                .enterEmail("vasilinapelo@gmail.com")
                .enterPassword("vasilina230109!")
                .clickSubmit();
        homePage
                .doubleClickPlaylist()
                .enterNewPlaylistName();
        Assert.assertTrue(homePage.checkNewPlaylist());
    }
}
