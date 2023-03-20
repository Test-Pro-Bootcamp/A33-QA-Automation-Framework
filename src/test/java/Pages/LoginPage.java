package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{
    static By emailFieldLocator = By.cssSelector("[type='email']");
    static By passwordFieldLocator = By.cssSelector("[type='password']");
    static By submitButtonLocator = By.cssSelector("button[type='submit']");

    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    public static void provideEmail(String email){
        driver.findElement(emailFieldLocator).sendKeys(email);

    }
    public static void providePassword(String password){
        driver.findElement(passwordFieldLocator).sendKeys(password);
    }
    public static void clickSubmitBtn(){
        driver.findElement(submitButtonLocator).click();

    }
    public void login(){
    provideEmail("andalia.nia@gmail.com");
    providePassword("te$t$tudent");
    clickSubmitBtn();
    }

}
