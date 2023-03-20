package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    By emailFieldLocator = By.cssSelector("[type='email']");
    By passwordFieldLocator = By.cssSelector("[type='password']");
    By submitButtonLocator = By.cssSelector("button[type='submit']");

    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    public void provideEmail(String email) {
        driver.findElement(emailFieldLocator).sendKeys(email);
    }
    public void  providePassword(String password) {
        driver.findElement(passwordFieldLocator).sendKeys(password);
    }
    public void clickSubmitBtn() {
        driver.findElement(submitButtonLocator).click();
    }
    public void login(){
        provideEmail("demo@TestPro30");
        providePassword("testpro123!");
        clickSubmitBtn();
    }
}
