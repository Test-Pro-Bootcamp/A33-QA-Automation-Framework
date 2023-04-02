package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage{

    //locators
    @FindBy (css = "[type = 'email']")
    protected WebElement emailLocator;
    @FindBy (css = "[type = 'password']")
    protected WebElement passwordLocator;
    @FindBy (css = "button[type = 'submit']")
    protected WebElement submitLocator;
    @FindBy (css = "#homeWrapper")
    protected WebElement songsOnHomePage;
    @FindBy (css = "div.login-wrapper form")
    protected WebElement loginForm;

    public LoginPage(WebDriver submittedDriver) {
        super(submittedDriver);
    }

    public LoginPage loginWithValidCredentials (String email, String password){
        emailLocator.clear();
        emailLocator.sendKeys(email);
        passwordLocator.clear();
        passwordLocator.sendKeys(password);
        submitLocator.click();
        return this;
    }

}
