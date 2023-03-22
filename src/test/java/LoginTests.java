import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;


public class LoginTests extends BaseTest {

    @Test
    public void LoginEmptyEmailPasswordTest() {
        String url = "https://bbb.testpro.io/";
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @Test
    public void LoginInvalidEmail() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.provideEmail("cucaracha@class.com");
        loginPage.providePassword("ayCaramba");
        loginPage.clickSubmitButton();
        loginPage.isEmailFieldVisible();
    }

    @Test
    public void LoginValidEmailPasswordTest() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        String url = "https://bbb.testpro.io/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.quit();

        loginPage.provideEmail("demo@class.com");
        loginPage.providePassword("te$t$tudent");
        loginPage.clickSubmitButton();
        homePage.isUserAvatarDisplayed();

    }
}