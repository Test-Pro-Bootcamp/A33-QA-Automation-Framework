import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import org.openqa.selenium.support.FindBy;

public class LoginTests extends BaseTest {


    @Test(enabled = false, dataProvider = "incorrectLoginData")
    public void LoginIncorrectCredentials(String email, String password) {
        // navigateToPage("https://bbb.testpro.io/");
        driver.get(url);
        // Login to the Homepage Koel
        provideEmail(email);
        providePassword(password);
        clickSubmit();


        Assert.assertEquals(driver.getCurrentUrl(), url);

        public void LoginValidCredentials () {
            LoginPage loginPage = new LoginPage(driver);
            HomePage homePage = new HomePage(driver);

        }

    }
}
