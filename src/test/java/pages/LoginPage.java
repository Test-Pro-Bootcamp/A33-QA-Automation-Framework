package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
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
