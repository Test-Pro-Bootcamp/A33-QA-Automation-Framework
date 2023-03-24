package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    //locators
    @FindBy (css = "[type = 'email']")
    protected WebElement emailLocator;
    @FindBy (css = "[type = 'password']")
    protected WebElement passwordLocator;
    @FindBy (css = "button[type = 'submit']")
    protected WebElement submitLocator;

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
