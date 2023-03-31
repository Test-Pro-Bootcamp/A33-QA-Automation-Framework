package K_pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class LoginPage extends BasePage {

    //    locators ;

    @FindBy(css = "[type='submit']")
    WebElement submitButtonLocator;
    @FindBy (css = "[type='email']")
    WebElement emailFieldLocator;

    @FindBy(css="[type='password']")
    WebElement passwordFieldLocator;

    //    Constructor
    public LoginPage (WebDriver givenDriver) {
        super(givenDriver);
    }


    //    Page Methods Refactoring+Fluent Interface

    public LoginPage provideEmail (String email) {
     emailFieldLocator.sendKeys(email);
     return this;
    }

    public LoginPage providePassword (String password) {
        passwordFieldLocator.sendKeys(password);
        return this;
    }

    public LoginPage clickSubmitBtn () {
        submitButtonLocator.click();
        return this;
    }
    public void login () {
        provideEmail("krista_ua86@gmail.com");
        providePassword("te$t$tudent");
        clickSubmitBtn();
    }


}