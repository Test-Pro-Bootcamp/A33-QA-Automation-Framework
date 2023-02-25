import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static java.lang.System.getenv;

import java.time.Duration;


public class LoginTests extends BaseTest {

    @Test
    public void LoginValidEmailValidPasswordTest() {

        //setupBrowser();
        openLoginURL();
        System.out.println(getenv("Email"));
        inputEmail(getenv("Email"));
        inputPassword(getenv("Password"));
        clickLogin();
        Assert.assertEquals(driver.getCurrentUrl(), koelHome);
        //exitBrowser();
    }

    public void openLoginURL() {
        driver.get(koelStart);
    }

    public void inputEmail(String email) {
        emailField.sendKeys(email);
    }

    public void inputPassword(String pass) {
        passwordField.sendKeys(pass);
    }

    public void clickLogin() {
        loginButton.click();
    }


}
