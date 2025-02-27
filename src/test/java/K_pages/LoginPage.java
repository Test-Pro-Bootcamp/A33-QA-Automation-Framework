package K_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {

    //    locators
    By submitButtonLocator = By.cssSelector("[type='submit']");
    By emailFieldLocator = By.cssSelector("[type='email']");
    By passwordFieldLocator = By.cssSelector("[type='password']");

    //    Constructor
    public LoginPage (WebDriver givenDriver) {
        super(givenDriver);
    }


    //    Page Methods

    public void provideEmail (String email) {
     driver.findElement(emailFieldLocator).sendKeys(email);
    }

    public void providePassword (String password) {
        driver.findElement(passwordFieldLocator).sendKeys(password);
    }

    public void clickSubmitBtn () {
        driver.findElement(submitButtonLocator).click();
    }
    public void login () {
        provideEmail("krista_ua86@gmail.com");
        providePassword("te$t$tudent");
        clickSubmitBtn();
    }


}