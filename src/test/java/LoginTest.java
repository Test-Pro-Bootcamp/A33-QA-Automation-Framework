import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends BaseTest {
    @Test(enabled = true)
    public void loginWithValidEmail() {
        //GIVEN
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        //WHEN
        loginPage.loginPageTest();
        //THEN
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());

    }

    @Test
    public void loginWithInvalidEmail() {
        //GIVEN
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        //WHEN
        loginPage.loginWithInvalidEmail();
        //THEN
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }

    @Test
    public void loginWithInvalidPasswordTest() {
        //GIVEN
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        //WHEN
        loginPage.loginWithInvalidPassword();
        //THEN
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }
}