package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class LoginPage extends BasePage{
    @FindBy(css = "button[type='submit']")
            WebElement submitbutton;
    @FindBy(css = "input[type='email']")
    WebElement emaillocator;
    @FindBy(css = "input[type='password']")
    WebElement passwordlocator;
   

    public LoginPage(WebDriver givenDriver) {

        super(givenDriver);
    }

    public LoginPage enterEmail(String email) {
        emaillocator.sendKeys(email);
        return this;
    }
    public LoginPage enterPassword(String password) {
        passwordlocator.sendKeys(password);
        return this;
    }
    public LoginPage submit() {
        submitbutton.click();
        return this;
    }
    public void login() {
        enterEmail("maxim.ibon@gmail.com");
        enterPassword("te$t$tudent1");
        submit();
    }

}
