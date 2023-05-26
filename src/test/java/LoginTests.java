import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends BaseTest {

    @Test
    public void LoginSuccessTest() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.provideEmail("krista_ua86@gmail.com");
        loginPage.providePassword("te$t$tudent");
        loginPage.clickSubmitButton();
        homePage.isUserAvatarDisplayed();
    }
    @Test

    public void LoginEmptyEmailPasswordTest (){
        Assert.assertEquals(getDriver().getCurrentUrl(), url);
    }

    @Test
    public void LoginInvalidEmail() {
        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.provideEmail("k_ua86@.com");
        loginPage.providePassword("te$t$tuden");
        loginPage.clickSubmitButton();
        loginPage.isEmailFieldVisible();
    }


}
