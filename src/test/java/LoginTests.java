import Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.openqa.selenium.By.cssSelector;

public class LoginTests extends BaseTest {

    LoginPage loginpage = new LoginPage(driver);

    @Test(priority = 1)
    public void loginValidCredentials() {
        loginpage.enterEmail("maxim.ibon@gmail.com");
        loginpage.enterPassword("te$t$tudent1");
        loginpage.submit();
        WebElement avatar = driver.findElement(cssSelector("img[class='avatar']"));
        Assert.assertTrue(avatar.isDisplayed(), "Profile avatar is displayed");
    }

    @Test(priority = 2)
    public void loginInvalidCredentials() {
        loginpage.enterEmail("maxim.ibon@mail.com");
        loginpage.enterPassword("te$t$tuden");
        loginpage.submit();
        WebElement loginform = driver.findElement(cssSelector("form[data-testid='login-form']"));
        Assert.assertTrue(loginform.isDisplayed(), "Login form is Displayed");
    }

    @Test
    public void loginEmailFieldisEmpty() {
        loginpage.enterEmail("");
        loginpage.enterPassword("te$t$tuden1");
        loginpage.submit();
        WebElement loginform = driver.findElement(cssSelector("form[data-testid='login-form']"));
        Assert.assertTrue(loginform.isDisplayed(), "Login form is Displayed");
    }

    @Test
    public void loginPasswordFieldisEmpty() {
        loginpage.enterEmail("maxim.ibon@mail.com");
        loginpage.enterPassword("");
        loginpage.submit();
        WebElement loginform = driver.findElement(cssSelector("form[data-testid='login-form']"));
        Assert.assertTrue(loginform.isDisplayed(), "Login form is Displayed");
    }
}
