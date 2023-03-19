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
        WebDriver driver;
       WebDriverWait wait;

        public LoginPage(WebDriver givenDriver) {
                super(givenDriver);

        }

        public void enterEmail() {
                WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
                emailField.click();
                emailField.sendKeys("rfkayoub12@gmail.com");
        }

        public void enterPassword() {
                WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
                passwordField.click();
                passwordField.sendKeys("te$t$tudent");
        }

        public void submit() {
                // WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
                wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='submit']"))).click();
                //submitButton.click();
        }

        public void login(){
                enterEmail();
                enterPassword();
                submit();
        }


}
