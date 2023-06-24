import Pages.HomePage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class KoelLogin extends BaseTest{
    @Test
    public void loginWithValidCredentials(){
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        loginPage.provideEmail("taqimed99@gmail.com");
        loginPage.providePassword("Med-20115-010499@");
        loginPage.clickSubmit();

        Assert.assertTrue(homePage.navigateToHomePage());
    }
    @Test
    public void loginWithUnregisteredEmail(){
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        loginPage.provideEmail("taqimed9@gmail.com");
        loginPage.providePassword("Med-20115-010499@");
        loginPage.clickSubmit();

        Assert.assertTrue(homePage.navigateLoginPage());
    }
    @Test
    public void loginWithUpdatedEEmail(){
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        loginPage.provideEmail("taqimed99@gmail.com");
        loginPage.providePassword("Med-20115-010499@");
        loginPage.clickSubmit();

        Assert.assertTrue(homePage.navigateToHomePage());
    }
    @Test
    public void loginWithOldEmail(){
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        loginPage.provideEmail("taqimed99a@gmail.com");
        loginPage.providePassword("Med-20115-010499@");
        loginPage.clickSubmit();

        Assert.assertTrue(homePage.navigateLoginPage());
    }
    @Test
    public void loginWithUpdatedPassword(){
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        loginPage.provideEmail("taqimed99@gmail.com");
        loginPage.providePassword("Med-20115-010499@");
        loginPage.clickSubmit();

        Assert.assertTrue(homePage.navigateToHomePage());
    }
    @Test
    public void loginWithOldPassword(){
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        loginPage.provideEmail("taqimed99@gmail.com");
        loginPage.providePassword("Med-20115-010499@l");
        loginPage.clickSubmit();

        Assert.assertTrue(homePage.navigateLoginPage());
    }
    @Test
    public void loginWithEmailWithoutSymbol(){
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        loginPage.provideEmail("taqimed99gmail.com");
        loginPage.providePassword("Med-20115-010499@");
        loginPage.clickSubmit();

        Assert.assertTrue(homePage.navigateToHomePage());
    }
    @Test
    public void loginWithEmailWithoutDot(){
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        loginPage.provideEmail("taqimed99@gmailcom");
        loginPage.providePassword("Med-20115-010499@");
        loginPage.clickSubmit();

        Assert.assertTrue(homePage.navigateLoginPageError());
    }
    @Test
    public void loginWithEmailWithoutDomain(){
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        loginPage.provideEmail("taqimed99@gmail.");
        loginPage.providePassword("Med-20115-010499@");
        loginPage.clickSubmit();

        Assert.assertTrue(homePage.navigateLoginPage());
    }
    @Test
    public void loginWithInvalidPassword(){
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        loginPage.provideEmail("taqimed99@gmail.com");
        loginPage.providePassword("Med-20115-010499");
        loginPage.clickSubmit();

        Assert.assertTrue(homePage.navigateLoginPage());
    }
    @Test
    public void loginWithEmptyEmailAndPasswordFields(){
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        loginPage.provideEmail("");
        loginPage.providePassword("");
        loginPage.clickSubmit();

        Assert.assertTrue(homePage.navigateLoginPage());
    }
}
