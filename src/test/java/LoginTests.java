import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends BaseTest {
//trying homework
    
    @Test
    public void LoginEmptyEmailPasswordTest () throws InterruptedException {
        Assert.assertEquals(getDriver().getCurrentUrl(), url);
    }

    @Test
    public void LoginInvalidEmail() {
        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.provideEmail("cucaracha@class.com");
        loginPage.providePassword("ayCaramba");
        loginPage.clickSubmitButton();
        loginPage.isEmailFieldVisible();
    }

    @Test
    public void LoginValidEmailPasswordTest() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.provideEmail("demo@class.com");
        loginPage.providePassword("te$t$tudent");
        loginPage.clickSubmitButton();
        homePage.isUserAvatarDisplayed();
    }
}
