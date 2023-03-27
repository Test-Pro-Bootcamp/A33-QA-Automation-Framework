package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.interactions.Actions;
import java.time.Duration;

public class LoginPage extends BasePage{
           By emailField = By.cssSelector("[type='email']");
           By passwordField = By.cssSelector("[type='password']");
           By submitButton = By.cssSelector("[type='submit']");
        public LoginPage(WebDriver givenDriver) {
                super(givenDriver);
        }

        public void enterEmail(String email) {
             driver.findElement(emailField).sendKeys(email);
        }

        public void enterPassword(String password) {
            driver.findElement(passwordField).sendKeys(password);
        }

        public void submit() {
              driver.findElement(submitButton).click();
        }

        public void login(){
                enterEmail("rfkayoub12@gmail.com");
                enterPassword("te$t$tudent");
                submit();
        }


}
