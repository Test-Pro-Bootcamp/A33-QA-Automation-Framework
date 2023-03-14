import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends BaseTest {

    @Test
    public static void LoginEmptyEmailPasswordTest () throws InterruptedException {
        Assert.assertEquals(BaseTest.getDriver().getCurrentUrl(), BaseTest.url);
    }

    @Test
    public static void LoginInvalidEmail() {
        LoginPage loginPage = new LoginPage(BaseTest.getDriver());

        loginPage.provideEmail("cucaracha@class.com");
        loginPage.providePassword("ayCaramba");
        loginPage.clickSubmitButton();
        loginPage.isEmailFieldVisible();
    }

    @Test
    public static void LoginValidEmailPasswordTest() {
        LoginPage loginPage = new LoginPage(BaseTest.getDriver());
        HomePage homePage = new HomePage(BaseTest.getDriver());

        loginPage.provideEmail("demo@class.com");
        loginPage.providePassword("te$t$tudent");
        loginPage.clickSubmitButton();
        homePage.isUserAvatarDisplayed();
    }
}
