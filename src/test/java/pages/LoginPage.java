package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage{
    private By emailFieldInput = By.cssSelector("[type = 'email']");
    private By passwordFieldInput = By.cssSelector("[type = 'password']");
    private By submitButton = By.cssSelector("button[type = 'submit']");

    public LoginPage(WebDriver givenDriver){super(givenDriver);}

    public void provideEmail (String email){driver.findElement(emailFieldInput).sendKeys(email);}
    public void providePassword (String password){driver.findElement(passwordFieldInput).sendKeys(password);}
    public void clickSubmitButton(){driver.findElement(submitButton).click();}
    public void login(){
        provideEmail("nelena35@yahoo.com");
        providePassword("te$t$tudent");
        clickSubmitButton();
    }
}
