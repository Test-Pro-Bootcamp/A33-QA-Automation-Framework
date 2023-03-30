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

    @Test

    public class LoginPage {
        private WebDriver driver;

        @FindBy(id = "username")
        private WebElement usernameInput;

        @FindBy(id = "password")
        private WebElement passwordInput;

        @FindBy(id = "login-button")
        private WebElement loginButton;

        public LoginPage(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
        }

        public LoginPage enterUsername(String username) {
            usernameInput.sendKeys(username);
            return this;
        }

        public LoginPage enterPassword(String password) {
            passwordInput.sendKeys(password);
            return this;
        }

        public DashboardPage clickLoginButton() {
            loginButton.click();
            return new DashboardPage(driver);
        }
    }
}
