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

    By submitbutton = By.cssSelector("button[type='submit']");
    By emaillocator = By.cssSelector("input[type='email']");
    By passwordlocator = By.cssSelector("input[type='password']");


    public void enterEmail(String email) {
        WebElement emailfield = wait.until(ExpectedConditions.elementToBeClickable(emaillocator));
        emailfield.sendKeys(email);
    }

    public void enterPassword(String password) {
        WebElement passwordfield = wait.until(ExpectedConditions.elementToBeClickable(passwordlocator));
        passwordfield.sendKeys(password);
    }

    public void submit() {
        WebElement submitbtn = wait.until(ExpectedConditions.elementToBeClickable(submitbutton));
        submitbtn.click();
    }

    public void login() {
        enterEmail("maxim.ibon@gmail.com");
        enterPassword("te$t$tudent1");
        submit();
    }

    @Test(priority = 1)
    public void loginValidCredentials() {
        enterEmail("maxim.ibon@gmail.com");
        enterPassword("te$t$tudent1");
        submit();
        WebElement avatar = driver.findElement(cssSelector("img[class='avatar']"));
        Assert.assertTrue(avatar.isDisplayed(), "Profile avatar is displayed");
    }

    @Test(priority = 2)
    public void loginInvalidCredentials() {
        enterEmail("maxim.ibon@mail.com");
        enterPassword("te$t$tuden");
        submit();
        WebElement loginform = driver.findElement(cssSelector("form[data-testid='login-form']"));
        Assert.assertTrue(loginform.isDisplayed(), "Login form is Displayed");
    }

    @Test
    public void loginEmailFieldisEmpty() {
        openLoginUrl();
        enterEmail("");
        enterPassword("te$t$tuden1");
        submit();
        WebElement loginform = driver.findElement(cssSelector("form[data-testid='login-form']"));
        Assert.assertTrue(loginform.isDisplayed(), "Login form is Displayed");
    }

    @Test
    public void loginPasswordFieldisEmpty() {
        enterEmail("maxim.ibon@mail.com");
        enterPassword("");
        submit();
        WebElement loginform = driver.findElement(cssSelector("form[data-testid='login-form']"));
        Assert.assertTrue(loginform.isDisplayed(), "Login form is Displayed");

    }
    @Test(enabled = false)
    public void loginInvalidEmail() {
        enterEmail("maxim.ibonmailcom");
    }
}
