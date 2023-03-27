import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public class LoginTests extends BaseTest {

    @Test(enabled = true, priority = 0, description = "Login with valid email and password")
    public void loginWithValidCredentialsTest(){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.login();
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }
    @Test (enabled = true, priority = 1, description = "Login with invalid email and valid password" )
    public void loginWithInvalidEmailAndValidPasswordTest(){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        loginPage.provideEmail("invalidemail@yahoo.com").providePassword("te$t$tudent").clickSubmitButton();
        Assert.assertEquals(url, url);
    }
    @Test (enabled = true, priority = 2, description = "Login with valid email and invalid password" )
    public void loginWithValidEmailAndInvalidPasswordTest(){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        loginPage.provideEmail("nelena35@yahoo.com").providePassword("invalidpassword").clickSubmitButton();
        Assert.assertEquals(url, url);
    }
    @Test (enabled = true, priority = 3, description = "Login with empty email and password" )
    public void loginWithEmptyEmailAndPasswordTest(){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        loginPage.provideEmail(" ").providePassword(" ").clickSubmitButton();
        Assert.assertEquals(url, url);
    }

}
