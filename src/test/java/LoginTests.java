import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {

    @Test//(dataProvider = "loginData")
    public void LoginEmptyEmailPasswordTest() {

        LoginPage loginTest = new LoginPage(driver);
        HomePage findAvatar = new HomePage(driver);

        loginTest.enterEmail("linulya1411@gmail.com");
        loginTest.enterPassword("te$t$tudent");
        loginTest.clickSubmit();

        Assert.assertTrue(findAvatar.verifyAvatarIcon());
    }
}
