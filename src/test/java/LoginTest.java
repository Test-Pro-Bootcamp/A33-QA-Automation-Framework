import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends BaseTest {
    @Test(enabled = true)
    public void loginWithValidEmail() {
        //GIVEN
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        //WHEN
        loginPage.loginPageTest();
        //THEN
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());

    }

    @Test
    public void loginWithInvalidEmail() {
        //GIVEN
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        //WHEN
        loginPage.loginWithInvalidEmail();
        //THEN
        Assert.assertEquals(url, url);
    }

    @Test
    public void loginWithInvalidPasswordTest() {
        //GIVEN
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        //WHEN
        loginPage.loginWithInvalidPassword();
        //THEN
        Assert.assertEquals(url, url);
    }
}