
import K_pages.LoginPage;
import K_pages.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserProfileTests extends BaseTest {


    @Test
    public void changeCurrentTheme () {
        LoginPage loginPage = new LoginPage(driver);
        ProfilePage profilePage = loginPage.provideEmail()
                .providePassword()
                .clickSubmitBtn()
                .clickProfileIcon()
                .chooseJungleTheme();

        Assert.assertTrue(profilePage.isJungleThemeSelected());
    }
}
