package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.FindBy;
import java.time.Duration;
public class LoginPage extends BasePage {
    @FindBy (css = "[type='email']")
        WebElement emailField;
    @FindBy (css = "[type='password']")
        WebElement passwordField;
    @FindBy (css = "[type='submit']")
        WebElement submitButton;


    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }
//page methods
    public LoginPage provideEmail(String email) {
        emailField.sendKeys(email);
        return this;
    }
    public LoginPage providePassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }
    public LoginPage clickSubmitBtn() {
        submitButton.click();
        return this;
    }
    public void login() {
        provideEmail("vera1077@gmail.com");
        providePassword("te$t$tudent");
        clickSubmitBtn();
    }
}
