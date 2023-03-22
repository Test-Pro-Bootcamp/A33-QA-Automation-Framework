import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends BaseTest {

    @Test
    public void LoginEmptyEmailPasswordTest () throws InterruptedException {
        Assert.assertEquals(getDriver().getCurrentUrl(), url);
    }

    @Test
    public void LoginInvalidEmail() {
        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.provideEmail("janezelenova@gmail.com");
        loginPage.providePassword("Floridaliving2020$");
        loginPage.clickSubmitButton();
        loginPage.isEmailFieldVisible();
    }

    @Test
    public void LoginValidEmailPasswordTest() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.provideEmail("janezelenova@gmail.com");
        loginPage.providePassword("Floridaliving2023$");
        loginPage.clickSubmitButton();
        homePage.isUserAvatarDisplayed();
    }
}
