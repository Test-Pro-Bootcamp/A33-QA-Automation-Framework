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

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {

    @FindBy(css = "[type='email']")
    public WebElement emailField;
    @FindBy(css = "[type='password']")
    public WebElement passwordField;
    @FindBy(css = "[type='submit']")
    public WebElement loginButton;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void provideEmail(String email) {
        emailField.click();
        emailField.sendKeys(email);
    }

    public void providePassword(String password) {
        passwordField.click();
        passwordField.sendKeys(password);
    }

    public void clickSubmitButton() {
        loginButton.click();
    }

    public void isEmailFieldVisible() {
        Assert.assertTrue(emailField.isDisplayed());
    }


}
