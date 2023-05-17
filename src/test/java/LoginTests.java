import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;
import pages.*;
public class LoginTests extends BaseTest {
    @Test
    public void LoginValidEmailPasswordTest() {
    LoginPage loginPage = new LoginPage(getDriver());
    HomePage homePage = new HomePage(getDriver());
    loginPage.login();
    Assert.assertTrue(homePage.isUserAvatarDisplayed());
    }
}