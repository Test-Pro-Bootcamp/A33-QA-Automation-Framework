package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage{

    //locators
    static By emailLocator = By.cssSelector(("[type = 'email']"));
    static By passwordLocator = By.cssSelector("[type = 'password']");
    static By submitLocator = By.cssSelector("button[type = 'submit']");

    public LoginPage(WebDriver submittedDriver) {
        super(submittedDriver);
    }

    public static void loginWithValidCredentials (String email, String password){
        System.out.println(email);
        System.out.println(password);
        WebElement emailEl = findElement(emailLocator);
        emailEl.sendKeys(email);
        WebElement passwdEl = findElement(passwordLocator);
        passwdEl.sendKeys(password);
        clickElement(submitLocator);
    }

}
