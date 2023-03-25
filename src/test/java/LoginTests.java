import com.sun.source.tree.AssertTree;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;
import pages.LoginPage;
import pages.HomePage;

public class LoginTests extends BaseTest {

    @Test
    public void loginValidEmailPasswordTest() {

        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());

        loginPage.provideEmail("regniermandy@gmail.com");
        loginPage.providePassword("te$t$tudent");
        loginPage.clickSubmitButton();

        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }
    @Test
    public void loginCorrectPasswordFluent() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());

        loginPage.provideEmail("regniermandy@gmail.com").providePassword("te$t$tudent").clickSubmitButton();
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }
    @Test
    public void loginEmptyEmailPasswordTest() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());

        loginPage.provideEmail("regniermandy@gmail.com");
        loginPage.providePassword("");
        loginPage.clickSubmitButton();
        Assert.assertEquals(url, url);
    }
    @Test
    public void loginIncorrectPasswordTest() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());

        loginPage.provideEmail("regniermandy@gmail.com");
        loginPage.providePassword("notpassword");
        loginPage.clickSubmitButton();
        Assert.assertEquals(url, url);
    }
    @Test
    public void loginIncorrectPasswordFluent() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());

        loginPage.provideEmail("regniermandy@gmail.com").providePassword("123password").clickSubmitButton();
        Assert.assertEquals(url, url);
    }

}


