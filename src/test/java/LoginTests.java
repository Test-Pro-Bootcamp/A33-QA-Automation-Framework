import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.LoginPage;

import java.time.Duration;

public class LoginTests extends BaseTest {

    @Test
    public void LoginEmptyEmailPasswordTest (){
        // Simple comment
        LoginPage loginPage = new LoginPage(getDriver());
        BasePage basePage = new BasePage(getDriver());
        basePage.navigateToPage(homeUrl);
        loginPage.loginWithValidCredentials("", "");
        Assert.assertEquals(getDriver().getCurrentUrl(), homeUrl);
        System.out.println("Tried to login with empty email and password. I'm on " +
                getDriver().getCurrentUrl() + " page");
    }

    @Test
    public void LoginInvalidEmail() {
        //Login Not Existing Email:
        //Precondition: Chrome browser should be opened DONE
        // declare driver
        //Step1. Open koel login page DONE
        // tell driver to load koel page
        //Step2. Enter Not Existing email
        // find email field
        // click into email field
        // enter invalid email inside email field
        //Step3. Enter Correct password
        // find password field
        // click into password field
        // enter anything
        //Step4. Click Login button
        // find the login button
        // click the login button
        //Expected result: User should stay on login page
        // assert the present of email field

        LoginPage loginPage = new LoginPage(getDriver());
        BasePage basePage = new BasePage(getDriver());
        basePage.navigateToPage(homeUrl);
        loginPage.loginWithValidCredentials("cucaracha@class.com", "ayCaramba");
        Assert.assertEquals(getDriver().getCurrentUrl(), homeUrl);
        System.out.println("Tried to login with incorrect email and password. I'm on " +
                getDriver().getCurrentUrl() + " page");
    }

    @Test
    public void LoginValidEmailPasswordTest() {
        // Precondition: Chrome browser should be opened DONE
        //Step1. Open koel login page DONE
        //Step2. Enter Existing username
        //Step3. Enter Correct password
        //Step4. Click Login button
        //Expected result: User should be directed to the home page
        LoginPage loginPage = new LoginPage(getDriver());
        BasePage basePage = new BasePage(getDriver());
        basePage.navigateToPage(homeUrl);
        loginPage.loginWithValidCredentials("demo@class.com", "te$t$tudent");
        System.out.println("Tried to login with correct email and password. I'm on " +
                getDriver().getCurrentUrl() + " page");
        WebElement avatar = getDriver().findElement(By.className("avatar"));
        Assert.assertTrue(avatar.isDisplayed());
    }
}
