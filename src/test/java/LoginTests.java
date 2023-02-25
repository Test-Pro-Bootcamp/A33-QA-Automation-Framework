import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {

    public void openLoginUrl() {
        String url = "https://bbb.testpro.io";
        driver.get(url);
    }

    public void enterEmail(String email) {
        WebElement emailfield = driver.findElement(By.cssSelector("input[type='email']"));
        emailfield.sendKeys(email);
    }

    public void enterPassword(String password) {
        WebElement passwordfield = driver.findElement(By.cssSelector("input[type='password']"));
        passwordfield.sendKeys(password);
    }

    public void submit() {
        WebElement submitbtn = driver.findElement(By.cssSelector("button[type='submit']"));
        submitbtn.click();
    }

    public void login() {
        enterEmail("maxim.ibon@gmail.com");
        enterPassword("te$t$tudent1");
        submit();
    }

    @Test(priority = 1)
    public void loginValidCredentials() {
        openLoginUrl();
        enterEmail("maxim.ibon@gmail.com");
        enterPassword("te$t$tudent1");
        submit();
        WebElement avatar = driver.findElement(By.cssSelector("img[class='avatar']"));
        Assert.assertTrue(avatar.isDisplayed(), "Profile avatar is displayed");
    }

    @Test(priority = 2)
    public void loginInvalidCredentials() {
        openLoginUrl();
        enterEmail("maxim.ibon@mail.com");
        enterPassword("te$t$tuden");
        submit();
        WebElement loginform = driver.findElement(By.cssSelector("form[data-testid='login-form']"));
        Assert.assertTrue(loginform.isDisplayed(), "Login form is Displayed");
    }

    @Test
    public void loginEmailFieldisEmpty() {
        openLoginUrl();
        enterEmail("");
        enterPassword("te$t$tuden1");
        submit();
        WebElement loginform = driver.findElement(By.cssSelector("form[data-testid='login-form']"));
        Assert.assertTrue(loginform.isDisplayed(), "Login form is Displayed");
    }

    @Test
    public void loginPasswordFieldisEmpty() {
        openLoginUrl();
        enterEmail("maxim.ibon@mail.com");
        enterPassword("");
        submit();
        WebElement loginform = driver.findElement(By.cssSelector("form[data-testid='login-form']"));
        Assert.assertTrue(loginform.isDisplayed(), "Login form is Displayed");

    }
    @Test(enabled = false)
    public void loginInvalidEmail() {
        openLoginUrl();
        enterEmail("maxim.ibonmailcom");
    }
}
