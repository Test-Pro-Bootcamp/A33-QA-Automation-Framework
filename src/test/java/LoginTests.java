import Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.support.PageFactory;
import Pages.LoginPage;

import java.time.Duration;

public class LoginTests extends BaseTest {

    @Test
    public void LoginEmptyEmailPasswordTest() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.enterEmail("");
        loginPage.enterPassword("");
        loginPage.submit();

        Assert.assertTrue(loginPage.getRegistrationLink());

    }
}
