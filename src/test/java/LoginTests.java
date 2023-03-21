import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;



public class LoginTests extends BaseTest {

    @Test
    public void loginValidEmailPasswordTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login();
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }
}






