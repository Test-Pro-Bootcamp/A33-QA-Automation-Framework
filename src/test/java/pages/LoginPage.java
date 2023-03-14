package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.FindAll;

import java.time.Duration;

public class LoginPage extends BasePage {
    //WebElements
    @FindBy(css = "[type='submit']")
    WebElement submitButton;
    @FindBy(css = "[type='email']")
    WebElement emailField;
    @FindBy(css = "[type='password']")
    WebElement passwordField;

    public LoginPage (WebDriver givenDriver) {
        super(givenDriver);
    }
    public LoginPage provideEmail(String email) {
        emailField.sendKeys(email);
        return this;
    }
    public LoginPage providePassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }
    public LoginPage clickSubmitButton() {
        submitButton.click();
        return this;
    }
    public void logIn() {
        provideEmail("regniermandy@gmail.com");
        providePassword("te$t$tudent");
        clickSubmitButton();
    }
}
