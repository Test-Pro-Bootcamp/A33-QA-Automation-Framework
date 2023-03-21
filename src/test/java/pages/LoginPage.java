package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Parameters;

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
        System.out.println(email);
        System.out.println(password);
        emailLocator.sendKeys(email);
        passwordLocator.sendKeys(password);
        submitLocator.click();
        return this;
    }

}
