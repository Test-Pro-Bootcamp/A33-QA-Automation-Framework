import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends BaseTest {

    @Test//(dataProvider = "loginData")
    public void LoginEmptyEmailPasswordTest() {

        LoginPage loginTest = new LoginPage(driver);
        HomePage findAvatar = new HomePage(driver);

        loginTest.enterEmail("linulya1411@gmail.com");
        loginTest.enterPassword("te$t$tudent");
        loginTest.clickSubmit();

        Assert.assertTrue(findAvatar.verifyAvatarIcon());
    }
}
