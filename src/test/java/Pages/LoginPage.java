package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    @FindBy(css = "[type='email']")
    WebElement emailField;
    @FindBy(css = "[type='password']")
    WebElement passwordField;
    @FindBy(css = "[type='submit']")
    WebElement submit;
    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    public LoginPage provideEmail(String email){
        emailField.sendKeys(email);
        return this;
    }
    public LoginPage providePassword(String password){
        passwordField.sendKeys(password);
        return this;
    }
    public LoginPage clickSubmit(){
        submit.click();
        return this;
    }
}
