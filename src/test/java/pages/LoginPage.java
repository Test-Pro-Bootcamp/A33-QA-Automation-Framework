package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

public class LoginPage extends BasePage {
    //locators
    private By enterEmailAddress = By.cssSelector(("[type = 'email']"));
    private By passwordField = By.cssSelector(("[type='password']"));
    private By submitButton = By.cssSelector(("[type='submit']"));
    public LoginPage(WebDriver givenDriver){
        super(givenDriver);
    }
    public void enterEmail(String email) {
        WebElement emailElement = wait.until(ExpectedConditions.elementToBeClickable(enterEmailAddress));
        emailElement.sendKeys(email);
    }
    public void enterPassword(String password) {
        WebElement passwordElement = wait.until(ExpectedConditions.elementToBeClickable(passwordField));
        passwordElement.sendKeys(password);
    }
    public void clickSubmit() {
        WebElement submitElement = wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        submitElement.click();
    }
}
