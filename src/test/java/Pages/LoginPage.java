package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(css ="[type = 'email']" )
    WebElement emailFieldInput;
    @FindBy(css = "[type = 'password']")
    WebElement passwordFieldInput;
    @FindBy(css = "[type = 'submit']")
    WebElement submitButton;
    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public LoginPage provideEmail(String email) {
        emailFieldInput.sendKeys(email);
        return this;
    }

    public LoginPage providePassword(String password) {
        passwordFieldInput.sendKeys(password);
        return this;
    }

    public LoginPage clickSubmitButton() {
        submitButton.click();
        return this;
    }

    public void login() {
        provideEmail("taqimed99@gmail.com");
        providePassword("Med-20115-010499@");
        clickSubmitButton();
    }
}