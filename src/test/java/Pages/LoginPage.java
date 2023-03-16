package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class LoginPage  extends BasePage{


    @FindBy(css="[type='submit']")
    WebElement submitButton;
    @FindBy(css="[type='email']")
    WebElement emailField;
    @FindBy(css="[type='password']")
    WebElement passwordField;

    @FindAll({
            @FindBy(id = "books-wrapper"),
            @FindBy(id = "userName-value]"),
    })
    WebElement xyz;

//    By emailFieldLocator = By.cssSelector("[type='email']");
//    By passwordFieldLocator = By.cssSelector("[type='password']");
//    By submitButtonLocator = By.cssSelector("[type='submit']");

    public LoginPage(WebDriver givenDriver){
        super(givenDriver);
    }


    public LoginPage provideEmail(String email){
        emailField.sendKeys(email);
        return this;

        //driver.findElement(emailFieldLocator).sendKeys(email);
    }

    public LoginPage providePassword(String password){
        passwordField.sendKeys(password);
        return this;
        //driver.findElement(passwordFieldLocator).sendKeys(password);
    }

    public LoginPage clicksubmit() {
        submitButton.click();
        return this;
    }


    public void login(){
//        provideEmail("valentineguts@gmail.com");
//        providePassword("te$t$tudent");
//        clicksubmit();

        provideEmail("valentineguts@gmail.com").providePassword("te$t$tudent").clicksubmit();
//    this method (fluent) works only if with a return inside the method we are calling;

    }








}
