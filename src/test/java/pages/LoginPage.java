package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
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


    public LoginPage (WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
//page methods
    public void provideEmail(String email) {
        emailField.click();
        emailField.sendKeys(email);
    }
    public void providePassword(String password) {
        passwordField.click();
        passwordField.sendKeys(password);
    }
    public void clickSubmitBtn() {
        submitButton.click();
    }
    public void login() {
        provideEmail("vera1077@gmail.com");
        providePassword("te$t$tudent");
        clickSubmitBtn();
    }
}
