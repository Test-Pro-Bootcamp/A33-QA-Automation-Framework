import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {


    @FindBy(css = "[type='email']")
    WebElement provideEmail;
    @FindBy(css = "[type ='password']")
    WebElement providePassword;
    @FindBy(css = "[type = 'submit']")
    WebElement submitButton;

    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }


    public LoginPage submitButton() {
        submitButton.click();
        return this;
    }

    public LoginPage provideEmail(String email) {
        provideEmail.sendKeys(email);
        return this;
    }

    public LoginPage providePassword(String password) {
        providePassword.sendKeys(password);
        return this;
    }

    public void login() {
        provideEmail("guadalupe.medina@testpro.io");
        providePassword("DoingitBig23!");
        submitButton();
    }

}




