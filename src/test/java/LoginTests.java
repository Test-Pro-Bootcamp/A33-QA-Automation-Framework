import Pages.LoginPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.openqa.selenium.By.cssSelector;

public class LoginTests extends BaseTest {

    LoginPage loginpage = new LoginPage(driver);

    @Test(priority = 1)
    public void loginValidCredentials() {
        loginpage.enterEmail("maxim.ibon@gmail.com")
        .enterPassword("te$t$tudent1")
        .submit();
        WebElement avatar = driver.findElement(cssSelector("img[class='avatar']"));
        Assert.assertTrue(avatar.isDisplayed(), "Profile avatar is displayed");
    }

    @Test(priority = 2)
    public void loginInvalidCredentials() {
        loginpage.enterEmail("maxim.ibon@mail.com")
       .enterPassword("te$t$tuden")
        .submit();
        WebElement loginform = driver.findElement(cssSelector("form[data-testid='login-form']"));
        Assert.assertTrue(loginform.isDisplayed(), "Login form is Displayed");
    }

    @Test
    public void loginEmailFieldisEmpty() {
        loginpage.enterEmail("")
        .enterPassword("te$t$tuden1")
        .submit();
        WebElement loginform = driver.findElement(cssSelector("form[data-testid='login-form']"));
        Assert.assertTrue(loginform.isDisplayed(), "Login form is Displayed");
    }

    @Test
    public void loginPasswordFieldisEmpty() {
        loginpage.enterEmail("maxim.ibon@mail.com")
        .enterPassword("")
        .submit();
        WebElement loginform = driver.findElement(cssSelector("form[data-testid='login-form']"));
        Assert.assertTrue(loginform.isDisplayed(), "Login form is Displayed");
    }
}
