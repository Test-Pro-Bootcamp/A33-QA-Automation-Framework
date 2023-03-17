package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    By enterEmailLocator = By.cssSelector("[type='email']");
    By enterPasswordLocator = By.cssSelector("[type='password']");
    By submitButtonLocator = By.cssSelector("button[type='submit']");

    public LoginPage(WebDriver givenDriver){
        super(givenDriver);
    }
    public void enterEmail(String email) {
        WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(enterEmailLocator));
        emailField.click();
        emailField.sendKeys(email);
    }

    public void enterPassword(String password) {
        WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(enterPasswordLocator));
        passwordField.click();
        passwordField.sendKeys(password);
    }

    public void clickSubmit() {
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(submitButtonLocator));
        submitButton.click();
    }

    public void logIn(){
        enterEmail("vasilinapelo@gmail.com");
        enterPassword("vasilina230109!");
        clickSubmit();
    }

}
