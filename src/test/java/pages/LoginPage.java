package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage{
    @FindBy(css = "[type = 'email']")
    private WebElement emailFieldInput;
    @FindBy(css = "[type = 'password']")
    private WebElement passwordFieldInput;
    @FindBy(css = "button[type = 'submit']")
    private WebElement submitButton;
    public LoginPage(WebDriver givenDriver){super(givenDriver);}

    public LoginPage provideEmail (String email){
        emailFieldInput.sendKeys(email);
        return this;
    }
    public LoginPage providePassword (String password){
        passwordFieldInput.sendKeys(password);
        return this;
    }
    public LoginPage clickSubmitButton(){
        submitButton.click();
        return this;
    }
    public void login(){
        provideEmail("nelena35@yahoo.com");
        providePassword("te$t$tudent");
        clickSubmitButton();
    }
}
