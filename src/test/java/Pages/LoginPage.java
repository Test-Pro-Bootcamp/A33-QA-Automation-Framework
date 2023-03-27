package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    @FindBy(css = "[type='email']" )
            WebElement emailField;
    @FindBy(css = "[type='password']" )
            WebElement passwordField;
    @FindBy(css = "[type='submit']" )
    WebElement submitButton;
        public LoginPage(WebDriver givenDriver) {
                super(givenDriver);
        }
        public LoginPage enterEmail(String email) {
             emailField.sendKeys(email);
             return this;
        }
        public LoginPage enterPassword(String password) {
            passwordField.sendKeys(password);
            return this;
        }
        public LoginPage submit() {
              submitButton.click();
            return this;
        }
        public void login(){
                enterEmail("rfkayoub12@gmail.com");
                enterPassword("te$t$tudent");
                submit();
        }
}
