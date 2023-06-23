import Pages.HomePage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class KoelLogin extends BaseTest{
    @Test
    public void loginWithValidCredentials(){
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        loginPage.provideEmail("");
        loginPage.providePassword("");
        loginPage.clickSubmit();

        Assert.assertTrue(homePage.navigateToHomePage());
    }
}
