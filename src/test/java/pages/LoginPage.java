package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class LoginPage extends BasePage {
    //locators
    @FindBy(css = "[type = 'email']")
    private WebElement enterEmailAddress;
    @FindBy(css = "[type='password']")
    private WebElement passwordField;
    @FindBy(css = "[type='submit']")
    private WebElement submitButton;
    public LoginPage(WebDriver givenDriver){
        super(givenDriver);
    }
    public void enterEmail(String email) {
        enterEmailAddress.sendKeys(email);
    }
    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }
    public void clickSubmit() {
        submitButton.click();
    }
}
