package K_pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LoginPage extends BasePage {

    //    locators ;

    @FindBy (css = "[type='submit']")
    WebElement submitButtonLocator;
    @FindBy (css = "[type='email']")
    private WebElement emailFieldLocator;

    @FindBy (css = "[type='password']")
    private WebElement passwordFieldLocator;
    @FindBy (css = "a.view-profile")
    WebElement profileIcon;

    //    Constructor
    public LoginPage (WebDriver givenDriver) {

        super(givenDriver);
    }


    //    Page Methods Refactoring+Fluent Interface

    public LoginPage provideEmail () {
        emailFieldLocator.sendKeys("krista_ua86@gmail.com");
        return this;
    }

    public LoginPage providePassword () {
        passwordFieldLocator.sendKeys("te$t$tudent");
        return this;
    }

    public LoginPage clickSubmitBtn () {
        submitButtonLocator.click();
        return this;
    }

//    public void login () {
//        provideEmail("krista_ua86@gmail.com");
//        providePassword("te$t$tudent");
//        clickSubmitBtn();
//    }
    public ProfilePage clickProfileIcon() {
        profileIcon.click();
        return new ProfilePage(driver);
    }


}