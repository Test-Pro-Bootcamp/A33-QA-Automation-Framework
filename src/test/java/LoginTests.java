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
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    @Test
    public void LoginValidEmailPasswordTest() {
//        loginPage.provideEmail("vera1077@gmail.com");
//        loginPage.providePassword("te$t$tudent");
//        loginPage.clickSubmitBtn();
        loginPage.login();
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }
}
