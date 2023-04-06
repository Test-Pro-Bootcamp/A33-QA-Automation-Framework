import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {

    @Test
    public static void LoginValidEmailValidPasswordTest() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.logIn();
    }

    }



